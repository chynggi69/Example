package com.cyg.dto;

public class Total2 {
	//테이블과 직접 매핑되지 않는다.
	//질의 결과나 뷰와 매핑시킬 수 있으며, BMember & HomeBook과 관련되어 있다.
	private int countofboard;
	private int countofhomebook;
	private int sumOfRevenue;
	@Override
	public String toString() {
		return "Total2 [countofboard=" + countofboard + ", countofhomebook=" + countofhomebook + ", sumOfRevenue="
				+ sumOfRevenue + ", sumOfExpense=" + sumOfExpense + "]";
	}
	public int getCountofboard() {
		return countofboard;
	}
	public void setCountofboard(int countofboard) {
		this.countofboard = countofboard;
	}
	public int getCountofhomebook() {
		return countofhomebook;
	}
	public void setCountofhomebook(int countofhomebook) {
		this.countofhomebook = countofhomebook;
	}
	public int getSumOfExpense() {
		return sumOfExpense;
	}
	public void setSumOfExpense(int sumOfExpense) {
		this.sumOfExpense = sumOfExpense;
	}
	private int sumOfExpense;
	
}
