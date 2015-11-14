package com.payxglobe.cache;

public class GateWay {

	private String name;
	private String rAddress;
	private String ourRippleAddressLinked;
	
	
	
	public GateWay(String name, String rAddress, String ourRippleAddressLinked) {
		super();
		this.name = name;
		this.rAddress = rAddress;
		this.ourRippleAddressLinked = ourRippleAddressLinked;
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

	public String getOurRippleAddressLinked() {
		return ourRippleAddressLinked;
	}

	public void setOurRippleAddressLinked(String ourRippleAddressLinked) {
		this.ourRippleAddressLinked = ourRippleAddressLinked;
	}
	
	
}
