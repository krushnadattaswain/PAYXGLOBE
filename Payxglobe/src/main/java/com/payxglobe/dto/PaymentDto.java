package com.payxglobe.dto;

public class PaymentDto {

	private String payeeAcc;
	private String toCurr;
	private String fromCurr;
	private Double amt;
	
	
	public String getPayeeAcc() {
		return payeeAcc;
	}
	public void setPayeeAcc(String payeeAcc) {
		this.payeeAcc = payeeAcc;
	}
	public String getToCurr() {
		return toCurr;
	}
	public void setToCurr(String toCurr) {
		this.toCurr = toCurr;
	}
	public String getFromCurr() {
		return fromCurr;
	}
	public void setFromCurr(String fromCurr) {
		this.fromCurr = fromCurr;
	}
	public Double getAmt() {
		return amt;
	}
	public void setAmt(Double amt) {
		this.amt = amt;
	}
	
	
}
