package cn.itcast.jk.shiro;

import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.itcast.jk.domain.Module;
import cn.itcast.jk.domain.Role;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.service.UserService;

public class AuthRealm extends AuthorizingRealm {
	private UserService userService ;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		//获取授权对象info (SimpleAuthorizationInfo类是AuthorizationInfo接口的实现类)
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//获取当前登录对象
		User user = (User) arg0.getPrimaryPrincipal();
		Set<Role> roles = user.getRoles();
		for (Role role : roles) {
			Set<Module> modules = role.getModules();
			for (Module module : modules) {
				//给当前对象授权
				info.addStringPermission(module.getCpermission());
			}
		}
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
//		System.out.println("调用认证方法");
		UsernamePasswordToken token=(UsernamePasswordToken) arg0;
		String username = token.getUsername();
		List<User> userList = userService.find("from User where userName=?", User.class, new Object[]{username});
		if(userList!=null && userList.size()>0){
			User user = userList.get(0);
//			AuthenticationInfo接口的实现类SimpleAuthenticationInfo
//			参数1：核心对象（从数据库中查出来的对象），参数2：数据库中密码 ，参数3：当前Realm名称
			return new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
		}
		return null;
	}

}
