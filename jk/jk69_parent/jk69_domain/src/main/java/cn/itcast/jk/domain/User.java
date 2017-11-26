package cn.itcast.jk.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户信息
 * @author Administrator
 */
public class User extends BaseEntity {
	
	private static final long serialVersionUID = -6162063421094307055L;
	
	// 主键
	private String id;
	private Dept dept ;//用户与部门   多对一
	//用户与用户扩展信息   单向一对一
	private UserInfo userinfo;
	private Set<Role> roles = new HashSet<Role>(0);//用户与角色   多对多
	private String userName;//用户名
	private String password;//密码
	private Integer state;//状态  1在职   0离职  默认为1
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}

	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", dept=" + dept + ", roles=" + roles + ", userName=" + userName + ", password="
				+ password + ", state=" + state + "]";
	}
	
}
