package cn.itcast.jk.action.sysadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.dtkj.jk69.exception.SysException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Module;
import cn.itcast.jk.domain.Role;
import cn.itcast.jk.service.ModuleService;
import cn.itcast.jk.service.RoleService;
import cn.itcast.util.Page;

public class RoleAction extends BaseAction implements ModelDriven<Role>{
	private Role model=new Role();
	private RoleService roleService;
	private ModuleService moduleService;
	private String moduleIds;

	public String getModuleIds() {
		return moduleIds;
	}

	public void setModuleIds(String moduleIds) {
		this.moduleIds = moduleIds;
	}

	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	private Page page=new Page();
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Override
	public Role getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	public String list() throws Exception {
		String hql="from Role";
		roleService.findPage(hql,page, Role.class, null);
		page.setUrl("roleAction_list");
		ActionContext.getContext().getValueStack().push(page);
		return "list";
	}
	/**
	 * 用户查看
	 * @return
	 * @throws Exception
	 */
	public String toview() throws Exception {
		Role role = roleService.get(Role.class, model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "toview";
	}
	
	/**
	 * 新增跳转新增页面
	 * @return
	 * @throws Exception
	 */
	public String tocreate() throws Exception {

		return "tocreate";
	}
	public String insert() throws Exception {
		roleService.saveOrUpdate(model);
		return "alist";
	}

	/**更改跳转回显数据
	 * @return
	 * @throws Exception
	 */
	public String toupdate() throws Exception {
		Role role = roleService.get(Role.class, model.getId());
		super.push(role);
		return "toupdate";
	}
	
	/**
	 * 修改部门信息
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		Role role = roleService.get(Role.class, model.getId());
		role.setName(model.getName());
		role.setRemark(model.getRemark());
		roleService.saveOrUpdate(role);
		return "alist";
	}
	public String delete() throws Exception {
		String[] ids = model.getId().split(", ");
		roleService.delete(Role.class, ids);
		return "alist";
	}
	/**
	 * 跳转到ztree展示该角色下对应的模块
	 * @return
	 * @throws Exception
	 */
	public String tomodule() throws Exception {
//		try {
			Role role = roleService.get(Role.class, model.getId());
			super.push(role);
//		} catch (Exception e) {
//			throw new SysException("请正确选择一个角色");
//		}
		return "tomodule";
	}

		/**
		 * 提供ztree的json数据
		 * @return
		 * @throws Exception
		 * [{ "id":"11", "pId":"1", "name":"随意勾选 1-1", "checked":"true"},{ id:11, pId:1, name:"随意勾选 1-1", checked:true}]
		 */
		public String jsonTreeNodes1() throws Exception {
			//取出数据库中所有module，跟当前角色拥有的module做对比，如果有选中
			List<Module> moduleList = moduleService.find("from Module where state=1", Module.class, null);
			Role role = roleService.get(Role.class, model.getId());
			Set<Module> modules = role.getModules();
			StringBuilder str=new StringBuilder("[");
			int size = moduleList.size();
			for (Module module : moduleList) {
				size--;
				str.append("{ \"id\":\"").append(module.getId()).append("\", \"pId\":\"").append(module.getParentId())
				.append("\", \"name\":\"").append(module.getName()).append("\"");
				if(modules.contains(module)){
					str.append(", \"checked\":\"true\"}");
				}else{
					str.append("}");
				}
				if(size>0){
					str.append(",");
				}
			}
			str.append("]");
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(str.toString());
			return NONE;
		}
		/**
		 * 提供ztree的json数据
		 * @return
		 * @throws Exception
		 * [{ "id":"11", "pId":"1", "name":"随意勾选 1-1", "checked":"true"},{ id:11, pId:1, name:"随意勾选 1-1", checked:true}]
		 */
		public String jsonTreeNodes() throws Exception {
			//取出数据库中所有module，跟当前角色拥有的module做对比，如果有选中
			List<Module> moduleList = moduleService.find("from Module where state=1", Module.class, null);
			Role role = roleService.get(Role.class, model.getId());
			Set<Module> modules = role.getModules();
			ArrayList<Map<String,String>> list = new ArrayList();
			for (Module module : moduleList) {
				HashMap<String, String> map = new HashMap();
				map.put("id", module.getId());
				map.put("pId", module.getParentId());
				map.put("name", module.getName());
				if(modules.contains(module)){
					map.put("checked", "true");
					
				}else{
					map.put("checked", "false");
				}
				list.add(map);
			}
			String jsonString = JSON.toJSONString(list);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(jsonString);
			return NONE;
		}
	/**
	 * 保存修改后的权限
	 * @return
	 * @throws Exception
	 */
	public String module() throws Exception {
		Role role = roleService.get(Role.class, model.getId());
		HashSet<Module> moduleList = new HashSet<Module>();
		String[] ids = moduleIds.split(",");
		for (String id : ids) {
			Module module = moduleService.get(Module.class, id);
			moduleList.add(module);
		}
		role.setModules(moduleList);
		roleService.saveOrUpdate(role);
		return "alist";
	}
	
	
}
