package cn.itcast.jk.action.baseinfo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.service.FactoryService;
import cn.itcast.util.DownloadUtil;
import cn.itcast.util.Page;
import cn.itcast.util.UtilFuns;

public class BaseFactoryAction extends BaseAction implements ModelDriven<Factory>{
	private File file;
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
	private Factory model=new Factory();
	private FactoryService factoryService;
	private Page page=new Page();
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public void setFactoryService(FactoryService factoryService) {
		this.factoryService = factoryService;
	}

	@Override
	public Factory getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	public String list() throws Exception {
		String hql="from Factory ";
		factoryService.findPage(hql,page, Factory.class, null);
		page.setUrl("baseFactoryAction_list");
		ActionContext.getContext().getValueStack().push(page);
	
		
		return "list";
	}
	/**
	 * 查看
	 * @return
	 * @throws Exception
	 */
	public String toview() throws Exception {
		Factory factory = factoryService.get(Factory.class, model.getId());
		ActionContext.getContext().getValueStack().push(factory);
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
		model.setState(1);
		factoryService.saveOrUpdate(model);
		return "insert";
	}

	/**更改跳转回显数据
	 * @return
	 * @throws Exception
	 */
	public String toupdate() throws Exception {
		Factory factory = factoryService.get(Factory.class, model.getId());
		ActionContext.getContext().getValueStack().push(factory);
		return "toupdate";
	}
	
	/**
	 * 修改信息
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		Factory factory = factoryService.get(Factory.class, model.getId());
		
		factory.setAddress(model.getAddress());
		factory.setContacts(model.getContacts());
		factory.setCtype(model.getCtype());
		factory.setFax(model.getFax());
		factory.setFactoryName(model.getFactoryName());
		factory.setFullName(model.getFullName());
		factory.setInspector(model.getInspector());
		factory.setMobile(model.getMobile());
		factory.setPhone(model.getPhone());
		factory.setRemark(model.getRemark());
		factory.setState(model.getState());
		
		
		factoryService.saveOrUpdate(factory);
		return "update";
	}

	
	public String delete() throws Exception {
		String[] ids = model.getId().split(", ");
		factoryService.delete(Factory.class, ids);
			
		return "delete";
	}
	
	public String printAll() throws Exception {
		String path = ServletActionContext.getServletContext().getRealPath(File.separator)+"make/xlsprint/tFACTORY.xlsx";
		FileInputStream inputStream = new FileInputStream(path);

		Workbook book = new XSSFWorkbook(inputStream); // 07版本
		
		Sheet sheet = book.getSheetAt(0);
		
		Row row2 = sheet.getRow(2);
		ArrayList<CellStyle> styleList = new ArrayList<CellStyle>();
		ArrayList<String> strList = new ArrayList<String>();
		for (int i = 0; i < 18; i++) {
			row2.getCell(i + 1).setCellType(Cell.CELL_TYPE_STRING);
			CellStyle cellStyle = row2.getCell(i + 1).getCellStyle();
			styleList.add(i, cellStyle);
			String stringCellValue = row2.getCell(i + 1).getStringCellValue();
			strList.add(i, stringCellValue);
		}
		
		List<Factory> fList = factoryService.find("from Factory", Factory.class, null);
		int rowNum = 2;
		for (Factory fc : fList) {
			String[] string = {fc.getId(),fc.getCtype(),fc.getFullName(),fc.getFactoryName(),fc.getContacts(),fc.getPhone(),fc.getMobile(),fc.getFax(),fc.getAddress(),fc.getInspector(),fc.getRemark(),UtilFuns.convertNull(fc.getOrderNo()),UtilFuns.convertNull(fc.getState()),fc.getCreateBy(),fc.getCreateDept(),UtilFuns.convertNull(fc.getCreateTime()),fc.getUpdateBy(),UtilFuns.convertNull(fc.getUpdateTime())};
			
			Row rowTemp = sheet.createRow(rowNum);
			for (int i = 0; i < 18; i++) {
				Cell cell = rowTemp.createCell(i + 1);
				
				CellStyle cellStyle = styleList.get(i);
				cell.setCellStyle(cellStyle);
				
				String stringCellValue = string[i];
				cell.setCellValue(stringCellValue);
			}
			rowNum++;
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		book.write(outputStream);
		
		DownloadUtil util = new DownloadUtil();
		
		util.download(outputStream, response, "q.xls");
		
		
		return NONE;
	}
	
	public String importFactory() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String path = ServletActionContext.getServletContext().getRealPath(File.separator)+"make/factory/FACTORY.xlsx";
		System.out.println(path);
		FileInputStream is = new FileInputStream(file);
		FileOutputStream os = new FileOutputStream(new File(path));
		byte[] buffer = new byte[1024];
		int length = 0;
		while(-1 != (length = is.read(buffer, 0, buffer.length))) {
			os.write(buffer, 0, length);
		}
		os.close();
		is.close();
		
		FileInputStream inputStream = new FileInputStream(path);
		
		Workbook book = new XSSFWorkbook(inputStream); // 07版本
		Sheet sheet = book.getSheetAt(0);
		
		int firstNum = 2;
		int endNum = sheet.getLastRowNum();
		for (int i = firstNum; i <= endNum; i++) {
			Row rowTemp = sheet.getRow(i);
			String[] string = new String[18];
			for (int j = 0; j < 18; j++) {
				Cell cell = rowTemp.getCell(j + 1);
				String value = cell.getStringCellValue();
				string[j] = value;
			}
			Factory factory = new Factory();
			factory.setId(string[0]);
			factory.setCtype(string[1]);
			factory.setFullName(string[2]);
			factory.setFactoryName(string[3]);
			factory.setContacts(string[4]);
			factory.setPhone(string[5]);
			factory.setMobile(string[6]);
			factory.setFax(string[7]);
			factory.setAddress(string[8]);
			factory.setInspector(string[9]);
			factory.setRemark(string[10]);
			factory.setOrderNo(UtilFuns.ConvertZero(string[11]));
			factory.setState(UtilFuns.ConvertZero(string[12]));
			factory.setCreateBy(string[13]);
			factory.setCreateDept(string[14]);
			factory.setCreateTime(UtilFuns.parseDate(string[15]));
			factory.setUpdateBy(string[16]);
			factory.setUpdateTime(UtilFuns.parseDate(string[17]));
			factoryService.saveOrUpdate(factory);
		}
		
		return list();
	}

	
}
