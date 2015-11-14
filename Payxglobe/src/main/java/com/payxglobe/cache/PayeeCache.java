package com.payxglobe.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.payxglobe.dto.PayeeDto;

public class PayeeCache {

	private static Map<String, PayeeDto> cache = new HashMap<String, PayeeDto>();
	
	static{
		String address1 = "A-1809, Tata Apt.: Nanshan, Shenzhen : China";		
		String address2 = "A-1809, Tata Apt.: Nanshan, Shenzhen : China";
		cache.put("0023618364", createPayee("Tanmoy Ghosh", "0023618364", "CNY", "CMB","CMBCCNBS050","13164795088",address1));
		cache.put("0023623928", createPayee("Rahul Mujnani", "0023623928", "CNY", "CMB","CMBCCNBS050","1316479459",address2));
	}
	
	public static List<PayeeDto> getPayeeList(){
		return new ArrayList<PayeeDto>(cache.values());
	}
	
	
	private static PayeeDto createPayee(String name, String acc, String curr, String bank,
			String iban, String mob, String address) {
		PayeeDto payee = new PayeeDto();
		payee.setName(name);
		payee.setAcc(acc);
		payee.setCurr(curr);
		payee.setBank(bank);
		payee.setBic(iban);
		payee.setMob(mob);
		payee.setAddress(address);
		
		return payee;
	}
}
