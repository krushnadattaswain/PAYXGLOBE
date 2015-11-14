package com.payxglobe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.payxglobe.cache.GateWay;
import com.payxglobe.cache.GatewayCache;
import com.payxglobe.constants.Constant;
import com.payxglobe.dto.CurrencyBalanceDTO;
import com.payxglobe.dto.RippleBalanceDto;
import com.payxglobe.dto.RippleCurrencyBalanceDto;
import com.payxglobe.enums.CurrencyEnum;
import com.payxglobe.ripple.RippleBalanceCacheForNonXRP;
import com.payxglobe.ripple.RippleNonXRPBalance;
import com.payxglobe.ripple.dto.RippleBalanceQueryResultDto;
import com.payxglobe.ripple.dto.RippleCurrBalanceDto;
import com.payxglobe.ripple.dto.RippleCurrencyDto;
import com.payxglobe.ripple.dto.RippleCurrencyPairDto;
import com.payxglobe.ripple.dto.RippleFXRateReqDto;
import com.payxglobe.ripple.dto.RippleFXRateResultDto;
import com.payxglobe.service.RippleService;
import com.payxglobe.util.NumberUtil;

@Component
public class RippleServiceImpl implements RippleService{

	
	@Autowired
	private RippleBalanceCacheForNonXRP rippleBalanceCacheForNonXRP;

	public RippleBalanceDto getBalanceFromRipple(List<String> rippleAddresses){
		RippleBalanceDto rippleBalanceDto = new RippleBalanceDto();
		List<RippleCurrencyBalanceDto> rippleCurrBalances = new ArrayList<RippleCurrencyBalanceDto>();
		
		RippleCurrencyBalanceDto currBal = null;
		for(String rippleAddress : rippleAddresses){
			currBal = new RippleCurrencyBalanceDto();
			currBal.setRaddress(rippleAddress);
			currBal.setBalances(getRippleBalance(rippleAddress));
			rippleCurrBalances.add(currBal);
		}
		
		rippleBalanceDto.setCurrBalances(rippleCurrBalances);
		return rippleBalanceDto;
	}
	
	
	
	private List<CurrencyBalanceDTO> getRippleBalance(String rippleAddress){
		List<CurrencyBalanceDTO> bals = new ArrayList<CurrencyBalanceDTO>();
		
		List<RippleNonXRPBalance> nonXRPBalanceList = rippleBalanceCacheForNonXRP.getBalance(rippleAddress);
		for(RippleNonXRPBalance nonXRPBalance : nonXRPBalanceList){
			addToBal(nonXRPBalance, bals);
		}
		
		CurrencyBalanceDTO xrpBalance = new CurrencyBalanceDTO();
		xrpBalance.setCurr(CurrencyEnum.XRP.toString());
		xrpBalance.setBal(NumberUtil.formatNumberTwoDecimalPlaces(getXRPBalanceFromRipple(rippleAddress)));
		bals.add(xrpBalance);
		return bals;
	}
	
	private void addToBal(RippleNonXRPBalance nonXrpBal, List<CurrencyBalanceDTO> balsList){
		CurrencyBalanceDTO bal = new CurrencyBalanceDTO();
		GateWay gateWay = nonXrpBal.getGateWay();
		bal.setGname(gateWay.getName());
		bal.setGaddress(gateWay.getrAddress());
		bal.setCurr(nonXrpBal.getCurrency().toString());
		bal.setBal(NumberUtil.formatNumberTwoDecimalPlaces(nonXrpBal.getBal()));
		balsList.add(bal);
	}
	
	
	
	public Double getFXRateFromRipple(CurrencyEnum source, CurrencyEnum dest){
		GateWay sourceGateway = GatewayCache.getGetWay(source);
		GateWay destGateway = GatewayCache.getGetWay(dest);
		
		RippleCurrencyDto srcCurr = new RippleCurrencyDto(source.toString(), sourceGateway.getrAddress(), null);
		RippleCurrencyDto destCurr = new RippleCurrencyDto(dest.toString(), destGateway.getrAddress(), null);
		RippleCurrencyPairDto currPair = new RippleCurrencyPairDto(srcCurr, destCurr);
		List<RippleCurrencyPairDto> currPairs = new ArrayList<RippleCurrencyPairDto>();
		currPairs.add(currPair);
		
		RippleFXRateReqDto rippleFXRateReq = new RippleFXRateReqDto();
		rippleFXRateReq.setPairs(currPairs);
		rippleFXRateReq.setRange(Constant.RIPPLE_CHART_RANGE_DAY);
		
		RestTemplate restTemplate = new RestTemplate();
		RippleFXRateResultDto[] rippleFXRateResults = restTemplate.postForObject(Constant.RIPPLE_CHARTS_URI, rippleFXRateReq, RippleFXRateResultDto[].class);
		 
		//List<RippleFXRateResultDto> rippleFXRateResults = new ArrayList<RippleFXRateResultDto>();
		
		if(rippleFXRateResults == null || rippleFXRateResults.length == 0){
			throw new RuntimeException("Failed to get FX rate from Ripple ");
		}
		
		RippleFXRateResultDto rippleFXRateResult = rippleFXRateResults[0];
		return (rippleFXRateResult.getRate() == null ? rippleFXRateResult.getLast() : rippleFXRateResult.getRate());
	}
	
	private double getXRPBalanceFromRipple(String rippleAddress){
		RestTemplate restTemplate = new RestTemplate();
		RippleBalanceQueryResultDto balanceResult = restTemplate.getForObject(getRippleBalanceQueryUri(rippleAddress), RippleBalanceQueryResultDto.class);
		
		
		if(!balanceResult.isSuccess()){
			throw new RuntimeException("Failed to fetch balance from ripple");
		}
		
		RippleCurrBalanceDto[] balances = balanceResult.getBalances();
		if(balances == null || balances.length == 0){
			throw new RuntimeException("Failed to fetch balance from ripple");
		}
		
		for(RippleCurrBalanceDto balance : balances){
			if(CurrencyEnum.XRP.equals(balance.getCurrency())){
				return balance.getValue();
			}
		}
		return 0.0;
	}
	
	private String getRippleBalanceQueryUri(String rippleAddress){
		StringBuilder sb = new StringBuilder(Constant.RIPPLE_TEST_NET_URI);
		sb.append("v1/accounts/").append(rippleAddress).append("/balances");
		return sb.toString();
	}
	
	public static void main(String... args) {
		RippleServiceImpl service = new RippleServiceImpl();
		System.out.println(service.getFXRateFromRipple(CurrencyEnum.CNY, CurrencyEnum.USD));
		
		//System.out.println(service.getXRPBalanceFromRipple(Constant.PAYXGLOBE_CNY_RIPPLE_ACC));
	}
}
