package com.payxglobe.cache;

public class FXBrokerRate {

	private String name;
	private double rate;
	private String currencyPair;
	
	
	public FXBrokerRate(String name, double rate, String currencyPair) {
		this.name = name;
		this.rate = rate;
		this.currencyPair = currencyPair;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getCurrencyPair() {
		return currencyPair;
	}
	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}
	
	
}
