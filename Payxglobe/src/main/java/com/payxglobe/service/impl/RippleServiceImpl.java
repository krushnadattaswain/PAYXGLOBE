package com.payxglobe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.payxglobe.dto.CurrencyBalanceDTO;
import com.payxglobe.dto.RippleBalanceDto;
import com.payxglobe.dto.RippleCurrencyBalanceDto;
import com.payxglobe.service.RippleService;

@Component
public class RippleServiceImpl implements RippleService{
	
	

	public RippleBalanceDto getBalanceFromRipple(List<String> rippleAddresses){
		return getTestData(rippleAddresses);
	}
	
	private RippleBalanceDto getTestData(List<String> rippleAddresses){
		RippleBalanceDto rippleBalanceDto = new RippleBalanceDto();
		List<RippleCurrencyBalanceDto> rippleCurrBalances = new ArrayList<RippleCurrencyBalanceDto>();
		
		RippleCurrencyBalanceDto currBal = null;
		for(String rippleAddress : rippleAddresses){
			currBal = new RippleCurrencyBalanceDto();
			currBal.setRaddress(rippleAddress);
			currBal.setCurrBalances(getRippleBalance(rippleAddress));
			rippleCurrBalances.add(currBal);
		}
		
		rippleBalanceDto.setCurrBalances(rippleCurrBalances);
		return rippleBalanceDto;
	}
	
	private List<CurrencyBalanceDTO> getRippleBalance(String rippleAddresss){
		List<CurrencyBalanceDTO> bals = new ArrayList<CurrencyBalanceDTO>();
		
		CurrencyBalanceDTO bal1 = new CurrencyBalanceDTO();
		bal1.setGname("BITSTAMP");
		bal1.setGaddress("1234");
		bal1.setCurr("USD");
		bal1.setBal("10000");
		
		CurrencyBalanceDTO bal2 = new CurrencyBalanceDTO();
		bal2.setGname("RIPPLEFOX");
		bal2.setGaddress("1235");
		bal2.setCurr("CNY");
		bal2.setBal("10000");
		
		bals.add(bal1);
		bals.add(bal2);
		return bals;
	}
	
	
	
	private RippleBalanceDto getActualData(List<String> rippleAddresses){
		return null;
	}
}
