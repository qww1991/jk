package cn.itcast.jk.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;

import cn.itcast.jk.domain.Module;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.domain.UserModule;
import cn.itcast.jk.service.ModuleService;
import cn.itcast.jk.service.SqlService;
import cn.itcast.jk.service.UserModuleService;
import cn.itcast.util.SysConstant;

public class MenuAction extends BaseAction {
	private SqlService sqlService;
	public SqlService getSqlService() {
		return sqlService;
	}
	public void setSqlService(SqlService sqlService) {
		this.sqlService = sqlService;
	}
	
	private UserModuleService userModuleService;
	public UserModuleService getUserModuleService() {
		return userModuleService;
	}
	public void setUserModuleService(UserModuleService userModuleService) {
		this.userModuleService = userModuleService;
	}
	
	private ModuleService moduleService;
	public ModuleService getModuleService() {
		return moduleService;
	}
	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}
	
	
	public String getFastMenuJson() throws Exception {
		User user = (User) session.get(SysConstant.CURRENT_USER_INFO);
		//根据session中user的id,查出点击前五名的模块.
		String sql = "select ROWNUM,u.* from (select * from USER_MODULE_P t where t.USER_ID = '" + user.getId() + "' and CLICK != 0 order by CLICK) u where rownum < 6";
		List fastMenuJson = sqlService.executeSQL(sql);
		/*
		[1, 7aa5a75e-c143-4d5b-bd31-756847885a27, 207, 发票管理, cargo/invoiceAction_list, 1, 0, acde96ad-32e9-4c9c-8555-a90a282193a0, 
		 2, 3c38315a-b399-4253-b0e4-e1480e2da855, 206, 委托管理, cargo/shippingOrderAction_list, 2, 0, acde96ad-32e9-4c9c-8555-a90a282193a0, 
		 3, 62403c4f-b857-49dd-80b6-99235c57cb72, 503, 角色管理, sysadmin/roleAction_list, 3, 0, acde96ad-32e9-4c9c-8555-a90a282193a0, 
		 4, 7572c120-9a35-4db1-be89-5315ff9ed985, 504, 模块管理, sysadmin/moduleAction_list, 4, 0, acde96ad-32e9-4c9c-8555-a90a282193a0, 
		 5, b19a1c7e-3365-4dea-81d6-245f52943d4d, 205, 装箱管理, cargo/packingListAction_list, 5, 0, acde96ad-32e9-4c9c-8555-a90a282193a0]*/
		ArrayList arrayList = new ArrayList();
		for (int i = 0; i < fastMenuJson.size() / 8; i++) {
			UserModule userModule = new UserModule();
			userModule.setCurl((fastMenuJson.get(i * 8 + 4)).toString());
			userModule.setModuleName((fastMenuJson.get(i * 8 + 3)).toString());
			arrayList.add(userModule);
		}
		String jsonString = JSON.toJSONString(arrayList);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		response.getWriter().write(jsonString);
		return NONE;
	}
	
	public String getCustomMenuJson() throws Exception {
		User user = (User) session.get(SysConstant.CURRENT_USER_INFO);
		//根据session中user的id,查出用户所属的自定义模块.
		String sql = "select ROWNUM,u.* from (select * from USER_MODULE_P t where t.USER_ID = '" + user.getId() + "' and CUSTOM = 1) u";
		List fastMenuJson = sqlService.executeSQL(sql);
		ArrayList arrayList = new ArrayList();
		for (int i = 0; i < fastMenuJson.size() / 8; i++) {
			UserModule userModule = new UserModule();
			userModule.setCurl((fastMenuJson.get(i * 8 + 4)).toString());
			userModule.setModuleName((fastMenuJson.get(i * 8 + 3)).toString());
			arrayList.add(userModule);
		}
		String jsonString = JSON.toJSONString(arrayList);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		response.getWriter().write(jsonString);
		return NONE;
	}
	
	
	//将用户的模块,的点击数 初始化为0
	public String clearFastMenuJson() throws Exception{
		User user = (User) session.get(SysConstant.CURRENT_USER_INFO);
		String sql = "update USER_MODULE_P set CLICK = 0 where USER_ID = '" + user.getId() + "'";
		sqlService.updateSQL(sql);
		return NONE;
	}
	
	//跳转到自定义模块,之前,先去数据库查一查
	public String toCustom() throws Exception{
		User user = (User) session.get(SysConstant.CURRENT_USER_INFO);
		String sql = "select ROWNUM,u.* from (select * from USER_MODULE_P t where t.USER_ID = '" + user.getId() + "' and CUSTOM = 0) u";
		List customMenuJson = sqlService.executeSQL(sql);
		ArrayList noCustomList = new ArrayList();
		for (int i = 0; i < customMenuJson.size() / 8; i++) {
			UserModule userModule = new UserModule();
			userModule.setId((customMenuJson.get(i * 8 + 1)).toString());
			userModule.setModuleName((customMenuJson.get(i * 8 + 3)).toString());
			noCustomList.add(userModule);
		}
		super.put("noCustomList", noCustomList);
		
		String cSql = "select ROWNUM,u.* from (select * from USER_MODULE_P t where t.USER_ID = '" + user.getId() + "' and CUSTOM = 1) u";
		List addCustomMenuJson = sqlService.executeSQL(cSql);
		ArrayList addCustomList = new ArrayList();
		for (int i = 0; i < addCustomMenuJson.size() / 8; i++) {
			UserModule userModule = new UserModule();
			userModule.setId((addCustomMenuJson.get(i * 8 + 1)).toString());
			userModule.setModuleName((addCustomMenuJson.get(i * 8 + 3)).toString());
			addCustomList.add(userModule);
		}
		super.put("addCustomList", addCustomList);
		return "toCustom";
	}
	
	public String updateCustomModule() throws Exception {
		User user = (User) session.get(SysConstant.CURRENT_USER_INFO);
		//将CUSTOM字段全设为0,先清除用户以前已经定义好的自定义模块
		String toZeroSql = "update USER_MODULE_P set CUSTOM = 0 where CUSTOM = 1 and USER_ID = '" + user.getId() + "'";
		sqlService.updateSQL(toZeroSql);
		String ids = ServletActionContext.getRequest().getParameter("ids");
		String[] moduleIds = ids.split("_");
		for (String id : moduleIds) {
			String sql = "update USER_MODULE_P set CUSTOM = 1 where USER_MODULE_ID = '" + id + "'";
			System.out.println(sql);
			sqlService.updateSQL(sql);
		}
		return NONE;
	}
	
	//将click加1
	public String addClickNum() {
		String realURL = ServletActionContext.getRequest().getParameter("module").split("/helloServlet/")[1];
		List<Module> moduleList = moduleService.find("from Module where curl = ?", Module.class, new Object[]{realURL});
		Module module = moduleList.get(0);
		User user = (User) session.get(SysConstant.CURRENT_USER_INFO);
		
		String hql = "from UserModule where curl = ? and user_id = ?";
		List<UserModule> findList = userModuleService.find(hql, UserModule.class, new Object[]{realURL, user.getId()});
		if (findList.size() == 0) {
			UserModule userModule = new UserModule();
			userModule.setClick(0);
			userModule.setCustom(0);
			userModule.setCurl(realURL);
			userModule.setModule_id(module.getId());
			userModule.setModuleName(module.getName());
			userModule.setUser_id(user.getId());
			userModuleService.saveOrUpdate(userModule);
		}
	//hql跟下面sql语句 一样作用
	/*	else {
			findList.get(0).setClick(findList.get(0).getClick() + 1);
			userModuleService.saveOrUpdate(userModule);
		}*/
		String sql = "update USER_MODULE_P set click = click + 1 where CURL = '" + realURL + "' and USER_ID = '" + user.getId() + "'";
		System.out.println(sql);
		sqlService.updateSQL(sql);
		return NONE;
	}
}
