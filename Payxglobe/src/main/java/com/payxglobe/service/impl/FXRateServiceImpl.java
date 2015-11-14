package com.payxglobe.service.impl;

import org.springframework.stereotype.Component;

import com.payxglobe.dto.FXRateDto;
import com.payxglobe.dto.FXRateResultDto;
import com.payxglobe.service.FXRateService;

@Component
public class FXRateServiceImpl implements FXRateService {

	@Override
	public FXRateResultDto getFxRate(FXRateDto fxRateDto) {
		FXRateResultDto result = new FXRateResultDto();
		result.setForm("USD");
		result.setTo("CNY");
		result.setOurRate("6.52");
		return result;
	}

}
