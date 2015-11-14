package com.payxglobe.dto;

import com.payxglobe.enums.CurrencyEnum;

public class FXRateDto {

	private CurrencyEnum from;
	private CurrencyEnum to;
	private String amt;
	
	public CurrencyEnum getFrom() {
		return from;
	}
	public void setFrom(CurrencyEnum from) {
		this.from = from;
	}
	public CurrencyEnum getTo() {
		return to;
	}
	public void setTo(CurrencyEnum to) {
		this.to = to;
	}
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	


	
}
