package com.cyg.dto;

public class HomeBook {
	private long serialno;
	private String day;
	private String section;
	private String account_title;
	private String remark;
	private int revenue;
	private int expense;
	private String user_id;
	@Override
	public String toString() {
		return "Homebook [serialno=" + serialno + ", day=" + day + ", section=" + section + ", account_title="
				+ account_title + ", remark=" + remark + ", revenue=" + revenue + ", expense=" + expense + ", user_id="
				+ user_id + "]";
	}
	public long getSerialno() {
		return serialno;
	}
	public void setSerialno(long serialno) {
		this.serialno = serialno;
	}
	public String getDate() {
		return day;
	}
	public void setDate(String date) {
		this.day = date;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getAccount_title() {
		return account_title;
	}
	public void setAccount_title(String account_title) {
		this.account_title = account_title;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getRevenue() {
		return revenue;
	}
	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	public int getExpense() {
		return expense;
	}
	public void setExpense(int expense) {
		this.expense = expense;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}
