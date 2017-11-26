package cn.itcast.jk.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.struts2.ServletActionContext;

import cn.itcast.jk.domain.User;
import cn.itcast.jk.domain.UserBBS;
import cn.itcast.jk.service.UserBBSService;
import cn.itcast.jk.service.UserService;
import cn.itcast.util.SysConstant;
import cn.itcast.util.UtilFuns;

public class HomeAction extends BaseAction{
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private UserBBSService userBBSService;
	public UserBBSService getUserBBSService() {
		return userBBSService;
	}
	public void setUserBBSService(UserBBSService userBBSService) {
		this.userBBSService = userBBSService;
	}
	
	private String moduleName;		//动态指定跳转的模块，在struts.xml中配置动态的result
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String fmain(){
		return "fmain";
	}
	
	public String title(){
		//获取session
		//User curUser = (User)session.get(SysConstant.CURRENT_USER_INFO);
		//ActionContext.getContext().getValueStack().push(curUser);
		
		return "title";
	}

	//转向moduleName指向的模块
	public String tomain(){
		//获取request
		String moduleName = (String)request.get("moduleName");
		
		this.setModuleName(moduleName);
		User user = (User)session.get(SysConstant.CURRENT_USER_INFO);
		List<UserBBS> userBBSList = userBBSService.find("from UserBBS where user_id = ? and state = 0", UserBBS.class, new Object[]{user.getId()});
		super.put("userBBSList",userBBSList);
		return "tomain";
	}
	public String toleft(){
		//获取request
		String moduleName = (String)request.get("moduleName");
		
		this.setModuleName(moduleName);
		return "toleft";
	}
	
	//更新历史
	public String updateBBS(){
		String content = ServletActionContext.getRequest().getParameter("content");
		String left = ServletActionContext.getRequest().getParameter("left");
		String top = ServletActionContext.getRequest().getParameter("top");
		String[] ids = ServletActionContext.getRequest().getParameter("id").split("msg");
		UserBBS userBBS = userBBSService.get(UserBBS.class, ids[0]);
		userBBS.setLeft(Integer.parseInt(left));
		userBBS.setTop(Integer.parseInt(top) - 60);
		userBBS.setContent(content);
		userBBSService.saveOrUpdate(userBBS);
		return NONE;
	}
	
	//备忘历史
	public String BBShistory(){
		User user = (User)session.get(SysConstant.CURRENT_USER_INFO);
		List<UserBBS> userBBSList = userBBSService.find("from UserBBS where user_id = ? and state = 1", UserBBS.class, new Object[]{user.getId()});
		super.put("userBBSList",userBBSList);
		return "bbshistory";
	}

	//新建备忘
	public String newBBS(){
		Random random = new Random();
		User user = (User)session.get(SysConstant.CURRENT_USER_INFO);
		SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dformat.format(new Date());
        String[] lagPicture = {"C0FFE5", "C9FFC7", "CBF3FF", "EDFEB7", "FFE0FB", "FFE7E8", "FFEDCC", "FFFFFF"};
        int lNum = random.nextInt(8);
        int pNum = random.nextInt(8);
        
		UserBBS userBBS = new UserBBS();
		userBBS.setUser_id(user.getId());
		userBBS.setContent("如今的现在早已不是当初说好的以后 ____许帅");
		userBBS.setState(0);
		userBBS.setCreate_time(time);
		userBBS.setBackGround1(lagPicture[lNum] + "1.gif");
		userBBS.setBackGround2(lagPicture[lNum] + "2.gif");
		userBBS.setBackGround3(lagPicture[lNum] + "3.gif");
		userBBS.setIcon(pNum + ".gif");
		userBBS.setLeft(random.nextInt(800) + 20);
		userBBS.setTop(random.nextInt(300));
		userBBSService.saveOrUpdate(userBBS);
		
		List<UserBBS> userBBSList = userBBSService.find("from UserBBS where user_id = ? and state = 0", UserBBS.class, new Object[]{user.getId()});
		super.put("userBBSList",userBBSList);
		return "newbbs";
	}
	
	public String toAddBBS() {
		List<User> userList = userService.find("from User", User.class, null);
		super.put("userList", userList);
		return "toAddBBS";
	}
	//新建备忘
	public String addBBS(){
		Random random = new Random();
		User user = (User)session.get(SysConstant.CURRENT_USER_INFO);
		String content = ServletActionContext.getRequest().getParameter("content");
		String id = ServletActionContext.getRequest().getParameter("user_id");
		
		SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = dformat.format(new Date());
		String[] lagPicture = {"C0FFE5", "C9FFC7", "CBF3FF", "EDFEB7", "FFE0FB", "FFE7E8", "FFEDCC", "FFFFFF"};
		int lNum = random.nextInt(8);
		int pNum = random.nextInt(8);
		
		UserBBS userBBS = new UserBBS();
		userBBS.setUser_id(id);
		userBBS.setContent(content + "       ——by " + user.getUserinfo().getName());
		userBBS.setState(0);
		userBBS.setCreate_time(time);
		userBBS.setBackGround1(lagPicture[lNum] + "1.gif");
		userBBS.setBackGround2(lagPicture[lNum] + "2.gif");
		userBBS.setBackGround3(lagPicture[lNum] + "3.gif");
		userBBS.setIcon(pNum + ".gif");
		userBBS.setLeft(random.nextInt(800) + 20);
		userBBS.setTop(random.nextInt(300));
		userBBSService.saveOrUpdate(userBBS);
		
		List<UserBBS> userBBSList = userBBSService.find("from UserBBS where user_id = ? and state = 0", UserBBS.class, new Object[]{user.getId()});
		super.put("userBBSList",userBBSList);
		return "newbbs";
	}
	
	//假删除备忘,实际为扔进历史里
	public String delBBS(){
		String[] ids = ServletActionContext.getRequest().getParameter("id").split("del");
		UserBBS userBBS = userBBSService.get(UserBBS.class, ids[0]);
		userBBS.setState(1);
		userBBSService.saveOrUpdate(userBBS);
		List<UserBBS> userBBSList = userBBSService.find("from UserBBS where user_id = ? and state = 0", UserBBS.class, new Object[]{ids[1]});
		super.put("userBBSList",userBBSList);
		return "newbbs";
	}
	
	//彻底删除备忘
	public String removeBBS(){
		String[] ids = ServletActionContext.getRequest().getParameter("id").split("del");
		userBBSService.deleteById(UserBBS.class, ids[0]);
		List<UserBBS> userBBSList = userBBSService.find("from UserBBS where user_id = ? and state = 1", UserBBS.class, new Object[]{ids[1]});
		super.put("userBBSList",userBBSList);
		return "bbshistory";
	}
	
}
