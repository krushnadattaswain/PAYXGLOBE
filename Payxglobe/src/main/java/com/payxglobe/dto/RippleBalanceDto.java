package com.payxglobe.dto;

import java.util.List;

public class RippleBalanceDto {

	private List<RippleCurrencyBalanceDto> currBalances;

	public List<RippleCurrencyBalanceDto> getCurrBalances() {
		return currBalances;
	}

	public void setCurrBalances(List<RippleCurrencyBalanceDto> currBalances) {
		this.currBalances = currBalances;
	}
	
	
}
