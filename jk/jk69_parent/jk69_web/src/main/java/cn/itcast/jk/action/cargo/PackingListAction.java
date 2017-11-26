package cn.itcast.jk.action.cargo;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Export;
import cn.itcast.jk.domain.PackingList;
import cn.itcast.jk.service.ExportService;
import cn.itcast.jk.service.PackingListService;
import cn.itcast.util.Page;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

/**
 * @Description: PackingListService接口
 * @Author: rent
 * @Company: http://java.itcast.cn
 * @CreateDate: 2017-11-16 15:22:24
 */

public class PackingListAction extends BaseAction implements ModelDriven<PackingList> {
	// 注入service
	private PackingListService packingListService;
	private ExportService exportService;

	public void setExportService(ExportService exportService) {
		this.exportService = exportService;
	}

	public void setPackingListService(PackingListService packingListService) {
		this.packingListService = packingListService;
	}

	// model驱动
	private PackingList model = new PackingList();

	public PackingList getModel() {
		return this.model;
	}

	// 作为属性驱动，接收并封装页面参数
	private Page page = new Page(); // 封装页面的参数，主要当前页参数

	public void setPage(Page page) {
		this.page = page;
	}

	// 列表展示
	public String list() {
		String hql = "from PackingList o"; // 查询所有内容

		// 配置分页按钮的转向链接
		packingListService.findPage(hql, page, PackingList.class, null);
		// 给页面提供分页数据
		page.setUrl("packingListAction_list");
		super.push(page);

		return "list"; // page list
	}

	// 转向新增页面
	public String tocreate() {
		// 准备数据
		// List<PackingList> packingListList =
		// packingListService.packingListList();
		// 页面就可以访问packingListList
		// super.put("packingListList", packingListList);
		List<Export> exportList = exportService.find("from Export where state=2", Export.class, null);
		super.put("exportList", exportList);
		return "pcreate";
	}

	// 新增保存
	public String insert() {
		// private String exportIds; //报运ID集合
		// private String exportNos; //报运NO集合x,y|z,h
		String exportIds = model.getExportIds();
		String[] ids = exportIds.split(", ");
		String nos = "";
		for (String id : ids) {
			Export export = exportService.get(Export.class, id);
			export.setState(3);
			nos += " " + id;
			exportService.saveOrUpdate(export);
		}
		model.setExportNos(nos);
		packingListService.saveOrUpdate(model);

		return "alist"; // 返回列表，重定向action_list
	}

	// 转向修改页面
	public String toupdate() {
		// 准备数据
		// List<PackingList> packingListList =
		// packingListService.packingListList();
		// 页面就可以访问packingListList
		// super.put("packingListList", packingListList);

		// 准备修改的数据
		PackingList obj = packingListService.get(PackingList.class, model.getId());

		// 判断装箱单状态是不是未提交状态
		if (obj.getState() != 3.0) {

			super.put("msg", "亲,您所选的装箱单状态不能进行修改操作!");

			return SUCCESS;
		}

		super.push(obj);

		return "pupdate";
	}

	// 修改保存
	public String update() {
		PackingList packingList = packingListService.get(PackingList.class, model.getId());

		// 设置修改的属性，根据业务去掉自动生成多余的属性
		packingList.setSeller(model.getSeller());
		packingList.setBuyer(model.getBuyer());
		packingList.setInvoiceNo(model.getInvoiceNo());
		packingList.setInvoiceDate(model.getInvoiceDate());
		packingList.setMarks(model.getMarks());
		packingList.setDescriptions(model.getDescriptions());

		packingListService.saveOrUpdate(packingList);

		return "alist";
	}

	// 删除一条
	public String deleteById() {

		packingListService.deleteById(PackingList.class, model.getId());

		return "alist";
	}

	// 删除多条
	public String delete() {

		String[] ids = model.getId().split(", ");
		for (String id : ids) {
			PackingList obj = packingListService.get(PackingList.class, id);
			// 判断装箱单状态是不是未提交状态
			if (obj.getState() != 3.0) {

				super.put("msg", "亲,您所选的装箱单状态不能进行删除操作!");

				return SUCCESS;
			}
		}

		packingListService.delete(PackingList.class, model.getId().split(", "));

		return "alist";
	}

	// 查看
	public String toview() {
		PackingList obj = packingListService.get(PackingList.class, model.getId());
		super.push(obj);

		return "pview"; // 转向查看页面
	}

	// 提交
	// 将装箱单状态改为4 //3.已装箱(未提交)4.装箱完毕(待委托)
	public String submit() throws Exception {
		// TODO Auto-generated method stub
		PackingList packingList = packingListService.get(PackingList.class, model.getId());
		// 判断装箱单状态是不是未提交状态
		if (packingList.getState() != 3.0) {

			super.put("msg", "亲,您所选的装箱单状态不能进行提交操作!");

			return SUCCESS;
		}

		packingList.setState(4.0);
		packingListService.saveOrUpdate(packingList);

		// 将装箱单下的报运单对象的状态同步
		String[] exportIds = packingList.getExportIds().split(", ");
		for (String exportId : exportIds) {
			Export export = exportService.get(Export.class, exportId);
			export.setState(4);
			exportService.saveOrUpdate(export);
		}

		return "alist";
	}

	// 取消
	// 将装箱单状态改为3 //3.已装箱(未提交)4.装箱完毕(待委托)
	public String cancel() throws Exception {
		// TODO Auto-generated method stub
		PackingList packingList = packingListService.get(PackingList.class, model.getId());
		// 判断装箱单状态是不是已提交状态
		if (packingList.getState() != 4.0) {

			super.put("msg", "亲,您所选的装箱单状态不能进行取消操作!");

			return SUCCESS;
		}
		
		packingList.setState(3.0);
		packingListService.saveOrUpdate(packingList);

		// 将装箱单下的报运单对象的状态同步
		String[] exportIds = packingList.getExportIds().split(", ");
		for (String exportId : exportIds) {
			Export export = exportService.get(Export.class, exportId);
			export.setState(3);
			exportService.saveOrUpdate(export);
		}

		return "alist";
	}
}
