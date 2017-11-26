package cn.itcast.jk.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;

public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
//		该类为比较用户传过来的密码跟数据库中用户密码对比
		
//		前台传来的密码
		UsernamePasswordToken utoken=(UsernamePasswordToken) token;
		String password= new String(utoken.getPassword());
//		将前台传来的密码加密 
//		参数1：要加密的字符  参数2：混淆的字符串  参数3：hash几次     
//		需要注意这里使用的参数2为当前用户名，那么在修改用户名时，密码要从新生成存入数据库
		Md5Hash md5pass= new Md5Hash(password,utoken.getUsername(),2);
//		数据库中存放的正确密码
		Object credentials = info.getCredentials();
				
		return equals(md5pass.toString(), credentials);
	}
	

}
