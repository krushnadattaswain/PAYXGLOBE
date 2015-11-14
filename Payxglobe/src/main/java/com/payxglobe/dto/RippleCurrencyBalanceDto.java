package com.payxglobe.dto;

import java.util.List;

public class RippleCurrencyBalanceDto {

	private String raddress;
	private List<CurrencyBalanceDTO> currBalances;
	
	public String getRaddress() {
		return raddress;
	}
	public void setRaddress(String raddress) {
		this.raddress = raddress;
	}
	public List<CurrencyBalanceDTO> getCurrBalances() {
		return currBalances;
	}
	public void setCurrBalances(List<CurrencyBalanceDTO> currBalances) {
		this.currBalances = currBalances;
	}
	
	
}
