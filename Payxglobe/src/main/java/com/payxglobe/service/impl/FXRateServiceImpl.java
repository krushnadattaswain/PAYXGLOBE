package com.payxglobe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.payxglobe.dto.FXBrokerRateDto;
import com.payxglobe.dto.FXRateDto;
import com.payxglobe.dto.FXRateResultDto;
import com.payxglobe.service.FXRateService;
import com.payxglobe.service.RippleService;
import com.payxglobe.util.NumberUtil;

@Component
public class FXRateServiceImpl implements FXRateService {

	@Autowired
	private RippleService rippleService;
	
	@Override
	public FXRateResultDto getFxRateWithBrokerComparison(FXRateDto fxRateDto) {
		Double rippleFxRate = getFxRate(fxRateDto);
		String amount =  fxRateDto.getAmt();
		Double amt = (amount == null || amount.isEmpty()) ? 1.0 : Double.parseDouble(fxRateDto.getAmt());
		FXRateResultDto result = new FXRateResultDto();
		result.setForm(fxRateDto.getFrom());
		result.setTo(fxRateDto.getTo());
		result.setOurRate(NumberUtil.formatNumberTwoDecimalPlaces(rippleFxRate));
		
		FXBrokerRateDto brkr1 = new FXBrokerRateDto();
		double brkr1rate = 6.21;
		brkr1.setRate(NumberUtil.formatNumberTwoDecimalPlaces(brkr1rate));
		brkr1.setName("WU");
		brkr1.setDifference(NumberUtil.formatNumberTwoDecimalPlaces(amt * (rippleFxRate - brkr1rate)));
		
		FXBrokerRateDto brkr2 = new FXBrokerRateDto();
		double brkr2rate = 6.11;
		brkr2.setRate(NumberUtil.formatNumberTwoDecimalPlaces(brkr2rate));
		brkr2.setName("ABC");
		brkr2.setDifference(NumberUtil.formatNumberTwoDecimalPlaces(amt * (rippleFxRate - brkr2rate)));
		
		List<FXBrokerRateDto> brkrs = new ArrayList<FXBrokerRateDto>();
		brkrs.add(brkr1);
		brkrs.add(brkr2);
		
		result.setFxBrokerrates(brkrs);
		return result;
	}

	@Override
	public Double getFxRate(FXRateDto fxRateDto) {
		
		return rippleService.getFXRateFromRipple(fxRateDto.getFrom(), fxRateDto.getTo());
	}

}
