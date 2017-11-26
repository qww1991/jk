package cn.itcast.jk.domain;

import java.util.Date;

/**
 * 
 * @author 龙殇
 * @CreateDate:	2017年11月17日
 */
public class SubjectInfo {
	
	private Feedback feedback;	//多对一
	private String id;
	private String inputBy;
	private Date inputTime;
	private String getBy;
	private Date getTime;
	private String inputInfo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInputBy() {
		return inputBy;
	}
	public void setInputBy(String inputBy) {
		this.inputBy = inputBy;
	}
	public String getGetBy() {
		return getBy;
	}
	public void setGetBy(String getBy) {
		this.getBy = getBy;
	}
	public Feedback getFeedback() {
		return feedback;
	}
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	public String getInputInfo() {
		return inputInfo;
	}
	public void setInputInfo(String inputInfo) {
		this.inputInfo = inputInfo;
	}
	public Date getInputTime() {
		return inputTime;
	}
	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}
	public Date getGetTime() {
		return getTime;
	}
	public void setGetTime(Date getTime) {
		this.getTime = getTime;
	}
	
	
}
