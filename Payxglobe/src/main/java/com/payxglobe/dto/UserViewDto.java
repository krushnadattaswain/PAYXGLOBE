package com.payxglobe.dto;

import java.util.List;

public class UserViewDto {

	private List<SpotRateDto> spotRates;
	private List<PayeeDto> payeeList;
	
	public List<SpotRateDto> getSpotRates() {
		return spotRates;
	}
	public void setSpotRates(List<SpotRateDto> spotRates) {
		this.spotRates = spotRates;
	}
	public List<PayeeDto> getPayeeList() {
		return payeeList;
	}
	public void setPayeeList(List<PayeeDto> payeeList) {
		this.payeeList = payeeList;
	}
	
	
}
