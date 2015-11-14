package com.payxglobe.dto;

import java.util.List;

public class FXRateResultDto {

	private String form;
	private String to;
	private String ourRate;
	
	private List<FXBrokerRateDto> fxBrokerrates;

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
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
