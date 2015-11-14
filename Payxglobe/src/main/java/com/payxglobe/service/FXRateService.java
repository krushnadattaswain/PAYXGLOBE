package com.payxglobe.service;

import com.payxglobe.dto.FXRateDto;
import com.payxglobe.dto.FXRateResultDto;

public interface FXRateService {

	public FXRateResultDto getFxRateWithBrokerComparison(FXRateDto fxRateDto);
	public Double getFxRate(FXRateDto fxRateDto);
}
