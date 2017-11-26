package cn.itcast.jk.action.cargo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.export.webservice.IEpService;
import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.Export;
import cn.itcast.jk.domain.ExportProduct;
import cn.itcast.jk.service.ContractService;
import cn.itcast.jk.service.ExportProductService;
import cn.itcast.jk.service.ExportService;
import cn.itcast.util.Page;
import cn.itcast.util.UtilFuns;

public class ExportAction extends BaseAction implements ModelDriven<Export> {
	private Export model = new Export();
	private ExportService exportService;
	private ContractService contractService;
	private ExportProductService exportProductService;
	private IEpService epService;

	public void setEpService(IEpService epService) {
		this.epService = epService;
	}

	public void setExportProductService(ExportProductService exportProductService) {
		this.exportProductService = exportProductService;
	}

	private String[] mr_id;
	private String[] mr_changed;
	private Integer[] mr_cnumber;
	private Double[] mr_grossWeight;
	private Double[] mr_netWeight;
	private Double[] mr_sizeLength;
	private Double[] mr_sizeWidth;
	private Double[] mr_sizeHeight;
	private Double[] mr_exPrice;
	private Double[] mr_tax;

	public String[] getMr_id() {
		return mr_id;
	}

	public void setMr_id(String[] mr_id) {
		this.mr_id = mr_id;
	}

	public String[] getMr_changed() {
		return mr_changed;
	}

	public void setMr_changed(String[] mr_changed) {
		this.mr_changed = mr_changed;
	}

	public Integer[] getMr_cnumber() {
		return mr_cnumber;
	}

	public void setMr_cnumber(Integer[] mr_cnumber) {
		this.mr_cnumber = mr_cnumber;
	}

	public Double[] getMr_grossWeight() {
		return mr_grossWeight;
	}

	public void setMr_grossWeight(Double[] mr_grossWeight) {
		this.mr_grossWeight = mr_grossWeight;
	}

	public Double[] getMr_netWeight() {
		return mr_netWeight;
	}

	public void setMr_netWeight(Double[] mr_netWeight) {
		this.mr_netWeight = mr_netWeight;
	}

	public Double[] getMr_sizeLength() {
		return mr_sizeLength;
	}

	public void setMr_sizeLength(Double[] mr_sizeLength) {
		this.mr_sizeLength = mr_sizeLength;
	}

	public Double[] getMr_sizeWidth() {
		return mr_sizeWidth;
	}

	public void setMr_sizeWidth(Double[] mr_sizeWidth) {
		this.mr_sizeWidth = mr_sizeWidth;
	}

	public Double[] getMr_sizeHeight() {
		return mr_sizeHeight;
	}

	public void setMr_sizeHeight(Double[] mr_sizeHeight) {
		this.mr_sizeHeight = mr_sizeHeight;
	}

	public Double[] getMr_exPrice() {
		return mr_exPrice;
	}

	public void setMr_exPrice(Double[] mr_exPrice) {
		this.mr_exPrice = mr_exPrice;
	}

	public Double[] getMr_tax() {
		return mr_tax;
	}

	public void setMr_tax(Double[] mr_tax) {
		this.mr_tax = mr_tax;
	}

	public void setContractService(ContractService contractService) {
		this.contractService = contractService;
	}

	private Page page = new Page();

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public void setExportService(ExportService exportService) {
		this.exportService = exportService;
	}

	@Override
	public Export getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	/**
	 * 显示已经提交的购销合同
	 * 
	 * @return
	 * @throws Exception
	 */
	public String contractList() throws Exception {
		String hql = "from Contract where state=1";
		contractService.findPage(hql, page, Contract.class, null);
		page.setUrl("exportAction_contractList");
		super.push(page);
		return "contractList";
	}

	public String list() throws Exception {
		String hql = "from Export where 1=1 ";
		exportService.findPage(hql, page, Export.class, null);
		page.setUrl("exportAction_list");
		ActionContext.getContext().getValueStack().push(page);
		return "list";
	}

	/**
	 * 用户查看
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toview() throws Exception {
		Export export = exportService.get(Export.class, model.getId());
		ActionContext.getContext().getValueStack().push(export);
		return "toview";
	}

	/**
	 * 新增跳转新增页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String tocreate() throws Exception {
		return "tocreate";
	}

	public String insert() throws Exception {
		exportService.saveOrUpdate(model);
		return "alist";
	}

	/**
	 * 更改跳转回显数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toupdate() throws Exception {
		Export export = exportService.get(Export.class, model.getId());
		// 判断状态
		if (export.getState() != 0) {

			super.put("msg", "亲,您所选的报运单状态不能进行修改操作!");

			return SUCCESS;
		}

		super.push(export);

		return "toupdate";
	}

	/**
	 * 修改
	 * 
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		Export obj = exportService.get(Export.class, model.getId());
		obj.setInputDate(model.getInputDate());
		obj.setLcno(model.getLcno());
		obj.setConsignee(model.getConsignee());
		obj.setShipmentPort(model.getShipmentPort());
		obj.setDestinationPort(model.getDestinationPort());
		obj.setTransportMode(model.getTransportMode());
		obj.setPriceCondition(model.getPriceCondition());
		obj.setMarks(model.getMarks());// 唛头，具有一定格式的说明
		obj.setRemark(model.getRemark());
		exportService.saveOrUpdate(obj);
		// 修改货物并提交
		for (int i = 0; i < mr_id.length; i++) {
			if (mr_changed[i].equals("1")) {
				ExportProduct exportProduct = exportProductService.get(ExportProduct.class, mr_id[i]);
				exportProduct.setCnumber(mr_cnumber[i]);
				exportProduct.setGrossWeight(mr_grossWeight[i]);
				exportProduct.setNetWeight(mr_netWeight[i]);
				exportProduct.setSizeLength(mr_sizeLength[i]);
				exportProduct.setSizeWidth(mr_sizeWidth[i]);
				exportProduct.setSizeHeight(mr_sizeHeight[i]);
				exportProduct.setExPrice(mr_exPrice[i]);
				exportProduct.setTax(mr_tax[i]);

				exportProductService.saveOrUpdate(exportProduct);
			}
		}
		return "alist";
	}

	// delete
	public String delete() throws Exception {
		String[] ids = model.getId().split(", ");
		// 判断状态
		for (String id : ids) {
			Export export = exportService.get(Export.class, id);
			if (export.getState() != 0) {
				super.put("msg", "亲,您所选的报运单状态不能进行删除操作!");
				return SUCCESS;
			}
		}

		exportService.delete(Export.class, ids);

		return "alist";
	}

	/**
	 * 修改状态
	 * 
	 * @return
	 * @throws Exception
	 */
	public String submit() throws Exception {

		Export export = exportService.get(Export.class, model.getId());

		// 判断状态
		if (export.getState() != 0) {

			super.put("msg", "亲,您所选的报运单状态不能进行提交操作!");

			return SUCCESS;
		}

		export.setState(1);
		exportService.saveOrUpdate(export);

		return "alist";
	}

	public String cancel() throws Exception {
		Export export = exportService.get(Export.class, model.getId());

		// 判断状态
		if (export.getState() != 1) {

			super.put("msg", "亲,您所选的报运单状态不能进行取消提交操作!");

			return SUCCESS;
		}

		export.setState(0);

		exportService.saveOrUpdate(export);

		return "alist";
	}

	//
	public String getDate() throws Exception {

		Export export = exportService.get(Export.class, model.getId());
		Set<ExportProduct> exportProducts = export.getExportProducts();
		ArrayList arrayList = new ArrayList();
		for (ExportProduct p : exportProducts) {
			// ("mRecordTable", value[i].id, value[i].productNo,
			// value[i].cnumber, value[i].grossWeight, value[i].netWeight,
			// value[i].sizeLength, value[i].sizeWidth, value[i].sizeHeight,
			// value[i].exPrice, value[i].tax)
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", p.getId());
			map.put("productNo", UtilFuns.convertNull(p.getProductNo()));
			map.put("cnumber", UtilFuns.convertNull(p.getCnumber()));
			map.put("grossWeight", UtilFuns.convertNull(p.getGrossWeight()));
			map.put("netWeight", UtilFuns.convertNull(p.getNetWeight()));
			map.put("sizeLength", UtilFuns.convertNull(p.getSizeLength()));
			map.put("sizeWidth", UtilFuns.convertNull(p.getSizeWidth()));
			map.put("sizeHeight", UtilFuns.convertNull(p.getSizeHeight()));
			map.put("exPrice", UtilFuns.convertNull(p.getExPrice()));
			map.put("tax", UtilFuns.convertNull(p.getTax()));
			arrayList.add(map);
		}
		String jsonString = JSON.toJSONString(arrayList);

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");// json串的mime类型：application/json
		response.setHeader("Cache-Control", "no-cache");// 设置响应结束时，不使用缓存
		response.getWriter().write(jsonString);
		return NONE;
	}

	private Object getWriter() {
		// TODO Auto-generated method stub
		return null;
	}

	public String exportE() throws Exception {
		Export export = exportService.get(Export.class, model.getId());
		HashMap exportMap = new HashMap();
		exportMap.put("exportId", export.getId());
		exportMap.put("inputDate", export.getInputDate());
		exportMap.put("shipmentPort", export.getShipmentPort());
		exportMap.put("destinationPort", export.getDestinationPort());
		exportMap.put("transportMode", export.getTransportMode());
		exportMap.put("priceCondition", export.getPriceCondition());
		exportMap.put("boxNums", export.getBoxNums());
		exportMap.put("grossWeights", export.getGrossWeights());
		exportMap.put("measurements", export.getMeasurements());
		Set<ExportProduct> exportProducts = export.getExportProducts();
		HashSet epSets = new HashSet();
		for (ExportProduct ep : exportProducts) {
			HashMap epMap = new HashMap();
			epMap.put("exportProductId", ep.getId());
			epMap.put("productNo", ep.getProductNo());
			epMap.put("packingUnit", ep.getPackingUnit());
			epMap.put("cnumber", ep.getCnumber());
			epMap.put("boxNum", ep.getBoxNum());
			epMap.put("grossWeight", ep.getGrossWeight());
			epMap.put("netWeight", ep.getNetWeight());
			epMap.put("sizeLength", ep.getSizeLength());
			epMap.put("sizeWidth", ep.getSizeWidth());
			epMap.put("sizeHeight", ep.getSizeHeight());
			epMap.put("exPrice", ep.getExPrice());
			epMap.put("price", ep.getPrice());
			epMap.put("tax", ep.getTax());
			epSets.add(epMap);
		}
		exportMap.put("products", epSets);
		String jsonString = JSON.toJSONString(exportMap);
		String exportE = epService.exportE(jsonString);
		HashMap returnExport = JSON.parseObject(exportE, HashMap.class);

		String extId = returnExport.get("exportId").toString();
		// 根据ID获取报云单对象并修改数据提交数据库
		Export export2 = exportService.get(Export.class, extId); // 海关报云单返回的id获取的数据库中报云单对象
		export2.setState((Integer.parseInt(returnExport.get("state").toString())));
		export2.setRemark((returnExport.get("remark").toString()));
		exportService.saveOrUpdate(export2);

		// 获取所有返回的货物的tax根据id先查询出报运单货物对象
		List<HashMap> parseArray = JSON.parseArray(returnExport.get("products").toString(), HashMap.class);

		for (HashMap hashMap : parseArray) {
			String epId = hashMap.get("exportProductId").toString();
			ExportProduct exportProduct = exportProductService.get(ExportProduct.class, epId);
			// 更新海关返回的tax税金
			exportProduct.setTax(Double.parseDouble(hashMap.get("tax").toString()));
			// 保存到数据库
			exportProductService.saveOrUpdate(exportProduct);
		}

		return "alist";
	}
}
