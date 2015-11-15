package com.payxglobe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.payxglobe.cache.FXBrokerRate;
import com.payxglobe.cache.FxBrokerRateCache;
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
		
		List<FXBrokerRateDto> brkrRates = new ArrayList<FXBrokerRateDto>();
		result.setFxBrokerrates(brkrRates);
		String currPair = fxRateDto.getFrom() + ":" + fxRateDto.getTo();
		FXBrokerRateDto currFxBrokerRateDto = null;
		
		List<FXBrokerRate> fxBrokerRateList = FxBrokerRateCache.getBrokerrates(currPair);
		
		if(fxBrokerRateList == null || fxBrokerRateList.isEmpty()) return result;
		
		for(FXBrokerRate fxBrokerRate : fxBrokerRateList){
			currFxBrokerRateDto = new FXBrokerRateDto();
			currFxBrokerRateDto.setRate(NumberUtil.formatNumberTwoDecimalPlaces(fxBrokerRate.getRate()));
			currFxBrokerRateDto.setName(fxBrokerRate.getName());
			currFxBrokerRateDto.setDifference(NumberUtil.formatNumberTwoDecimalPlaces(amt * (rippleFxRate - fxBrokerRate.getRate())));
			brkrRates.add(currFxBrokerRateDto);
		}
		
		
		return result;
	}

	@Override
	public Double getFxRate(FXRateDto fxRateDto) {		
		return rippleService.getFXRateFromRipple(fxRateDto.getFrom(), fxRateDto.getTo());
	}

}
