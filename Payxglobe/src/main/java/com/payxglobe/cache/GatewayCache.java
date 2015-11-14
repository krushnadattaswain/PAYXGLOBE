package com.payxglobe.cache;

import static com.payxglobe.constants.Constant.GATEWAY_BITSTAMP;
import static com.payxglobe.constants.Constant.GATEWAY_BITSTAMP_ADDRESS;
import static com.payxglobe.constants.Constant.GATEWAY_RIPPLEFOX;
import static com.payxglobe.constants.Constant.GATEWAY_RIPPLEFOX_ADDRESS;
import static com.payxglobe.enums.CurrencyEnum.CNY;
import static com.payxglobe.enums.CurrencyEnum.USD;

import java.util.HashMap;
import java.util.Map;

import com.payxglobe.enums.CurrencyEnum;

public class GatewayCache {

	
	private static Map<CurrencyEnum, GateWay> gatewayCache = new HashMap<CurrencyEnum, GateWay>();
	
	static{
		gatewayCache.put(USD, new GateWay(GATEWAY_BITSTAMP, GATEWAY_BITSTAMP_ADDRESS));
		gatewayCache.put(CNY, new GateWay(GATEWAY_RIPPLEFOX, GATEWAY_RIPPLEFOX_ADDRESS));
	}
	
	public static GateWay getGetWay(CurrencyEnum currency){
		return gatewayCache.get(currency);
	}
}
