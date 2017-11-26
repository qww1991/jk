package cn.itcast.jk.action.cargo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.bytecode.enhance.spi.CollectionTracker;
import org.hibernate.hql.internal.ast.tree.FromElement;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.service.ContractProductService;
import cn.itcast.jk.service.ContractService;
import cn.itcast.util.DownloadUtil;


public class OutProductAction extends BaseAction {
	private String inputDate;
	private ContractService contractService;
	public void setContractService(ContractService contractService) {
		this.contractService = contractService;
	}
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	
	/**
	 * @see 跳转到出货表页面
	 * @return
	 * @throws Exception
	 */
	public String toedit() throws Exception {
		return "toedit";
	}
	/**
	 * 导出Execl表文件
	 * @return
	 * @throws Exception
	 */
	public String print1() throws Exception {
		//创建工作部
		Workbook book = new HSSFWorkbook();
		//创建sheet
		Sheet sheet = book.createSheet();
		//合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 8)); //合并单元格
		for(int i=1;i<9;i++){
			sheet.setColumnWidth((short)i, (short)(256*16));
		}
		//写出顶部title
		int rowIndex=0;
		Row row = sheet.createRow(rowIndex++);
		row.setHeightInPoints(36);
		Cell cell = row.createCell(1);
		String date = inputDate.replace("-", "年")+ "月份出货表";
		//大标题
		cell.setCellValue(date);
		cell.setCellStyle(bigTitle(book));
		String titlesmall="客户,订单号,货号,数量,工厂,工厂交期,船期,贸易条款";
		String[] titles = titlesmall.split(",");
		//设置小标题
		Row createRow = sheet.createRow(rowIndex++);
		createRow.setHeightInPoints(26);
		for(int i=1;i<9;i++){
			Cell titleCell=createRow.createCell(i);//坐标
			titleCell.setCellValue(titles[i-1]);//值
			titleCell.setCellStyle(title(book));//样式
		}
		// 循环购销合同货物集合创建内容行
		String[] array = inputDate.split("-");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
 List<Contract> contractList = contractService.sqlFind(Contract.class,"select * from CONTRACT_C t where to_char(t.signing_date,'yyyy')='"+array[0]+"' and to_char(t.signing_date,'mm')='"+array[1]+"'");
 	for (Contract contract : contractList) {
 		Set<ContractProduct> contractProducts = contract.getContractProducts();
 			for (ContractProduct c : contractProducts) {
 				Row crow = sheet.createRow(rowIndex++);
 				String ctext[]= new String[]{contract.getCustomName(),contract.getContractNo(),c.getProductNo(),c.getCnumber().toString(),c.getFactoryName(),format.format(contract.getDeliveryPeriod()),format.format(contract.getShipTime()),contract.getTradeTerms()};
 				for(int i=1;i<9;i++){
 					Cell titleCell=crow.createCell(i);
 					titleCell.setCellValue(ctext[i-1]);
 					titleCell.setCellStyle(text(book));
 				}
 			}
}

		// 向外输出excel文件
				HttpServletResponse response = ServletActionContext.getResponse();
				
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				
				book.write(outputStream);
				
				DownloadUtil util = new DownloadUtil();
				
				util.download(outputStream, response, date + ".xls");
		
		return NONE;
	}
	public String print() throws Exception {
		String path=ServletActionContext.getServletContext().getRealPath(File.separator)+"make/xlsprint/tOUTPRODUCT.xlsx";
		//创建输入流
		InputStream is=new FileInputStream(path);
		//通过流获取工作簿
		Workbook book = new XSSFWorkbook(is);
		//获取sheet
		Sheet sheet = book.getSheetAt(0);
		//合并单元格
		
		//写出顶部title
		int rowIndex=0;
		Row row = sheet.getRow(rowIndex++);
		Cell cell = row.getCell(1);
		String date = inputDate.replace("-", "年")+ "月份出货表";
		//大标题
		cell.setCellValue(date);
		//小标题
		rowIndex++;
		//获取提供的样式  放入数组中
		Row row2 = sheet.getRow(2);
		CellStyle[] cs=new CellStyle[8];
		for(int i=0;i<8;i++){
			cs[i] = row2.getCell(i+1).getCellStyle();
		}
		
		// 循环购销合同货物集合创建内容行
		String[] array = inputDate.split("-");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
 List<Contract> contractList = contractService.sqlFind(Contract.class,"select * from CONTRACT_C t where to_char(t.signing_date,'yyyy')='"+array[0]+"' and to_char(t.signing_date,'mm')='"+array[1]+"'");
 	for (Contract contract : contractList) {
 		Set<ContractProduct> contractProducts = contract.getContractProducts();
 			for (ContractProduct c : contractProducts) {
 				Row crow = sheet.createRow(rowIndex++);
 				String ctext[]= new String[]{contract.getCustomName(),contract.getContractNo(),c.getProductNo(),c.getCnumber().toString(),c.getFactoryName(),format.format(contract.getDeliveryPeriod()),format.format(contract.getShipTime()),contract.getTradeTerms()};
 				for(int i=1;i<9;i++){
 					Cell titleCell=crow.createCell(i);
 					titleCell.setCellValue(ctext[i-1]);
 					titleCell.setCellStyle(cs[i-1]);
 				}
 			}
}

		// 向外输出excel文件
				HttpServletResponse response = ServletActionContext.getResponse();
				
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				
				book.write(outputStream);
				
				DownloadUtil util = new DownloadUtil();
				
				util.download(outputStream, response, date + ".xlsx");
		
		return NONE;
	}
	//大标题的样式
		public CellStyle bigTitle(Workbook wb){
			CellStyle style = wb.createCellStyle();
			Font font = wb.createFont();
			font.setFontName("宋体");
			font.setFontHeightInPoints((short)16);
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);					//字体加粗
			
			style.setFont(font);
			
			style.setAlignment(CellStyle.ALIGN_CENTER);					//横向居中
			style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中
			
			return style;
		}
		//小标题的样式
		public CellStyle title(Workbook wb){
			CellStyle style = wb.createCellStyle();
			Font font = wb.createFont();
			font.setFontName("黑体");
			font.setFontHeightInPoints((short)12);
			
			style.setFont(font);
			
			style.setAlignment(CellStyle.ALIGN_CENTER);					//横向居中
			style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中
			
			style.setBorderTop(CellStyle.BORDER_THIN);					//上细线
			style.setBorderBottom(CellStyle.BORDER_THIN);				//下细线
			style.setBorderLeft(CellStyle.BORDER_THIN);					//左细线
			style.setBorderRight(CellStyle.BORDER_THIN);				//右细线
			
			return style;
		}
		
		//文字样式
		public CellStyle text(Workbook wb){
			CellStyle style = wb.createCellStyle();
			Font font = wb.createFont();
			font.setFontName("Times New Roman");
			font.setFontHeightInPoints((short)10);
			
			style.setFont(font);
			
			style.setAlignment(CellStyle.ALIGN_LEFT);					//横向居左
			style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中
			
			style.setBorderTop(CellStyle.BORDER_THIN);					//上细线
			style.setBorderBottom(CellStyle.BORDER_THIN);				//下细线
			style.setBorderLeft(CellStyle.BORDER_THIN);					//左细线
			style.setBorderRight(CellStyle.BORDER_THIN);				//右细线
			
			return style;
		}
}
