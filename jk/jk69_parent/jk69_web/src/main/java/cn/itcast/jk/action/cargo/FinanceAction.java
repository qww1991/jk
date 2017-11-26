package cn.itcast.jk.action.cargo;

import java.util.List;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Export;
import cn.itcast.jk.domain.Finance;
import cn.itcast.jk.domain.Invoice;
import cn.itcast.jk.domain.PackingList;
import cn.itcast.jk.domain.ShippingOrder;
import cn.itcast.jk.service.ExportService;
import cn.itcast.jk.service.FinanceService;
import cn.itcast.jk.service.InvoiceService;
import cn.itcast.jk.service.PackingListService;
import cn.itcast.jk.service.ShippingOrderService;
import cn.itcast.util.Page;
import cn.itcast.util.UtilFuns;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @Description: FinanceService接口
 * @Author: rent
 * @Company: http://java.itcast.cn
 * @CreateDate: 2017-11-18 18:56:59
 */

public class FinanceAction extends BaseAction implements ModelDriven<Finance> {
	// 注入service
	private FinanceService financeService;

	public void setFinanceService(FinanceService financeService) {
		this.financeService = financeService;
	}

	// 注入invoiceService
	private InvoiceService invoiceService;

	public void setInvoiceService(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	// 注入shippingOrderService
	private ShippingOrderService shippingOrderService;

	public void setShippingOrderService(ShippingOrderService shippingOrderService) {
		this.shippingOrderService = shippingOrderService;
	}

	// 注入packingListService
	private PackingListService packingListService;

	public void setPackingListService(PackingListService packingListService) {
		this.packingListService = packingListService;
	}

	// 注入exportService
	private ExportService exportService;

	public void setExportService(ExportService exportService) {
		this.exportService = exportService;
	}

	// model驱动
	private Finance model = new Finance();

	public Finance getModel() {
		return this.model;
	}

	// 作为属性驱动，接收并封装页面参数
	private Page page = new Page(); // 封装页面的参数，主要当前页参数

	public void setPage(Page page) {
		this.page = page;
	}

	// 列表展示
	public String list() {
		String hql = "from Finance o"; // 查询所有内容
		// 给页面提供分页数据
		page.setUrl("financeAction_list"); // 配置分页按钮的转向链接
		page = financeService.findPage(hql, page, Finance.class, null);
		super.push(page);

		return "list"; // page list
	}

	// 查看
	public String toview() {
		Finance obj = financeService.get(Finance.class, model.getId());
		super.push(obj);
		return "toview"; // 转向查看页面
	}

	// 转向新增页面
	public String tocreate() {
		// 准备发票数据(状态为8.出票成功(待进账) )
		List<Invoice> invoiceList = invoiceService.find("from Invoice where state = 8.0", Invoice.class, null);
		super.put("invoiceList", invoiceList);

		return "tocreate";
	}

	// 新增保存
	public String insert() {

		model.setId(model.getId().replaceAll(", ", ""));

		financeService.saveOrUpdate(model);

		return "alist"; // 返回列表，重定向action_list
	}

	// 转向修改页面
	public String toupdate() {
		// 准备修改的数据
		Finance finance = financeService.get(Finance.class, model.getId());
		// 判断财务报运单状态是不是未提交状态 9.0
		if (finance.getState() != 9.0) {

			super.put("msg", "亲,您所选的财务报运单已进账完毕,不能进行修改操作!");

			return SUCCESS;
		}

		super.push(finance);

		return "toupdate";
	}

	// 修改保存
	public String update() {
		Finance finance = financeService.get(Finance.class, model.getId());

		// 设置修改的属性，根据业务去掉自动生成多余的属性
		finance.setInputBy(model.getInputBy());

		financeService.saveOrUpdate(finance);

		return "alist";
	}

	// 删除一条
	public String deleteById() {

		financeService.deleteById(Finance.class, model.getId());

		return "alist";
	}

	// 删除多条
	public String delete() {
		String[] ids = model.getId().split(", ");
		for (String id : ids) {
			Finance finance = financeService.get(Finance.class, id);
			// 判断财务报运单状态是不是未提交状态 9.0
			if (finance.getState() != 9.0) {
				
				super.put("msg", "亲,您所选的财务报运单已进账完毕,不能进行删除操作!");
				
				return SUCCESS;
			}
		}
		
		financeService.delete(Finance.class, model.getId().split(", "));

		return "alist";
	}

	// 提交
	// 将财务报运状态改为 10.0 ---9.已进账(未提交)10.进账完毕
	public String submit() throws Exception {
		// TODO Auto-generated method stub
		// 将财务报运中的发票,发票中的委托单对应的装箱单和报运单对象状态同步
		// 财务报运单
		Finance finance = financeService.get(Finance.class, model.getId());
		// 判断财务报运单状态是不是未提交状态 9.0
		if (finance.getState() != 9.0) {

			super.put("msg", "亲,您所选的财务报运单已进账完毕,不能进行提交操作!");

			return SUCCESS;
		}
		finance.setState(10.0);
		financeService.saveOrUpdate(finance);

		// 发票
		Invoice invoice = invoiceService.get(Invoice.class, model.getId());
		invoice.setState(10.0);
		invoiceService.saveOrUpdate(invoice);
		// 委托单
		ShippingOrder shippingOrder = shippingOrderService.get(ShippingOrder.class, invoice.getId());
		shippingOrder.setState(10.0);
		shippingOrderService.saveOrUpdate(shippingOrder);
		// 装箱单
		PackingList packingList = packingListService.get(PackingList.class, shippingOrder.getId());
		packingList.setState(10.0);
		packingListService.saveOrUpdate(packingList);
		// 报运单
		String[] exportIds = packingList.getExportIds().split(", ");
		for (String exportId : exportIds) {
			Export export = exportService.get(Export.class, exportId);
			export.setState(10);
			exportService.saveOrUpdate(export);
		}

		return "alist";
	}

	// 取消
	// 将财务报运状态改为9.0 ---9.已进账(未提交)10.进账完毕
	public String cancel() throws Exception {
		// TODO Auto-generated method stub
		// 将财务报运中的发票,发票中的委托单对应的装箱单和报运单对象状态同步
		// 财务报运单
		Finance finance = financeService.get(Finance.class, model.getId());
		// 判断财务报运单状态是不是未提交状态 9.0
		if (finance.getState() != 1000.0) {

			super.put("msg", "亲,您所选的财务报运单已进账完毕,不能进行取消操作!");

			return SUCCESS;
		}
		finance.setState(9.0);
		financeService.saveOrUpdate(finance);
		// 发票
		Invoice invoice = invoiceService.get(Invoice.class, model.getId());
		invoice.setState(9.0);
		invoiceService.saveOrUpdate(invoice);
		// 委托单
		ShippingOrder shippingOrder = shippingOrderService.get(ShippingOrder.class, invoice.getId());
		shippingOrder.setState(9.0);
		shippingOrderService.saveOrUpdate(shippingOrder);
		// 装箱单
		PackingList packingList = packingListService.get(PackingList.class, shippingOrder.getId());
		packingList.setState(9.0);
		packingListService.saveOrUpdate(packingList);
		// 报运单
		String[] exportIds = packingList.getExportIds().split(", ");
		for (String exportId : exportIds) {
			Export export = exportService.get(Export.class, exportId);
			export.setState(9);
			exportService.saveOrUpdate(export);
		}
		return "alist";
	}

}
