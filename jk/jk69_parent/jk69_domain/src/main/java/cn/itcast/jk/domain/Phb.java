package cn.itcast.jk.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @Description:	PhbService接口
 * @Author:			rent
 * @Company:		http://java.itcast.cn
 * @CreateDate:		2017-11-18 22:14:40
 */
public class Phb extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private String ip;			
	private Double num;			
	private Double rownum;			

	
	
	public String getIp() {
		return this.ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}	
	
	public Double getNum() {
		return this.num;
	}
	public void setNum(Double num) {
		this.num = num;
	}	
	
	public Double getRownum() {
		return this.rownum;
	}
	public void setRownum(Double rownum) {
		this.rownum = rownum;
	}	
}
