package com.payxglobe.ripple.dto;

import com.payxglobe.enums.CurrencyEnum;

public class RippleCurrBalanceDto {

	private double value;
	private CurrencyEnum currency;
	private String counterparty;
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public CurrencyEnum getCurrency() {
		return currency;
	}
	public void setCurrency(CurrencyEnum currency) {
		this.currency = currency;
	}
	public String getCounterparty() {
		return counterparty;
	}
	public void setCounterparty(String counterparty) {
		this.counterparty = counterparty;
	}
	
	
}
