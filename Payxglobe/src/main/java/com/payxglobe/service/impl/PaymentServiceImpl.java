package com.payxglobe.service.impl;

import org.springframework.stereotype.Component;

import com.payxglobe.dto.PaymentDto;
import com.payxglobe.dto.TxnStatusDto;
import com.payxglobe.service.PaymentService;

@Component
public class PaymentServiceImpl implements PaymentService {

	@Override
	public TxnStatusDto pay(PaymentDto paymentDto) {
		TxnStatusDto txnStatusDto = new TxnStatusDto();
		txnStatusDto.setStatus("success");
		return txnStatusDto;
	}

}
