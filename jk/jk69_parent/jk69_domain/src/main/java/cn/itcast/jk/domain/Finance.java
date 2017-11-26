package cn.itcast.jk.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @Description:	FinanceService接口
 * @Author:			rent
 * @Company:		http://java.itcast.cn
 * @CreateDate:		2017-11-18 18:56:59
 */
public class Finance extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private String id;	  		
	private Date inputDate;		//制单日期	
	private String inputBy;		//制单人
	private Double state;		//状态  5.未进账 6.已进账

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public Date getInputDate() {
		return this.inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}	
	
	public String getInputBy() {
		return this.inputBy;
	}
	public void setInputBy(String inputBy) {
		this.inputBy = inputBy;
	}	
	
	public Double getState() {
		return this.state;
	}
	public void setState(Double state) {
		this.state = state;
	}	
	
	
	
}
