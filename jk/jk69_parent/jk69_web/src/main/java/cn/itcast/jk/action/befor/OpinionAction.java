package cn.itcast.jk.action.befor;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Feedback;
import cn.itcast.jk.domain.SubjectInfo;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.domain.UserInfo;
import cn.itcast.jk.service.FeedbackService;
import cn.itcast.jk.service.SubjectInfoService;
import cn.itcast.jk.service.UserService;
import cn.itcast.util.Page;
import cn.itcast.util.SysConstant;

public class OpinionAction extends BaseAction implements ModelDriven<Feedback>{
	private Feedback model = new Feedback();
	private Page page=new Page();
	private FeedbackService feedbackService;
	private UserService userService;
	private SubjectInfoService subjectInfoService;
	private String strId;
	private String strInfo;
	
	
	
	

	public String getStrInfo() {
		return strInfo;
	}

	public void setStrInfo(String strInfo) {
		this.strInfo = strInfo;
	}

	public SubjectInfoService getSubjectInfoService() {
		return subjectInfoService;
	}

	public void setSubjectInfoService(SubjectInfoService subjectInfoService) {
		this.subjectInfoService = subjectInfoService;
	}

	public String getStrId() {
		return strId;
	}

	public void setStrId(String strId) {
		this.strId = strId;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public FeedbackService getFeedbackService() {
		return feedbackService;
	}

	public void setFeedbackService(FeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}

	public void setModel(Feedback model) {
		this.model = model;
	}

	@Override
	public Feedback getModel() {
		
		return model;
	}
	//反馈列表
	/**
	 * 
	 * @author 杨鑫
	 * @CreateDate:	2017年11月18日
	 * 
	 * @update 龙殇
	 * @UpdateDate: 2017年11月19日
	 */
	public String list() throws Exception {
		String hql="from Feedback where createBy=? order by createTime desc";
		User user = (User) session.get(SysConstant.CURRENT_USER_INFO);
		 String createBy = user.getUserinfo().getId();
		
	
		feedbackService.findPage(hql, page, Feedback.class, new Object[]{createBy});
		page.setUrl("opinionAction_list");
		ActionContext.getContext().getValueStack().push(page);
	
		
		return "list";
		
	}
	//查看反馈
	public String toview() throws Exception {
		String hql2 = "from SubjectInfo where feedback.id = ? order by inputTime desc";
		List<SubjectInfo> infoList = subjectInfoService.find(hql2, SubjectInfo.class, new Object[]{model.getId()});
		super.put("infoList", infoList);

		Feedback feedback = feedbackService.get(Feedback.class, model.getId());
		
		ActionContext.getContext().getValueStack().push(feedback);
		
		return "toview";
	}
	
	
	//新增反馈
	public String tocreate() throws Exception {
		String hql="from User where state=1";
		List<User> userList = userService.find(hql, User.class, null);
		ActionContext.getContext().put("userList", userList);
		return "tocreate";
	}
	
	//发送反馈
	public String insert() throws Exception {
		model.setId(null);
		User user = userService.get(User.class, strId);
		String name = user.getUserinfo().getName();
		model.setInputBy(name);
		feedbackService.saveOrUpdate(model);
		return list();
	}
	
	//删除反馈
	public String todelete() throws Exception {
		feedbackService.deleteById(Feedback.class, model.getId());
		return list();
	}
	
	//修改状态
	public String toupdate() throws Exception {
		Feedback feedback = feedbackService.get(Feedback.class, model.getId());
		Integer state = feedback.getState();
		if (state == 1) {
			feedback.setState(0);
		} else {
			feedback.setState(1);
		}
		feedbackService.saveOrUpdate(feedback);

		return list();
	}
	
	//回复信息保存
	public String save() throws Exception {
		System.out.println(strInfo);
		System.out.println(model.getId());
		//获取当前登陆的用户
		User fromUser = (User) session.get(SysConstant.CURRENT_USER_INFO);
		//获取当前操作的Feedback
		Feedback feedback = feedbackService.get(Feedback.class, model.getId());
		
		System.out.println(feedback);
		
		SubjectInfo subjectInfo = new SubjectInfo();
		subjectInfo.setFeedback(feedback);
		subjectInfo.setInputBy(fromUser.getUserinfo().getName());
		subjectInfo.setGetBy(feedback.getInputBy());
		subjectInfo.setGetTime(new Date(System.currentTimeMillis()));
		subjectInfo.setInputTime(new Date(System.currentTimeMillis()));
		subjectInfo.setInputInfo(strInfo);
		subjectInfoService.saveOrUpdate(subjectInfo);
		
		return "alist";
	}

}
