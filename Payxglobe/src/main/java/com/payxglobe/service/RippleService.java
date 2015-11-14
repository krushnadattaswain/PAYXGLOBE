package com.payxglobe.service;

import java.util.List;

import com.payxglobe.dto.PaymentDto;
import com.payxglobe.dto.RippleBalanceDto;
import com.payxglobe.dto.TxnStatusDto;
import com.payxglobe.enums.CurrencyEnum;

public interface RippleService {
	
	public RippleBalanceDto getBalanceFromRipple(List<String> rippleAddresses);
	
	public Double getFXRateFromRipple(CurrencyEnum source, CurrencyEnum dest);
	
	public TxnStatusDto makePayment(PaymentDto paymentDto);
}
