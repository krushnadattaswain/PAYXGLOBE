package com.payxglobe.dto;

public class SpotRateDto {

	private String pair;
	private Double rate;
	
	public SpotRateDto() {
		
	}
	
	public SpotRateDto(String pair, Double rate) {
		this.pair = pair;
		this.rate = rate;
	}
	public String getPair() {
		return pair;
	}
	public void setPair(String pair) {
		this.pair = pair;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	
	
}
