package com.payxglobe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.payxglobe.dto.PayeeDto;
import com.payxglobe.service.PayeeService;

@Component
public class PayeeServiceImpl implements PayeeService {

	@Override
	public List<PayeeDto> getPayeeList() {
		List<PayeeDto> payeeList = new ArrayList<PayeeDto>();
		String address1 = "A-1809, Tata Apt.: Nanshan, Shenzhen : China";
		payeeList.add(createPayee("Tanmoy Ghosh", "0023618364", "CNY", "CMB","CMBCCNBS050","13164795088",address1) );
		
		String address2 = "A-1809, Tata Apt.: Nanshan, Shenzhen : China";
		payeeList.add(createPayee("Rahul Mujnani", "0023623928", "CNY", "CMB","CMBCCNBS050","1316479459",address2) );
		return payeeList;
	}
	
	private PayeeDto createPayee(String name, String acc, String curr, String bank,
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
