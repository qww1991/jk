package cn.itcast.jk.domain;

public class UserBBS {
	private String id;
	private String user_id;
	private String content;
	private Integer state;
	private Integer left;
	private Integer top;
	private String create_time;
	private String backGround1;
	private String backGround2;
	private String backGround3;
	private String icon;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getLeft() {
		return left;
	}
	public void setLeft(Integer left) {
		this.left = left;
	}
	public Integer getTop() {
		return top;
	}
	public void setTop(Integer top) {
		this.top = top;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getBackGround1() {
		return backGround1;
	}
	public void setBackGround1(String backGround1) {
		this.backGround1 = backGround1;
	}
	public String getBackGround2() {
		return backGround2;
	}
	public void setBackGround2(String backGround2) {
		this.backGround2 = backGround2;
	}
	public String getBackGround3() {
		return backGround3;
	}
	public void setBackGround3(String backGround3) {
		this.backGround3 = backGround3;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	@Override
	public String toString() {
		return "UserBBS [id=" + id + ", user_id=" + user_id + ", content=" + content + ", state=" + state + ", left="
				+ left + ", top=" + top + ", create_time=" + create_time + ", backGround1=" + backGround1
				+ ", backGround2=" + backGround2 + ", backGround3=" + backGround3 + ", icon=" + icon + "]";
	}
	
}
