package com.payxglobe.dto;

import java.util.List;

public class RippleCurrencyBalanceDto {

	private String raddress;
	private List<CurrencyBalanceDTO> balances;
	
	public String getRaddress() {
		return raddress;
	}
	public void setRaddress(String raddress) {
		this.raddress = raddress;
	}
	public List<CurrencyBalanceDTO> getBalances() {
		return balances;
	}
	public void setBalances(List<CurrencyBalanceDTO> balances) {
		this.balances = balances;
	}
	
	
}
