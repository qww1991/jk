package cn.itcast.jk.action.sysadmin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dtkj.jk69.exception.SysException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Dept;
import cn.itcast.jk.domain.Role;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.service.DeptService;
import cn.itcast.jk.service.RoleService;
import cn.itcast.jk.service.UserService;
import cn.itcast.util.Page;

public class UserAction extends BaseAction implements ModelDriven<User>{
	private User model=new User();
	private UserService userService;
	private DeptService deptService;
	private RoleService roleService;
	private String roleStr;
	private String[] roleIds;
	public String[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}

	public String getRoleStr() {
		return roleStr;
	}

	public void setRoleStr(String roleStr) {
		this.roleStr = roleStr;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public DeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	private Page page=new Page();
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	public String list() throws Exception {
		String hql="from User where state=1";
		userService.findPage(hql,page, User.class, null);
		page.setUrl("userAction_list");
		ActionContext.getContext().getValueStack().push(page);
		return "list";
	}
	/**
	 * 用户查看
	 * @return
	 * @throws Exception
	 */
	public String toview() throws Exception {
		User user = userService.get(User.class, model.getId());
		ActionContext.getContext().getValueStack().push(user);
		return "toview";
	}
	
	/**
	 * 新增跳转新增页面
	 * @return
	 * @throws Exception
	 */
	public String tocreate() throws Exception {
		String dhql="from Dept where state=1";
		List<Dept> deptList = deptService.find(dhql, Dept.class, null);
		super.put("deptList", deptList);
		String hql="from User where state=1";
		List<User> userList = userService.find(hql, User.class, null);
		ActionContext.getContext().put("userList", userList);
		return "tocreate";
	}
	public String insert() throws Exception {
		userService.saveOrUpdate(model);
//		System.out.println("++++++++++++++++++");
//		System.out.println(model);
		return "alist";
	}

	/**更改跳转回显数据
	 * @return
	 * @throws Exception
	 */
	public String toupdate() throws Exception {
		String dhql="from Dept where state=1";
		List<Dept> deptList = deptService.find(dhql, Dept.class, null);
		super.put("deptList", deptList);
		User user = userService.get(User.class, model.getId());
		super.push(user);
		
		return "toupdate";
	}
	
	/**
	 * 修改部门信息
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		User user = userService.get(User.class, model.getId());
		user.getDept().setId(model.getDept().getId());
		user.setUserName(model.getUserName());
		user.setState(model.getState());
		userService.saveOrUpdate(user);
		return "alist";
	}
//	delete
	public String delete() throws Exception {
		String[] ids = model.getId().split(", ");
		userService.delete(User.class, ids);
		return "alist";
	}
	/**
	 * 跳转到角色
	 * @return
	 * @throws Exception
	 */
	public String torole() throws Exception {
		List<Role> roleList = roleService.find("from Role", Role.class, null);
		super.put("roleList", roleList);
		User user;
		try {
			user = userService.get(User.class, model.getId());
			super.push(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SysException("请正确选择一个用户！");
		}
		Set<Role> roles = user.getRoles();
		StringBuilder str=new StringBuilder();
		for (Role role : roles) {
			str.append(role.getName()).append(",");
		}
		roleStr=str.toString();
		
		return "torole";
	}
	/**
	 * 保存修改的用户修改的角色
	 * @return
	 * @throws Exception
	 */
	public String role() throws Exception {
		User user = userService.get(User.class, model.getId());
		 Set<Role> roleList=new HashSet<Role>();
		for (String ids : roleIds) {
			roleList.add(roleService.get(Role.class, ids));
		}
		user.setRoles(roleList);
		userService.saveOrUpdate(user);
		return "alist";
	}
	
}
