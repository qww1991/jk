package cn.itcast.jk.action.cargo;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Export;
import cn.itcast.jk.domain.PackingList;
import cn.itcast.jk.domain.ShippingOrder;
import cn.itcast.jk.service.ExportService;
import cn.itcast.jk.service.PackingListService;
import cn.itcast.jk.service.ShippingOrderService;
import cn.itcast.util.Page;
import cn.itcast.util.UtilFuns;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

public class ShippingOrderAction extends BaseAction implements ModelDriven<ShippingOrder> {
	// 注入service
	private ShippingOrderService shippingOrderService;

	// 注入packingListService(装箱单)service
	private PackingListService packingListService;

	// 注入exportService(报运单)service
	private ExportService exportService;

	public void setExportService(ExportService exportService) {
		this.exportService = exportService;
	}

	public void setPackingListService(PackingListService packingListService) {
		this.packingListService = packingListService;
	}

	public void setShippingOrderService(ShippingOrderService shippingOrderService) {
		this.shippingOrderService = shippingOrderService;
	}

	// model驱动
	private ShippingOrder model = new ShippingOrder();

	public ShippingOrder getModel() {
		return this.model;
	}

	// 作为属性驱动，接收并封装页面参数
	private Page page = new Page(); // 封装页面的参数，主要当前页参数

	public void setPage(Page page) {
		this.page = page;
	}

	// 列表展示
	public String list() {
		String hql = "from ShippingOrder"; // 查询所有内容

		// 配置分页按钮的转向链接
		shippingOrderService.findPage(hql, page, ShippingOrder.class, null);
		// 给页面提供分页数据
		page.setUrl("shippingOrderAction_list");
		super.push(page);

		return "list"; // page list
	}

	// 查看
	public String toview() {

		ShippingOrder obj = shippingOrderService.get(ShippingOrder.class, model.getId().replaceAll(", ", ""));
		super.push(obj);

		return "toview"; // 转向查看页面
	}

	// 转向新增页面
	public String tocreate() {
		// 准备数据,将所有状态为4的装箱单显示在下面(4.装箱完毕(待委托))
		List<PackingList> packingList = packingListService.find("from PackingList where state=4.0", PackingList.class,
				null);

		super.put("packingList", packingList);

		return "tocreate";
	}

	// 新增保存
	public String insert() {

		model.setId(model.getId().replaceAll(", ", ""));

		shippingOrderService.saveOrUpdate(model);

		return "alist"; // 返回列表，重定向action_list
	}

	// 转向修改页面
	public String toupdate() {

		// 回显数据
		ShippingOrder shippingOrder = shippingOrderService.get(ShippingOrder.class, model.getId());
		// 判断委托单状态是不是未提交状态 5.0
		if (shippingOrder.getState() != 5.0) {

			super.put("msg", "亲,您所选的委托单状态不能进行修改操作!");

			return SUCCESS;
		}

		super.push(shippingOrder);

		return "toupdate";
	}

	// 修改保存
	public String update() {
		ShippingOrder shippingOrder = shippingOrderService.get(ShippingOrder.class, model.getId());

		// 设置修改的属性
		shippingOrder.setOrderType(model.getOrderType());
		shippingOrder.setShipper(model.getShipper());
		shippingOrder.setConsignee(model.getConsignee());
		shippingOrder.setNotifyParty(model.getNotifyParty());
		shippingOrder.setLcNo(model.getLcNo());
		shippingOrder.setPortOfLoading(model.getPortOfLoading());
		shippingOrder.setPortOfTrans(model.getPortOfTrans());
		shippingOrder.setPortOfDischarge(model.getPortOfDischarge());
		shippingOrder.setLoadingDate(model.getLoadingDate());
		shippingOrder.setLimitDate(model.getLimitDate());
		shippingOrder.setIsBatch(model.getIsBatch());
		shippingOrder.setIsTrans(model.getIsTrans());
		shippingOrder.setCopyNum(model.getCopyNum());
		shippingOrder.setRemark(model.getRemark());
		shippingOrder.setSpecialCondition(model.getSpecialCondition());
		shippingOrder.setFreight(model.getFreight());
		shippingOrder.setCheckBy(model.getCheckBy());

		shippingOrderService.saveOrUpdate(shippingOrder);

		return "alist";
	}

	// 删除一条
	public String deleteById() {

		shippingOrderService.deleteById(ShippingOrder.class, model.getId());

		return "alist";
	}

	// 删除多条
	public String delete() {
		
		String[] ids = model.getId().split(", ");
		for (String id : ids) {
			ShippingOrder shippingOrder = shippingOrderService.get(ShippingOrder.class, id);
			// 判断委托单状态是不是未提交状态 5.0
			if (shippingOrder.getState() != 5.0) {
				
				super.put("msg", "亲,您所选的委托单状态不能进行删除操作!");
				
				return SUCCESS;
			}
		}
			

		shippingOrderService.delete(ShippingOrder.class, model.getId().split(", "));

		return "alist";
	}

	// 提交
	// 将委托单状态改为 6.0 ---5.已委托(未提交)6.委托完毕(待出票)
	public String submit() throws Exception {
		// TODO Auto-generated method stub
		ShippingOrder shippingOrder = shippingOrderService.get(ShippingOrder.class, model.getId());
		// 判断委托单状态是不是未提交状态 5.0
		if (shippingOrder.getState() != 5.0) {

			super.put("msg", "亲,您所选的委托单状态不能进行提交操作!");

			return SUCCESS;
		}
		
		shippingOrder.setState(6.0);
		// 将委托单中对应的装箱单和报运单对象状态同步
		PackingList packingList = packingListService.get(PackingList.class, shippingOrder.getId());
		packingList.setState(6.0);
		packingListService.saveOrUpdate(packingList);

		String[] exportIds = packingList.getExportIds().split(", ");
		for (String exportId : exportIds) {
			Export export = exportService.get(Export.class, exportId);
			export.setState(6);
			exportService.saveOrUpdate(export);
		}

		shippingOrderService.saveOrUpdate(shippingOrder);

		return "alist";
	}

	// 取消
	// 将委托单状态改为5.0 ------- 5.已委托(未提交)6.委托完毕(待出票)
	public String cancel() throws Exception {
		// TODO Auto-generated method stub
		ShippingOrder shippingOrder = shippingOrderService.get(ShippingOrder.class, model.getId());
		// 判断委托单状态是不是未提交状态 5.0
		if (shippingOrder.getState() != 6.0) {

			super.put("msg", "亲,您所选的委托单状态不能进行取消操作!");

			return SUCCESS;
		}
		
		shippingOrder.setState(5.0);
		shippingOrderService.saveOrUpdate(shippingOrder);
		// 将委托单中对应的装箱单和报运单对象状态同步
		// 装箱单
		PackingList packingList = packingListService.get(PackingList.class, shippingOrder.getId());
		packingList.setState(5.0);
		packingListService.saveOrUpdate(packingList);

		// 报运单
		String[] exportIds = packingList.getExportIds().split(", ");
		for (String exportId : exportIds) {
			Export export = exportService.get(Export.class, exportId);
			export.setState(5);
			exportService.saveOrUpdate(export);
		}

		return "alist";
	}

}
