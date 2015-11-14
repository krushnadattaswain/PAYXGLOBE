package com.payxglobe.ripple.dto;

public class RippleFXRateResultDto {

	private RippleCurrencyDto base;
	private RippleCurrencyDto counter;
	private Double rate;
	private Double last;
	public RippleCurrencyDto getBase() {
		return base;
	}
	public void setBase(RippleCurrencyDto base) {
		this.base = base;
	}
	public RippleCurrencyDto getCounter() {
		return counter;
	}
	public void setCounter(RippleCurrencyDto counter) {
		this.counter = counter;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Double getLast() {
		return last;
	}
	public void setLast(Double last) {
		this.last = last;
	}
	
	
}
