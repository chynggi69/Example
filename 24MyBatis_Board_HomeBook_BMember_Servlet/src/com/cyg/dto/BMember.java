package com.cyg.dto;

public class BMember {
	private String mid;
	private String mname;
	private String mpassword;
	private String mphone;
	private String mjoinDate;
	public BMember() {
		super();
	}
	public BMember(String mid, String mname, String mpassword, String mphone, String mjoinDate) {
		this.mid = mid;
		this.mname = mname;
		this.mpassword = mpassword;
		this.mphone = mphone;
		this.mjoinDate = mjoinDate;
	}
	@Override
	public String toString() {
		return "BMember [mid=" + mid + ", mname=" + mname + ", mpassword=" + mpassword + ", mphone=" + mphone
				+ ", mjoinDate=" + mjoinDate + "]";
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getMjoinDate() {
		return mjoinDate;
	}
	public void setMjoinDate(String mjoinDate) {
		this.mjoinDate = mjoinDate;
	}
	
	
}
