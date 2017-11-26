package cn.itcast.jk.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @Description:	ProductService接口
 * @Author:			rent
 * @Company:		http://java.itcast.cn
 * @CreateDate:		2017-11-17 21:25:17
 */
public class Product extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private Factory factory;

	private String id;	  	//商品id
	private String productNo;		//编号	
	private String productImage;	//照片	
	private String description;		//描述	

	private String factoryName;		//厂家简称
	private Double price;			//市场价
	private Double sizeLenght;		//尺寸长
	private Double sizeWidth;		//尺寸宽
	private Double sizeHeight;		//尺寸高	
	private String color;			//颜色
	private String packing;			//包装
	private String packingUnit;		//包装单位	
	private Double type20;			//集装箱类别20
	private Double type40;			//集装箱类别40
	private Double type40hc;		//集装箱类别40HC	
	private Double qty;			    //数量
	private Double cbm;				//体积
	private Double mpsizeLenght;	//大箱尺寸长	
	private Double mpsizeWidth;		//大箱尺寸宽		
	private Double mpsizeHeight;	//大箱尺寸高	
	private String remark;			//备注
	private Date inputTime;			//创建日期
	
	public Factory getFactory() {
		return factory;
	}
	public void setFactory(Factory factory) {
		this.factory = factory;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getProductNo() {
		return this.productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}	
	
	public String getProductImage() {
		return this.productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}	
	
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	

	public String getFactoryName() {
		return this.factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}	
	
	public Double getPrice() {
		return this.price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}	
	
	public Double getSizeLenght() {
		return this.sizeLenght;
	}
	public void setSizeLenght(Double sizeLenght) {
		this.sizeLenght = sizeLenght;
	}	
	
	public Double getSizeWidth() {
		return this.sizeWidth;
	}
	public void setSizeWidth(Double sizeWidth) {
		this.sizeWidth = sizeWidth;
	}	
	
	public Double getSizeHeight() {
		return this.sizeHeight;
	}
	public void setSizeHeight(Double sizeHeight) {
		this.sizeHeight = sizeHeight;
	}	
	
	public String getColor() {
		return this.color;
	}
	public void setColor(String color) {
		this.color = color;
	}	
	
	public String getPacking() {
		return this.packing;
	}
	public void setPacking(String packing) {
		this.packing = packing;
	}	
	
	public String getPackingUnit() {
		return this.packingUnit;
	}
	public void setPackingUnit(String packingUnit) {
		this.packingUnit = packingUnit;
	}	
	
	public Double getType20() {
		return this.type20;
	}
	public void setType20(Double type20) {
		this.type20 = type20;
	}	
	
	public Double getType40() {
		return this.type40;
	}
	public void setType40(Double type40) {
		this.type40 = type40;
	}	
	
	public Double getType40hc() {
		return this.type40hc;
	}
	public void setType40hc(Double type40hc) {
		this.type40hc = type40hc;
	}	
	
	public Double getQty() {
		return this.qty;
	}
	public void setQty(Double qty) {
		this.qty = qty;
	}	
	
	public Double getCbm() {
		return this.cbm;
	}
	public void setCbm(Double cbm) {
		this.cbm = cbm;
	}	
	
	public Double getMpsizeLenght() {
		return this.mpsizeLenght;
	}
	public void setMpsizeLenght(Double mpsizeLenght) {
		this.mpsizeLenght = mpsizeLenght;
	}	
	
	public Double getMpsizeWidth() {
		return this.mpsizeWidth;
	}
	public void setMpsizeWidth(Double mpsizeWidth) {
		this.mpsizeWidth = mpsizeWidth;
	}	
	
	public Double getMpsizeHeight() {
		return this.mpsizeHeight;
	}
	public void setMpsizeHeight(Double mpsizeHeight) {
		this.mpsizeHeight = mpsizeHeight;
	}	
	
	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}	
	
	public Date getInputTime() {
		return this.inputTime;
	}
	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}	
	
	
	
}
