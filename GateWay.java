package com.payxglobe.cache;

public class GateWay {

	private String name;
	private String rAddress;
	
	
	
	public GateWay(String name, String rAddress) {
		super();
		this.name = name;
		this.rAddress = rAddress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getrAddress() {
		return rAddress;
	}
	public void setrAddress(String rAddress) {
		this.rAddress = rAddress;
	}
	
	
}
