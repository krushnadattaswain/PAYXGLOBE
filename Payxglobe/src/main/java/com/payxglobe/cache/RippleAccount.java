package com.payxglobe.cache;

public class RippleAccount {

	private String address;
	private String secret;
	
	
	public RippleAccount(String address, String secret) {
		this.address = address;
		this.secret = secret;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	
}
