package cn.itcast.jk.action.baseinfo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Dept;
import cn.itcast.jk.domain.Product;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.service.FactoryService;
import cn.itcast.jk.service.ProductService;
import cn.itcast.util.Page;
import cn.itcast.util.UtilFuns;
import cn.itcast.util.file.FileUtil;

/**
 * 
 * @Description:	ProductService接口
 * @Author:			rent
 * @Company:		http://java.itcast.cn
 * @CreateDate:		2017-11-17 21:25:17
 */

public class BaseProductAction extends BaseAction implements ModelDriven<Product> {
	//注入service
	private ProductService productService;
	private FactoryService factoryService;
	private File file;
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	private String fileFileName;
	
	public void setFactoryService(FactoryService factoryService) {
		this.factoryService = factoryService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//model驱动
	private Product model = new Product();
	public Product getModel() {
		return this.model;
	}
	
	//作为属性驱动，接收并封装页面参数
	private Page page = new Page();			//封装页面的参数，主要当前页参数
	public void setPage(Page page) {
		this.page = page;
	}
	//列表展示
	public String list(){
		String hql = "from Product o";			//查询所有内容
		//给页面提供分页数据
		page = productService.findPage(hql, page, Product.class, null);
		page.setUrl("baseProductAction_list");		//配置分页按钮的转向链接
		super.push(page);
		
		return "plist";						//page list
	}
	
	
	//上传文件方法
	public void upload() throws Exception {
		//获取上传路径
		String realPath = ServletActionContext.getServletContext().getRealPath("/images");
		//判断请求块是否为文件
		if (file!=null) {
			File saveFile = new File(new File(realPath),fileFileName);
			//判断图片路径是否存在
			if (!saveFile.getParentFile().mkdirs()) {	
			}
			//拷贝
			FileUtils.copyFile(file, saveFile);
		}	
	}

	//转向新增页面
	public String tocreate(){	
		String dhql="from Factory";
		List<Factory> factoryList = factoryService.find(dhql, Factory.class, null);
		ActionContext.getContext().put("factoryList", factoryList);
		return "pcreate";
	}
	
	//新增保存
	public String insert() throws Exception{
		if (file!=null) {
			upload();
			String productImage = fileFileName;
			model.setProductImage(productImage);
		}
		if (model.getFactory().getId()!=null) {
			String id = model.getFactory().getId();
			Factory factory = factoryService.get(Factory.class, id);
			model.setFactoryName(factory.getFactoryName());
		}
		productService.saveOrUpdate(model);
		return "alist";			//返回列表，重定向action_list
	}

	//转向修改页面
	public String toupdate(){
		/*
		 * 		String dhql="from Dept where state=1";
		List<Dept> deptList = deptService.find(dhql, Dept.class, null);
		super.put("deptList", deptList);
		User user = userService.get(User.class, model.getId());
		super.push(user);
		
		return "toupdate";
		 * 
		 * */
		String dhql="from Factory";
		List<Factory> factoryList = factoryService.find(dhql, Factory.class, null);
		super.put("factoryList", factoryList);
		
		
		

		Product obj = productService.get(Product.class, model.getId());
		super.push(obj);
		
		return "pupdate";
	}
	
	//修改保存
	public String update() throws Exception{
		if (file!=null) {
			upload();
			String productImage = fileFileName;
			model.setProductImage(productImage);
		}
		
		Product product = productService.get(Product.class, model.getId());
		
		
		//设置修改的属性，根据业务去掉自动生成多余的属性
		product.setId(model.getId());
		product.setProductNo(model.getProductNo());
		
		
		
		product.setDescription(model.getDescription());
		
		//user.getDept().setId(model.getDept().getId());
		
		if (model.getFactory().getId()!=null) {
			String id = model.getFactory().getId();
			Factory factory = factoryService.get(Factory.class, id);
			model.setFactoryName(factory.getFactoryName());
		}
		
		product.setFactoryName(model.getFactoryName());
		
		
		
		
		product.setPrice(model.getPrice());
		product.setSizeLenght(model.getSizeLenght());
		product.setSizeWidth(model.getSizeWidth());
		product.setSizeHeight(model.getSizeHeight());
		product.setColor(model.getColor());
		product.setPacking(model.getPacking());
		product.setPackingUnit(model.getPackingUnit());
		product.setType20(model.getType20());
		product.setType40(model.getType40());
		product.setType40hc(model.getType40hc());
		product.setQty(model.getQty());
		product.setCbm(model.getCbm());
		product.setMpsizeLenght(model.getMpsizeLenght());
		product.setMpsizeWidth(model.getMpsizeWidth());
		product.setMpsizeHeight(model.getMpsizeHeight());
		product.setRemark(model.getRemark());
		product.setInputTime(model.getInputTime());
		product.setCreateBy(model.getCreateBy());
		product.setCreateDept(model.getCreateDept());
		product.setCreateTime(model.getCreateTime());
		
		
		productService.saveOrUpdate(product);
		
		return "alist";
	}
	
	//删除一条
	public String deleteById(){
		productService.deleteById(Product.class, model.getId());
		
		return "alist";
	}
	
	
	//删除多条
	public String delete(){
		productService.delete(Product.class, model.getId().split(", "));
		
		return "alist";
	}
	
	//查看
	public String toview(){
		Product obj = productService.get(Product.class, model.getId());
		super.push(obj);
		
		return "pview";			//转向查看页面
	}
}
