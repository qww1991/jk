package cn.itcast.jk.action.befor;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Feedback;
import cn.itcast.jk.domain.SubjectInfo;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.service.FeedbackService;
import cn.itcast.jk.service.SubjectInfoService;
import cn.itcast.jk.service.UserService;
import cn.itcast.util.Page;
import cn.itcast.util.SysConstant;

/**
 * 
 * @author 龙殇
 * @CreateDate:	2017年11月18日
 */
public class TaskAction extends BaseAction implements ModelDriven<Feedback>{
	
	private String fbId;
	
	public String getFbId() {
		return fbId;
	}

	public void setFbId(String fbId) {
		this.fbId = fbId;
	}

	private Page page = new Page();
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	private SubjectInfoService subjectInfoService;
	
	public void setSubjectInfoService(SubjectInfoService subjectInfoService) {
		this.subjectInfoService = subjectInfoService;
	}

	private UserService userService;
	
	private String strInfo;
	
	public String getStrInfo() {
		return strInfo;
	}

	public void setStrInfo(String strInfo) {
		this.strInfo = strInfo;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private String strId;
	
	public String getStrId() {
		return strId;
	}

	public void setStrId(String strId) {
		this.strId = strId;
	}

	private FeedbackService feedbackService;
	
	public void setFeedbackService(FeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}

	private Feedback model = new Feedback();
	@Override
	public Feedback getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	public String list() throws Exception{
		//获取当前用户
		User user = (User) session.get(SysConstant.CURRENT_USER_INFO);
		
		String hql = "from Feedback where state = 0 and inputBy = ? order by createTime desc";
		page.setPageSize(5);
		feedbackService.findPage(hql, page, Feedback.class, new Object[]{user.getUserName()});
		page.setUrl("taskAction_list");
		super.push(page);
		
		return "list";
	}
	
	public String infoList() throws Exception{
		System.out.println(model.getId());
		Feedback feedback = feedbackService.get(Feedback.class, model.getId());
		super.push(feedback);
		
		String hql = "from Feedback where state = 1";
		List<Feedback> list = feedbackService.find(hql, Feedback.class, null);
		super.put("list", list);
		
		String hql2 = "from SubjectInfo where feedback.id = ? order by inputTime desc";
		List<SubjectInfo> infoList = subjectInfoService.find(hql2, SubjectInfo.class, new Object[]{model.getId()});
		super.put("infoList", infoList);
		return "infoList";
	}
	
	public String answer() throws Exception{
		
		Feedback feedback = feedbackService.get(Feedback.class, model.getId());
		super.push(feedback);
		
		return "answer";
	}
	
	public String save() throws Exception{
		System.out.println(strInfo);
		System.out.println(model.getId());
		fbId = model.getId();
		//获取当前登陆的用户
		User fromUser = (User) session.get(SysConstant.CURRENT_USER_INFO);
		//获取当前操作的Feedback
		Feedback feedback = feedbackService.get(Feedback.class, model.getId());

		SubjectInfo subjectInfo = new SubjectInfo();
		subjectInfo.setFeedback(feedback);
		subjectInfo.setInputBy(fromUser.getUserName());
		subjectInfo.setGetBy(model.getAnswerBy());
		subjectInfo.setGetTime(new Date(System.currentTimeMillis()));
		subjectInfo.setInputTime(new Date(System.currentTimeMillis()));
		subjectInfo.setInputInfo(strInfo);
		subjectInfoService.saveOrUpdate(subjectInfo);
		
		return "toList";
	}
	
	//去转发页面
	public String forward() throws Exception{
		//获取当前登陆的用户
		User fromUser = (User) session.get(SysConstant.CURRENT_USER_INFO);
		//获取当前主题
		Feedback feedback = feedbackService.get(Feedback.class, model.getId());
		super.push(feedback);
		//获取所有可转发的用户(除了当前用户及创建主题的用户)
		String hql="from User where state=1 and id not in ('"+fromUser.getId()+"','"+feedback.getCreateBy()+"')";
		List<User> userList = userService.find(hql, User.class, null);
		ActionContext.getContext().put("userList", userList);
		
		return "forward";
	}
	
	//转发给新用户
	public String reverse() throws Exception{
		//获取当前登陆的用户
		User fromUser = (User) session.get(SysConstant.CURRENT_USER_INFO);
		//获取要转发给的人
		User user = userService.get(User.class, strId);
		//获取要修改的主题
		Feedback feedback = feedbackService.get(Feedback.class, model.getId());
		//添加要新增的主题
		Feedback newFeedback = new Feedback();
		
		//将原主题中除了接收人以外信息传入新主题
		newFeedback.setTitle(feedback.getTitle());
		newFeedback.setContent(feedback.getContent());
		newFeedback.setTelephone(fromUser.getUserinfo().getTelephone());
		newFeedback.setAnswerBy(fromUser.getUserinfo().getName());
		newFeedback.setDifficulty(feedback.getDifficulty());
		newFeedback.setState(feedback.getState());
		newFeedback.setCreateBy(fromUser.getUserinfo().getId());
		newFeedback.setCreateDept(fromUser.getDept().getId());
		newFeedback.setCreateTime(new Date(System.currentTimeMillis()));
		
//		//删除旧的主题
//		feedbackService.deleteById(Feedback.class, feedback.getId());;
		
		//保存要新增的主题
		newFeedback.setInputBy(user.getUserinfo().getName());
		feedbackService.saveOrUpdate(newFeedback);
		
		//通过 附加的信息,添加回复内容
		SubjectInfo subjectInfo = new SubjectInfo();
		
		if(strInfo != null){
			subjectInfo.setFeedback(newFeedback);
			subjectInfo.setInputBy(fromUser.getUserName());
			subjectInfo.setGetBy(user.getUserinfo().getName());
			subjectInfo.setGetTime(new Date(System.currentTimeMillis()));
			subjectInfo.setInputTime(new Date(System.currentTimeMillis()));
			subjectInfo.setInputInfo(strInfo);
			subjectInfoService.saveOrUpdate(subjectInfo);
		}
		
		return "toTask";
		
	}

}
