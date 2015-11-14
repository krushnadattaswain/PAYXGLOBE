package com.payxglobe.ripple.dto;

import java.util.List;

public class RippleFXRateReqDto {

	private String range;
	private List<RippleCurrencyPairDto> pairs;

	public List<RippleCurrencyPairDto> getPairs() {
		return pairs;
	}

	public void setPairs(List<RippleCurrencyPairDto> pairs) {
		this.pairs = pairs;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}
	
	
}
