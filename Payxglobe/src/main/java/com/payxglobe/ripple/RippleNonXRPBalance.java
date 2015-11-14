package com.payxglobe.ripple;

import com.payxglobe.cache.GateWay;
import com.payxglobe.enums.CurrencyEnum;

public class RippleNonXRPBalance {

	private CurrencyEnum currency;
	private Double bal;
	private GateWay gateWay;
	
	public RippleNonXRPBalance(CurrencyEnum currency, Double bal, GateWay gateWay) {
		this.currency = currency;
		this.bal = bal;
		this.gateWay = gateWay;
	}
	public Double getBal() {
		return bal;
	}
	public void setBal(Double bal) {
		this.bal = bal;
	}
	public GateWay getGateWay() {
		return gateWay;
	}
	public void setGateWay(GateWay gateWay) {
		this.gateWay = gateWay;
	}
	public CurrencyEnum getCurrency() {
		return currency;
	}
	public void setCurrency(CurrencyEnum currency) {
		this.currency = currency;
	}
	
	
}
