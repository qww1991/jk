package cn.itcast.jk.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 
 * @author 龙殇
 * @CreateDate:	2017年11月17日
 */
public class Feedback implements Serializable{
	private Set<SubjectInfo> subjectInfos;	//反馈和主题回复,一对多
	private String id;
	private String inputBy;	//接收人
	private String title;	//主题
	private String content;	//详细内容
	private String telephone; //创建人电话
	private String answerBy;	//留言人
	private Integer difficulty;	//解决难度	1.极难 2.比较难 3.有难度 4.一般
	private Integer state;		//状态 0.未处理 1.已处理
	private String createBy;//创建者的id
	private String createDept;//创建者所在部门的id
	private Date createTime;//创建时间
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAnswerBy() {
		return answerBy;
	}
	public void setAnswerBy(String answerBy) {
		this.answerBy = answerBy;
	}
	public Integer getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateDept() {
		return createDept;
	}
	public void setCreateDept(String createDept) {
		this.createDept = createDept;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Set<SubjectInfo> getSubjectInfos() {
		return subjectInfos;
	}
	public void setSubjectInfos(Set<SubjectInfo> subjectInfos) {
		this.subjectInfos = subjectInfos;
	}
	@Override
	public String toString() {
		return "Feedback [subjectInfos=" + subjectInfos + ", id=" + id + ", inputBy=" + inputBy + ", title=" + title
				+ ", content=" + content + ", telephone=" + telephone + ", answerBy=" + answerBy + ", difficulty="
				+ difficulty + ", state=" + state + ", createBy=" + createBy + ", createDept=" + createDept
				+ ", createTime=" + createTime + "]";
	}
	
}
