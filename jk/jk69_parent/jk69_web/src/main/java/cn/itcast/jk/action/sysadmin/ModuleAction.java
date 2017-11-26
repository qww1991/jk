package cn.itcast.jk.action.sysadmin;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Module;
import cn.itcast.jk.service.ModuleService;
import cn.itcast.util.Page;

public class ModuleAction extends BaseAction implements ModelDriven<Module>{
	private Module model=new Module();
	private ModuleService moduleService;
	private Page page=new Page();
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	@Override
	public Module getModel() {
		return model;
	}
	
	public String list() throws Exception {
		String hql="from Module where state=1";
		moduleService.findPage(hql,page, Module.class, null);
		page.setUrl("moduleAction_list");
		ActionContext.getContext().getValueStack().push(page);
		return "list";
	}
	/**
	 * 用户查看
	 * @return
	 * @throws Exception
	 */
	public String toview() throws Exception {
		Module module = moduleService.get(Module.class, model.getId());
		ActionContext.getContext().getValueStack().push(module);
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
		moduleService.saveOrUpdate(model);
		return "alist";
	}

	/**更改跳转回显数据
	 * @return
	 * @throws Exception
	 */
	public String toupdate() throws Exception {
		Module module = moduleService.get(Module.class, model.getId());
		super.push(module);
		
		return "toupdate";
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		Module module = moduleService.get(Module.class, model.getId());
		module.setName(model.getName());
		module.setLayerNum(model.getLayerNum());
		module.setCpermission(model.getCpermission());
		module.setCurl(model.getCurl());
		module.setCtype(model.getCtype());
		module.setState(model.getState());
		module.setBelong(model.getBelong());
		module.setCwhich(model.getCwhich());
		module.setRemark(model.getRemark());
		module.setOrderNo(model.getOrderNo());
		
		moduleService.saveOrUpdate(module);
		return "alist";
	}
//	delete
	public String delete() throws Exception {
		String[] ids = model.getId().split(", ");
		moduleService.delete(Module.class, ids);
		return "alist";
	}
}
