package cn.itcast.jk.action.cargo;

import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.service.ContractProductService;
import cn.itcast.jk.service.ContractService;
import cn.itcast.jk.service.FactoryService;
import cn.itcast.util.Page;

public class ContractProductAction extends BaseAction implements ModelDriven<ContractProduct>{
	private ContractProduct model=new ContractProduct();
	private ContractProductService contractProductService;
	private ContractService contractService;
	private FactoryService factoryService;
	
	public void setFactoryService(FactoryService factoryService) {
		this.factoryService = factoryService;
	}

	public void setContractService(ContractService contractService) {
		this.contractService = contractService;
	}
	private Page page=new Page();
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public void setContractProductService(ContractProductService contractProductService) {
		this.contractProductService = contractProductService;
	}

	@Override
	public ContractProduct getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	
	/**
	 * 新增跳转新增页面
	 * @return
	 * @throws Exception
	 */
	public String tocreate() throws Exception {
		String hql="from ContractProduct where contract.id=?";
		contractProductService.findPage(hql,page, ContractProduct.class, new Object[]{model.getContract().getId()});
		page.setUrl("contractProductAction_list");
		ActionContext.getContext().getValueStack().push(page);
		List<Factory> factoryList = factoryService.find("from Factory where ctype = '货物'", Factory.class, null);
		super.put("factoryList", factoryList);
		return "tocreate";
	}
	public String insert() throws Exception {
		contractProductService.saveOrUpdate(model);
		return tocreate();
	}

	/**更改跳转回显数据
	 * @return
	 * @throws Exception
	 */
	public String toupdate() throws Exception {
		ContractProduct contractProduct = contractProductService.get(ContractProduct.class, model.getId());
		super.push(contractProduct);
		List<Factory> factoryList = factoryService.find("from Factory where ctype = '货物'", Factory.class, null);
		super.put("factoryList", factoryList);
		
		return "toupdate";
	}
	
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ContractProduct contractProduct = contractProductService.get(ContractProduct.class, model.getId());
		// 设置
				contractProduct.setFactory(model.getFactory());
				contractProduct.setFactoryName(model.getFactoryName());
				contractProduct.setProductNo(model.getProductNo());
				contractProduct.setProductImage(model.getProductImage());
				contractProduct.setCnumber(model.getCnumber());
				contractProduct.setAmount(model.getAmount());
				contractProduct.setPackingUnit(model.getPackingUnit());
				contractProduct.setLoadingRate(model.getLoadingRate());
				contractProduct.setBoxNum(model.getBoxNum());
				contractProduct.setPrice(model.getPrice());
				contractProduct.setOrderNo(model.getOrderNo());
				contractProduct.setProductDesc(model.getProductDesc());
				contractProduct.setProductRequest(model.getProductRequest());
				contractProductService.saveOrUpdate(contractProduct);
		return tocreate();
	}
//	delete
	public String delete() throws Exception {
		
		contractProductService.deleteById(ContractProduct.class, model.getId());
		return tocreate();
	}


}
