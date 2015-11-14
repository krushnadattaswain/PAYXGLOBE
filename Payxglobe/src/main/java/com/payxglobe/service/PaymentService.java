package com.payxglobe.service;

import com.payxglobe.dto.PaymentDto;
import com.payxglobe.dto.TxnStatusDto;

public interface PaymentService {

	public TxnStatusDto pay(PaymentDto paymentDto);
}
