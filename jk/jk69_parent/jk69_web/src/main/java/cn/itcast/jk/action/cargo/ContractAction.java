package cn.itcast.jk.action.cargo;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.service.ContractProductService;
import cn.itcast.jk.service.ContractService;
import cn.itcast.util.Page;
import cn.itcast.util.SysConstant;

public class ContractAction extends BaseAction implements ModelDriven<Contract>{
	private Contract model=new Contract();
	private ContractService contractService;
	private ContractProductService contractProductService;
	public void setContractProductService(ContractProductService contractProductService) {
		this.contractProductService = contractProductService;
	}
	private Page page=new Page();
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public void setContractService(ContractService contractService) {
		this.contractService = contractService;
	}

	@Override
	public Contract getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	public String list() throws Exception {
		User user =(User) getSession().get(SysConstant.CURRENT_USER_INFO);
		Integer degree = user.getUserinfo().getDegree();
		String hql = "from Contract where 1=1 ";
		if(degree==0){
			//超级管理员
		}else if(degree==1){
			//跨部门跨人员
		}else if(degree==2){
			//管理所有下属部门和人员
		}else if(degree==3){
			//管理本部门
			hql += "and createDept = '"+user.getDept().getId()+"'";
		}else{
			//普通员工
			hql += "and createBy = '"+ user.getId()+"'";
		}
		contractService.findPage(hql,page, Contract.class, null);
		page.setUrl("contractAction_list");
		ActionContext.getContext().getValueStack().push(page);
		return "list";
	}
	/**
	 * 用户查看
	 * @return
	 * @throws Exception
	 */
	public String toview() throws Exception {
		Contract contract = contractService.get(Contract.class, model.getId());
		ActionContext.getContext().getValueStack().push(contract);
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
		User user=(User)getSession().get(SysConstant.CURRENT_USER_INFO);
		model.setCreateBy(user.getId());  //赋值当前创建人id
		model.setCreateDept(user.getDept().getId());  //赋值当前创建人所在部门
		contractService.saveOrUpdate(model);
		return "alist";
	}

	/**更改跳转回显数据
	 * @return
	 * @throws Exception
	 */
	public String toupdate() throws Exception {
		Contract contract = contractService.get(Contract.class, model.getId());
		super.push(contract);
		
		return "toupdate";
	}
	
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		Contract contract = contractService.get(Contract.class, model.getId());
		contract.setCustomName(model.getCustomName());
		contract.setPrintStyle(model.getPrintStyle());
		contract.setContractNo(model.getContractNo());
		contract.setOfferor(model.getOfferor());
		contract.setInputBy(model.getInputBy());
		contract.setCheckBy(model.getCheckBy());
		contract.setInspector(model.getInspector());
		contract.setSigningDate(model.getSigningDate());
		contract.setImportNum(model.getImportNum());
		contract.setShipTime(model.getShipTime());
		contract.setTradeTerms(model.getTradeTerms()); 
		contract.setDeliveryPeriod(model.getDeliveryPeriod());
		contract.setCrequest(model.getCrequest());
        contract.setRemark(model.getRemark());
		contractService.saveOrUpdate(contract);
		return "alist";
	}
//	delete
	public String delete() throws Exception {
		String[] ids = model.getId().split(", ");
		contractService.delete(Contract.class, ids);
		return "alist";
	}

	/**
	 * 修改状态
	 * @return
	 * @throws Exception
	 */
	public String submit() throws Exception {
		Contract contract = contractService.get(Contract.class, model.getId());
		Integer state = contract.getState();
		if(state==1){
			contract.setState(0);
		}else{
			contract.setState(1);
		}
		contractService.saveOrUpdate(contract);
		
		return "alist";
	}
	public String cancel() throws Exception {
		return submit();
	}
//	
	public String print() throws Exception {
Contract contract = contractService.get(Contract.class, model.getId());
		
		ContractPrint contractPrint = new ContractPrint();
		
		String path = ServletActionContext.getServletContext().getRealPath(File.separator);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		List<ContractProduct> cpList = contractProductService.find("from ContractProduct where contract.id = ? order by factoryName", ContractProduct.class, new Object[]{model.getId()});
		
		contractPrint.print(contract,cpList, path, response);
		return NONE;
	}
}
