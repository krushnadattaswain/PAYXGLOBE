package com.payxglobe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.payxglobe.dto.FXBrokerRateDto;
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
		FXBrokerRateDto brkr1 = new FXBrokerRateDto();
		brkr1.setRate("6.21");
		brkr1.setName("WU");
		brkr1.setDifference("0.3");
		
		FXBrokerRateDto brkr2 = new FXBrokerRateDto();
		brkr2.setRate("6.11");
		brkr2.setName("ABC");
		brkr2.setDifference("0.4");
		
		List<FXBrokerRateDto> brkrs = new ArrayList<FXBrokerRateDto>();
		brkrs.add(brkr1);
		
		result.setFxBrokerrates(brkrs);
		return result;
	}

}
