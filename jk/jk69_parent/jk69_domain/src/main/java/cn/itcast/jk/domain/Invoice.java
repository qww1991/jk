package cn.itcast.jk.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @Description:	InvoiceService接口
 * @Author:			rent
 * @Company:		http://java.itcast.cn
 * @CreateDate:		2017-11-17 21:12:28
 */
public class Invoice extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private String id;	  			
	private String scNo;			//发票号
	private String blNo;			//提单号
	private String tradeTerms;		//贸易条款
	private Double state;			//4.待出票 5.已出票未进账 6.已进账

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getScNo() {
		return this.scNo;
	}
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}	
	
	public String getBlNo() {
		return this.blNo;
	}
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}	
	
	public String getTradeTerms() {
		return this.tradeTerms;
	}
	public void setTradeTerms(String tradeTerms) {
		this.tradeTerms = tradeTerms;
	}	
	
	public Double getState() {
		return this.state;
	}
	public void setState(Double state) {
		this.state = state;
	}	
	
	
	
}
