package com.payxglobe.cache;

import java.util.HashMap;
import java.util.Map;
import static com.payxglobe.enums.CurrencyEnum.*;

import org.springframework.stereotype.Component;

import com.payxglobe.enums.CurrencyEnum;

@Component
public class GatewayCache {

	private Map<CurrencyEnum, GateWay> gatewayCache = new HashMap<CurrencyEnum, GateWay>();
	
	public GatewayCache(){
		init();
	}
	
	public void init(){
		gatewayCache.put(USD, new GateWay());
	}
}
