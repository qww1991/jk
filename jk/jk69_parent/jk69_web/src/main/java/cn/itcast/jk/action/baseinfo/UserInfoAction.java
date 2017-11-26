package cn.itcast.jk.action.baseinfo;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.alicom.dysms.api.SmsDemo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import cn.itcast.jk.domain.Dept;
import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.domain.UserInfo;
import cn.itcast.jk.service.DeptService;
import cn.itcast.jk.service.UserService;
import cn.itcast.util.Encrypt;
import cn.itcast.util.SysConstant;
import cn.itcast.util.UtilFuns;

public class UserInfoAction extends BaseAction implements ModelDriven<User>{
	private UserService userService;
	private DeptService deptService;
	private User model = new User();

	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	//返回查询页面
	public String list() throws Exception {
		//获取user
		User user = (User) session.get(SysConstant.CURRENT_USER_INFO);
		//获取用户详细信息对象
		UserInfo userinfo = user.getUserinfo();
		//获取用户部门
		Dept dept = user.getDept();
		List<Dept> deptList = deptService.find("from Dept where state = 1", Dept.class, null);
		super.push(userinfo);
		super.push(user);
		super.put("deptList", deptList);
	
		return "list";
	}
	
	//修改方法
	public String update() throws Exception {
		// TODO Auto-generated method stub
		User user = (User) session.get(SysConstant.CURRENT_USER_INFO);
		//user.setUserName(model.getUserName());
		//user.getUserinfo().setName(model.getUserinfo().getName());
		//user.getUserinfo().setJoinDate(model.getUserinfo().getJoinDate());
		//user.getUserinfo().setSalary(model.getUserinfo().getSalary());
		user.getUserinfo().setGender(model.getUserinfo().getGender());
		user.getUserinfo().setStation(model.getUserinfo().getStation());
		user.getUserinfo().setTelephone(model.getUserinfo().getTelephone());
		user.getUserinfo().setEmail(model.getUserinfo().getEmail());
		//user.getUserinfo().setBirthday(model.getUserinfo().getBirthday());
		//user.getUserinfo().setOrderNo(model.getUserinfo().getOrderNo());
		user.getUserinfo().setRemark(model.getUserinfo().getRemark());

		userService.saveOrUpdate(user);
		// 把session里边的东西删除
		session.remove(SysConstant.CURRENT_USER_INFO);
		session.put(SysConstant.CURRENT_USER_INFO, user);
		return list();
	}
	
	public String updatep() throws Exception {
		User suser = (User) session.get(SysConstant.CURRENT_USER_INFO);
		//获取当前用户
		User user = userService.get(User.class, suser.getId());
		super.push(user);
		return "changepwd";
	}
	
	//修改密码
	public String alterPwd() throws Exception {
		User suser = (User) session.get(SysConstant.CURRENT_USER_INFO);
		//获取当前用户
		User user = userService.get(User.class, suser.getId());
		super.push(user);
		String newpassword = ServletActionContext.getRequest().getParameter("newpassword");
		String newpassword1 = ServletActionContext.getRequest().getParameter("newpassword1");
		System.out.println(newpassword);
		System.out.println(newpassword1);
		String password = ServletActionContext.getRequest().getParameter("password");
		String oldPassword = user.getPassword();
		//System.out.println(oldPassword);
		String inputold = Encrypt.md5(model.getPassword(), user.getUserName());
		//System.out.println(model.getId());
		//System.out.println("inputold"+inputold);
		try {
			if(UtilFuns.isEmpty(password)){
				super.put("pwdnull", "密码不能为空");
				System.out.println("");
				return "changepwd";
			}
			if(oldPassword.equals(inputold)){
				if(UtilFuns.isEmpty(newpassword)){
					
					super.put("newpwdone", "密码不能为空");
					return "changepwd";
				}
				if (UtilFuns.isEmpty(newpassword1)) {
				
					super.put("newpwdtwo", "新密码不能为空");
					return "changepwd";
				}
				if(newpassword.equals(newpassword1)){
					String Newmd5 = Encrypt.md5(newpassword,user.getUserName());
					user.setPassword(Newmd5);
				}else{
					super.put("deferent", "确认密码和新密码不一致");
					return "changepwd";
				}
			}else{
				super.put("olderror","输入的原密码不正确");
				return "changepwd";
			}
		} catch (Exception e) {
			System.out.println("出现异常");
			return "changepwd";
		}
		//执行保存方法
		try {
			userService.saveOrUpdate(user);
			SmsDemo.sendMsg(user.getUserinfo().getTelephone(), newpassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.remove(SysConstant.CURRENT_USER_INFO);
		return "successpwd";
	}
	

	
}
