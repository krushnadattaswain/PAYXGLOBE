package com.payxglobe.ripple;

import static com.payxglobe.constants.Constant.PAYXGLOBE_CNY_RIPPLE_ACC;
import static com.payxglobe.constants.Constant.PAYXGLOBE_USD_RIPPLE_ACC;
import static com.payxglobe.enums.CurrencyEnum.CNY;
import static com.payxglobe.enums.CurrencyEnum.USD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.payxglobe.cache.GateWay;
import com.payxglobe.cache.GatewayCache;
import com.payxglobe.enums.CurrencyEnum;

@Component
public class RippleBalanceCacheForNonXRP {


	
	private Map<String, List<RippleNonXRPBalance>> cache = new HashMap<String, List<RippleNonXRPBalance>>();
	
	private static final String USD_ACC_KEY = USD+PAYXGLOBE_USD_RIPPLE_ACC;
	private static final String CNY_ACC_KEY = CNY+PAYXGLOBE_CNY_RIPPLE_ACC;
	
	public RippleBalanceCacheForNonXRP(){
		init();
	}
	
	public void init(){
		issueNonXRP(PAYXGLOBE_USD_RIPPLE_ACC, USD, 10000.0);
		issueNonXRP(PAYXGLOBE_CNY_RIPPLE_ACC, CNY, 10000.0);
	}
	
	private void issueNonXRP(String rippleAddress, CurrencyEnum curr, Double amt){
		GateWay gateWay = GatewayCache.getGetWay(curr);
		RippleNonXRPBalance balance = new RippleNonXRPBalance(curr, amt, gateWay);
		
		List<RippleNonXRPBalance> currBalList = cache.get(rippleAddress);
		if(currBalList == null){
			currBalList = new ArrayList<RippleNonXRPBalance>();
			cache.put(rippleAddress, currBalList);
		}
		currBalList.add(balance);
	}
	
	public List<RippleNonXRPBalance> getBalance(String rippleAddress){
		return cache.get(rippleAddress);
	}
	public void addBalance(String rippleAddress, CurrencyEnum currency, double amt){
		List<RippleNonXRPBalance> currBalList = cache.get(rippleAddress);
		
		for(RippleNonXRPBalance currBal :currBalList){
			if(currency.equals(currBal.getCurrency())){
				currBal.setBal(currBal.getBal() + amt);
			}
		}
	}
	
	 
	
}
