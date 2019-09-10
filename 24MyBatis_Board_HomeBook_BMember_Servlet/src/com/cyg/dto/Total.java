package com.cyg.dto;

public class Total {
	//테이블과 직접 매핑되지 않는다.
	//질의 결과나 뷰와 매핑시킬 수 있으며, BMember & HomeBook과 관련되어 있다.
	private String memId;
	private String memName;
	private int sumOfRevenue;
	private int sumOfExpense;
	@Override
	public String toString() {
		return "Total [memId=" + memId + ", memName=" + memName + ", sumOfRevenue=" + sumOfRevenue + ", sumOfExpense="
				+ sumOfExpense + "]";
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public int getSumOfRevenue() {
		return sumOfRevenue;
	}
	public void setSumOfRevenue(int sumOfRevenue) {
		this.sumOfRevenue = sumOfRevenue;
	}
	public int getSumOfExpense() {
		return sumOfExpense;
	}
	public void setSumOfExpense(int sumOfExpense) {
		this.sumOfExpense = sumOfExpense;
	}
}
