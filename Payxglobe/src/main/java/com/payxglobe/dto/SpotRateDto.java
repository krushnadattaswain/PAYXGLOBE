package com.payxglobe.dto;

public class SpotRateDto {

	private String pair;
	private String rate;
	
	public SpotRateDto() {
		
	}
	
	public SpotRateDto(String pair, String rate) {
		this.pair = pair;
		this.rate = rate;
	}
	public String getPair() {
		return pair;
	}
	public void setPair(String pair) {
		this.pair = pair;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	
}
