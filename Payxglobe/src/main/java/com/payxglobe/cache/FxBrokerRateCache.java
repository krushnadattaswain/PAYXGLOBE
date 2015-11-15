package com.payxglobe.cache;

import static com.payxglobe.constants.Constant.CNY_USD_PAIR;
import static com.payxglobe.constants.Constant.USD_CNY_PAIR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FxBrokerRateCache {

	private static Map<String, List<FXBrokerRate>> cache = new HashMap<String, List<FXBrokerRate>>();
	
	static{
		
		addToCache(USD_CNY_PAIR, "Western Union", 6.24);
		addToCache(USD_CNY_PAIR, "Xoom", 6.27);
		//addToCache(CNY_USD_PAIR, "Exchange Rate", 0.156);
	}
	
	public static List<FXBrokerRate> getBrokerrates(String currPair){
		return cache.get(currPair);
	}
	
	private static void addToCache(String currPair, String brkrName, double rate){
		List<FXBrokerRate> brkrratesInCache = cache.get(currPair);
		if(brkrratesInCache == null){
			brkrratesInCache = new ArrayList<FXBrokerRate>();
			cache.put(currPair, brkrratesInCache);
		}
		brkrratesInCache.add(new FXBrokerRate(brkrName, rate, currPair));
	}
}
