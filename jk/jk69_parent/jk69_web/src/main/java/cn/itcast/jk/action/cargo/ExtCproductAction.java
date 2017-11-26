package cn.itcast.jk.action.cargo;
import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.ExtCproduct;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.service.ExtCproductService;
import cn.itcast.jk.service.FactoryService;
import cn.itcast.util.Page;

public class ExtCproductAction extends BaseAction implements ModelDriven<ExtCproduct>{
	private ExtCproduct model=new ExtCproduct();
	private ExtCproductService extCproductService;
	private FactoryService factoryService;
	
	public void setFactoryService(FactoryService factoryService) {
		this.factoryService = factoryService;
	}
	private Page page=new Page();
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public void setExtCproductService(ExtCproductService extCproductService) {
		this.extCproductService = extCproductService;
	}

	@Override
	public ExtCproduct getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	public String list() throws Exception {
		String hql="from ExtCproduct where state=1";
		extCproductService.findPage(hql,page, ExtCproduct.class, null);
		page.setUrl("extCproductAction_list");
		ActionContext.getContext().getValueStack().push(page);
		return "list";
	}
	/**
	 * 用户查看
	 * @return
	 * @throws Exception
	 */
	public String toview() throws Exception {
		ExtCproduct extCproduct = extCproductService.get(ExtCproduct.class, model.getId());
		ActionContext.getContext().getValueStack().push(extCproduct);
		return "toview";
	}
	
	/**
	 * 新增跳转新增页面
	 * @return
	 * @throws Exception
	 */
	public String tocreate() throws Exception {
		List<Factory> factoryList = factoryService.find("from Factory where ctype = '附件'", Factory.class, null);
		super.put("factoryList", factoryList);
		String hql="from ExtCproduct where contractProduct.id=?";
		 extCproductService.findPage(hql,page,ExtCproduct.class, new Object[]{model.getContractProduct().getId()});
		 page.setUrl("extCproductAction_list");
		ActionContext.getContext().getValueStack().push(page);
		return "tocreate";
	}
	public String insert() throws Exception {
		extCproductService.saveOrUpdate(model);

		return tocreate();
	}

	/**更改跳转回显数据
	 * @return
	 * @throws Exception
	 */
	public String toupdate() throws Exception {
		List<Factory> factoryList = factoryService.find("from Factory where ctype = '附件'", Factory.class, null);
		super.put("factoryList", factoryList);
		ExtCproduct extCproduct = extCproductService.get(ExtCproduct.class, model.getId());
		super.push(extCproduct);
		
		return "toupdate";
	}
	
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ExtCproduct extCproduct = extCproductService.get(ExtCproduct.class, model.getId());
		extCproduct.setFactory(model.getFactory());
		extCproduct.setFactoryName(model.getFactoryName());
		extCproduct.setProductNo(model.getProductNo());
		extCproduct.setProductImage(model.getProductImage());
		extCproduct.setCnumber(model.getCnumber());
		extCproduct.setPackingUnit(model.getPackingUnit());
		extCproduct.setPrice(model.getPrice());
	  	extCproduct.setOrderNo(model.getOrderNo());
	  	extCproduct.setProductDesc(model.getProductDesc());
	  	extCproduct.setProductRequest(model.getProductRequest());
		extCproductService.saveOrUpdate(extCproduct);
		return tocreate();
	}
//	delete
	public String delete() throws Exception {
		
		extCproductService.deleteById(ExtCproduct.class, model.getId());
		return tocreate();
	}

	
}
