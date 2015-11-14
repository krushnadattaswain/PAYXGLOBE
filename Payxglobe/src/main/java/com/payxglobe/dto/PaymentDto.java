package com.payxglobe.dto;

import com.payxglobe.enums.CurrencyEnum;

public class PaymentDto {

	//private String payeeAcc;
	private CurrencyEnum toCurr;
	private CurrencyEnum fromCurr;
	private Double amt;
	
	
	/*public String getPayeeAcc() {
		return payeeAcc;
	}
	public void setPayeeAcc(String payeeAcc) {
		this.payeeAcc = payeeAcc;
	}*/
	public CurrencyEnum getToCurr() {
		return toCurr;
	}
	public void setToCurr(CurrencyEnum toCurr) {
		this.toCurr = toCurr;
	}
	public CurrencyEnum getFromCurr() {
		fromCurr = CurrencyEnum.CNY == toCurr ? CurrencyEnum.USD : CurrencyEnum.CNY;
		return fromCurr;
	}
	public void setFromCurr(CurrencyEnum fromCurr) {
		this.fromCurr = fromCurr;
	}
	public Double getAmt() {
		return amt;
	}
	public void setAmt(Double amt) {
		this.amt = amt;
	}
	
	
}
