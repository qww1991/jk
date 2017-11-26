package cn.itcast.jk.action;


import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;

import cn.itcast.jk.domain.LoginLog;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.service.LoginLogService;
import cn.itcast.util.SysConstant;
import cn.itcast.util.UtilFuns;

public class LoginAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	private LoginLogService loginLogService;

	
	//SSH传统登录方式

	public void setLoginLogService(LoginLogService loginLogService) {
		this.loginLogService = loginLogService;
	}


	@SuppressWarnings("deprecation")
	public String login() throws Exception {
		
//		if(true){
//			String msg = "登录错误，请重新填写用户名密码!";
//			this.addActionError(msg);
//			throw new Exception(msg);
//		}
//		User user = new User(username, password);
//		User login = userService.login(user);
//		if (login != null) {
//			ActionContext.getContext().getValueStack().push(user);
//			session.put(SysConstant.CURRENT_USER_INFO, login);	//记录session
//			return SUCCESS;
//		}
//		return "login";
		if(session.get(SysConstant.CURRENT_USER_INFO) != null) {
			return SUCCESS;
		}
		if(UtilFuns.isEmpty(username)){
			return "login";
		} 
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(username,password);
		try {
			subject.login(token);
//			从subject对象中拿到user对象 ，放入session中
			User user = (User)subject.getPrincipal();
			
			//LZM 完善登陆功能----------------
			LoginLog loginLog = new LoginLog();
			//登录人的ID
//			loginLog.setId(user.getId());
			//登录人的姓名
			loginLog.setLoginName(user.getUserName());
			HttpServletRequest request = ServletActionContext.getRequest();
			
			String localAddr = request.getRemoteAddr();
			//登录IP
			if ("0:0:0:0:0:0:0:1".equals(localAddr)) {
				loginLog.setIpAddress("192.168.147.1");
			}else {
				loginLog.setIpAddress(localAddr);
			}
			
			
			
			loginLogService.saveOrUpdate(loginLog);
			
			//----------------
			super.getSession().put(SysConstant.CURRENT_USER_INFO, user);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			super.put("errorInfo", "用户名密码错误！");
			return "login";
		}
		
	}
	
	
	//退出
	public String logout(){
		session.remove(SysConstant.CURRENT_USER_INFO);		//删除session
		
		return "logout";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

