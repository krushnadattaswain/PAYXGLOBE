package com.payxglobe.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.payxglobe.cache.PayeeCache;
import com.payxglobe.dto.PayeeDto;
import com.payxglobe.service.PayeeService;

@Component
public class PayeeServiceImpl implements PayeeService {

	@Override
	public List<PayeeDto> getPayeeList() {
		return PayeeCache.getPayeeList();
	}

}
