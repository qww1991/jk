package cn.itcast.jk.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import cn.itcast.jk.domain.Module;
import cn.itcast.jk.domain.Role;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.domain.UserModule;
import cn.itcast.jk.service.SqlService;
import cn.itcast.jk.service.UserModuleService;
import cn.itcast.jk.service.UserService;
import cn.itcast.util.SysConstant;

public class DBAction extends BaseAction{
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

	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String db(){
		String deleteSql = "delete from USER_MODULE_P";
		sqlService.updateSQL(deleteSql);
		
		
		List<User> userList = userService.find("from User", User.class, null);
		for (User user : userList) {
			HashMap<String, Object> moduleMap = new HashMap<String, Object>();
			String userId = user.getId();
			Set<Role> roles = user.getRoles();
			for (Role role : roles) {
				Set<Module> modules = role.getModules();
				for (Module module : modules) {
					UserModule userModule = new UserModule();
					userModule.setModule_id(module.getId());
					userModule.setUser_id(userId);
					userModule.setModuleName(module.getName());
					userModule.setClick(0);
					userModule.setCurl(module.getCurl());
					userModule.setCustom(0);
					moduleMap.put(module.getName(), userModule);
//					userModuleService.saveOrUpdate(userModule);
				}
			}
			Set<Entry<String, Object>> moduleSet = moduleMap.entrySet();
			for (Entry<String, Object> entry : moduleSet) {
				UserModule userModule = (UserModule) entry.getValue();
				userModuleService.saveOrUpdate(userModule);
			}
		}
		
		
		String noAgainSql = "delete from USER_MODULE_P t where MODULE_ID in ('1','2','3','4','5','6')";
		sqlService.updateSQL(noAgainSql);
		System.out.println("success");
		return "db";
	}
}
