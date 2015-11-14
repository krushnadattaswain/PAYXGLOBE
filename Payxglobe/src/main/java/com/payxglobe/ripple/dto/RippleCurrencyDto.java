package com.payxglobe.ripple.dto;

public class RippleCurrencyDto {

	private String currency;
	private String issuer;
	private String name;
	
	public RippleCurrencyDto() {
		
	}
	
	public RippleCurrencyDto(String currency, String issuer, String name) {
		super();
		this.currency = currency;
		this.issuer = issuer;
		this.name = name;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
