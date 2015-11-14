package com.payxglobe.cache;

import java.util.HashMap;
import java.util.Map;
import static com.payxglobe.constants.Constant.*;

public class RippleAccountCache {

	private static Map<String, RippleAccount> cache = new HashMap<String, RippleAccount>();
	
	static{
		cache.put(PAYXGLOBE_USD_RIPPLE_ACC, new RippleAccount(PAYXGLOBE_USD_RIPPLE_ACC, PAYXGLOBE_USD_RIPPLE_SECRET));
		cache.put(PAYXGLOBE_CNY_RIPPLE_ACC, new RippleAccount(PAYXGLOBE_CNY_RIPPLE_ACC, PAYXGLOBE_CNY_RIPPLE_SECRET));
	}
	
	public static RippleAccount getRippleAcc(String address){
		return cache.get(address);
	}
}
