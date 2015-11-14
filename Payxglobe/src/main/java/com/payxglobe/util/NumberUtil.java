package com.payxglobe.util;

import java.text.DecimalFormat;

public class NumberUtil {

	public static String formatNumberTwoDecimalPlaces(Double num){
		if (num == null) return "0.00";
		DecimalFormat df = new DecimalFormat("#.00"); 
		return df.format(num);
	}
}
