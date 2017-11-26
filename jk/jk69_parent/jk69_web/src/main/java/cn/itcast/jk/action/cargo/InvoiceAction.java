package cn.itcast.jk.action.cargo;

import java.util.List;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Export;
import cn.itcast.jk.domain.Invoice;
import cn.itcast.jk.domain.PackingList;
import cn.itcast.jk.domain.ShippingOrder;
import cn.itcast.jk.service.ExportService;
import cn.itcast.jk.service.InvoiceService;
import cn.itcast.jk.service.PackingListService;
import cn.itcast.jk.service.ShippingOrderService;
import cn.itcast.util.Page;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @Description: InvoiceService接口
 * @Author: rent
 * @Company: http://java.itcast.cn
 * @CreateDate: 2017-11-17 21:12:29
 */

public class InvoiceAction extends BaseAction implements ModelDriven<Invoice> {
	// 注入service
	private InvoiceService invoiceService;

	public void setInvoiceService(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	// 注入ShippingOrderService
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
	private Invoice model = new Invoice();

	public Invoice getModel() {
		return this.model;
	}

	// 作为属性驱动，接收并封装页面参数
	private Page page = new Page(); // 封装页面的参数，主要当前页参数

	public void setPage(Page page) {
		this.page = page;
	}

	// 列表展示
	public String list() {
		String hql = "from Invoice o"; // 查询所有内容
		// 给页面提供分页数据
		page.setUrl("invoiceAction_list"); // 配置分页按钮的转向链接
		page = invoiceService.findPage(hql, page, Invoice.class, null);

		super.push(page);

		return "list"; // page list
	}

	// 转向新增页面
	public String tocreate() {
		// 准备委托单数据(状态为6的 委托完毕(待出票)的委托单)
		List<ShippingOrder> shippingOrderList = shippingOrderService.find("from ShippingOrder where state = 6.0",
				ShippingOrder.class, null);

		super.put("shippingOrderList", shippingOrderList);

		return "tocreate";
	}

	// 新增保存
	public String insert() {

		model.setId(model.getId().replaceAll(", ", ""));

		invoiceService.saveOrUpdate(model);

		return "alist"; // 返回列表，重定向action_list //返回列表，重定向action_list
	}

	// 查看
	public String toview() {
		Invoice invoice = invoiceService.get(Invoice.class, model.getId());

		super.push(invoice);
		return "toview"; // 转向查看页面
	}

	// 转向修改页面
	public String toupdate() {
		// 回显数据
		Invoice invoice = invoiceService.get(Invoice.class, model.getId());
		// 判断发票状态是不是未提交状态 7.0
		if (invoice.getState() != 7.0) {

			super.put("msg", "亲,您所选的发票状态不能进行修改操作!");

			return SUCCESS;
		}

		super.push(invoice);

		return "toupdate";
	}

	// 修改保存
	public String update() {
		Invoice invoice = invoiceService.get(Invoice.class, model.getId());

		// 设置修改的属性，根据业务去掉自动生成多余的属性
		invoice.setScNo(model.getScNo());
		invoice.setBlNo(model.getBlNo());
		invoice.setTradeTerms(model.getTradeTerms());

		invoiceService.saveOrUpdate(invoice);

		return "alist";
	}

	// 删除一条
	public String deleteById() {

		invoiceService.deleteById(Invoice.class, model.getId());

		return "alist";
	}

	// 删除多条
	public String delete() {
		
		String[] ids = model.getId().split(", ");
		for (String id : ids) {
			Invoice invoice = invoiceService.get(Invoice.class, id);
			// 判断发票状态是不是未提交状态 7.0
			if (invoice.getState() != 7.0) {
				
				super.put("msg", "亲,您所选的发票状态不能进行删除操作!");
				
				return SUCCESS;
			}
		}
		invoiceService.delete(Invoice.class, model.getId().split(", "));

		return "alist";
	}

	// 提交
	// 将发票状态改为 8.0 ---7.已出票(未提交)8.出票成功(待进账)
	public String submit() throws Exception {
		// TODO Auto-generated method stub
		// 将发票中的委托单对应的装箱单和报运单对象状态同步
		// 发票
		Invoice invoice = invoiceService.get(Invoice.class, model.getId());
		// 判断发票状态是不是未提交状态 7.0
		if (invoice.getState() != 7.0) {

			super.put("msg", "亲,您所选的发票状态不能进行提交操作!");

			return SUCCESS;
		}
		
		invoice.setState(8.0);
		invoiceService.saveOrUpdate(invoice);
		// 委托单
		ShippingOrder shippingOrder = shippingOrderService.get(ShippingOrder.class, invoice.getId());
		shippingOrder.setState(8.0);
		shippingOrderService.saveOrUpdate(shippingOrder);
		// 装箱单
		PackingList packingList = packingListService.get(PackingList.class, shippingOrder.getId());
		packingList.setState(8.0);
		packingListService.saveOrUpdate(packingList);
		// 报运单
		String[] exportIds = packingList.getExportIds().split(", ");
		for (String exportId : exportIds) {
			Export export = exportService.get(Export.class, exportId);
			export.setState(8);
			exportService.saveOrUpdate(export);
		}

		return "alist";
	}

	// 取消
	// 将发票状态改为7.0 ------- 7.已出票(未提交)8.出票成功(待进账)
	public String cancel() throws Exception {
		// TODO Auto-generated method stub
		// 将发票中的委托单对应的装箱单和报运单对象状态同步
		// 发票
		Invoice invoice = invoiceService.get(Invoice.class, model.getId());
		// 判断发票状态是不是提交状态 8.0
		if (invoice.getState() != 8.0) {

			super.put("msg", "亲,您所选的发票状态不能进行取消操作!");

			return SUCCESS;
		}
		
		invoice.setState(7.0);
		invoiceService.saveOrUpdate(invoice);
		// 委托单
		ShippingOrder shippingOrder = shippingOrderService.get(ShippingOrder.class, invoice.getId());
		shippingOrder.setState(7.0);
		shippingOrderService.saveOrUpdate(shippingOrder);
		// 装箱单
		PackingList packingList = packingListService.get(PackingList.class, shippingOrder.getId());
		packingList.setState(7.0);
		packingListService.saveOrUpdate(packingList);
		// 报运单
		String[] exportIds = packingList.getExportIds().split(", ");
		for (String exportId : exportIds) {
			Export export = exportService.get(Export.class, exportId);
			export.setState(7);
			exportService.saveOrUpdate(export);
		}

		return "alist";
	}

}
