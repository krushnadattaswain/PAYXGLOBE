package com.payxglobe.ripple.dto;

public class RippleCurrencyPairDto {

	private RippleCurrencyDto base;
	private RippleCurrencyDto counter;
	
	public RippleCurrencyPairDto(){
		
	}
	
	public RippleCurrencyPairDto(RippleCurrencyDto base,
			RippleCurrencyDto counter) {
		this.base = base;
		this.counter = counter;
	}
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
	
	
}
