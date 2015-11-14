package com.payxglobe.dto;

import java.util.List;

import com.payxglobe.enums.CurrencyEnum;

public class FXRateResultDto {

	private CurrencyEnum form;
	private CurrencyEnum to;
	private String ourRate;
	
	private List<FXBrokerRateDto> fxBrokerrates;

	public CurrencyEnum getForm() {
		return form;
	}

	public void setForm(CurrencyEnum form) {
		this.form = form;
	}

	public CurrencyEnum getTo() {
		return to;
	}

	public void setTo(CurrencyEnum to) {
		this.to = to;
	}

	public String getOurRate() {
		return ourRate;
	}

	public void setOurRate(String ourRate) {
		this.ourRate = ourRate;
	}

	public List<FXBrokerRateDto> getFxBrokerrates() {
		return fxBrokerrates;
	}

	public void setFxBrokerrates(List<FXBrokerRateDto> fxBrokerrates) {
		this.fxBrokerrates = fxBrokerrates;
	}

	
	
}
