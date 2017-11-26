package cn.itcast.jk.action.sysadmin;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Dept;
import cn.itcast.jk.service.DeptService;
import cn.itcast.util.Page;

public class DeptAction extends BaseAction implements ModelDriven<Dept>{
	private Dept model=new Dept();
	private DeptService deptService;
	private Page page=new Page();
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	@Override
	public Dept getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	public String list() throws Exception {
		String hql="from Dept where state=1";
		deptService.findPage(hql,page, Dept.class, null);
		page.setUrl("deptAction_list");
		ActionContext.getContext().getValueStack().push(page);
	
		
		return "list";
	}
	/**
	 * 部门查看
	 * @return
	 * @throws Exception
	 */
	public String toview() throws Exception {
		Dept dept = deptService.get(Dept.class, model.getId());
		ActionContext.getContext().getValueStack().push(dept);
		return "toview";
	}
	
	/**
	 * 新增跳转新增页面
	 * @return
	 * @throws Exception
	 */
	public String tocreate() throws Exception {
		String hql="from Dept where state=1";
		List<Dept> deptList = deptService.find(hql, Dept.class, null);
		ActionContext.getContext().put("deptList", deptList);
		return "tocreate";
	}
	public String insert() throws Exception {
//		System.out.println(model.getParent().getId());
//		System.out.println(model.getDeptName());
		Dept dept = deptService.get(Dept.class, model.getParent().getId());
		model.setParent(dept);
		model.setState(1);
		deptService.saveOrUpdate(model);
		return "insert";
	}

	/**更改跳转回显数据
	 * @return
	 * @throws Exception
	 */
	public String toupdate() throws Exception {
		Dept dept = deptService.get(Dept.class, model.getId());
		ActionContext.getContext().getValueStack().push(dept);
		String hql="from Dept where state=1";
		List<Dept> deptList = deptService.find(hql, Dept.class, null);
		ActionContext.getContext().put("deptList", deptList);
		return "toupdate";
	}
	
	/**
	 * 修改部门信息
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		Dept dept = deptService.get(Dept.class, model.getId());
		dept.setParent(deptService.get(Dept.class, model.getParent().getId()));
		dept.setDeptName(model.getDeptName());
		deptService.saveOrUpdate(dept);
		return "update";
	}
//	delete
	public String delete() throws Exception {
		String[] ids = model.getId().split(", ");
		deptService.delete(Dept.class, ids);
			
		return "delete";
	}
}
