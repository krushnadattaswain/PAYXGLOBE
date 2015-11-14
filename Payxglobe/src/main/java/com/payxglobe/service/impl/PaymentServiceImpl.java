package com.payxglobe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.payxglobe.constants.Constant;
import com.payxglobe.dto.PaymentDto;
import com.payxglobe.dto.TxnStatusDto;
import com.payxglobe.enums.CurrencyEnum;
import com.payxglobe.ripple.RippleBalanceCacheForNonXRP;
import com.payxglobe.service.PaymentService;
import com.payxglobe.service.RippleService;

@Component
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private RippleBalanceCacheForNonXRP rippleBalanceCacheForNonXRP;
	
	@Autowired
	private RippleService rippleService;
	
	
	
	@Override
	public TxnStatusDto pay(PaymentDto paymentDto) {
		
		double fxrate = rippleService.getFXRateFromRipple(paymentDto.getFromCurr(), paymentDto.getToCurr());
		
		CurrencyEnum sourceCurrency = paymentDto.getFromCurr();
		rippleBalanceCacheForNonXRP.addBalance(getRippleAddress(sourceCurrency), sourceCurrency, -paymentDto.getAmt());
		
		CurrencyEnum destCurrency = paymentDto.getToCurr();
		rippleBalanceCacheForNonXRP.addBalance(getRippleAddress(destCurrency), destCurrency, (paymentDto.getAmt() * fxrate));
		
		return rippleService.makePayment(paymentDto);
	}
	
	private String getRippleAddress(CurrencyEnum curr){
		String result = null;
		switch (curr) {
		case USD:
			result = Constant.PAYXGLOBE_USD_RIPPLE_ACC;
			break;
		case CNY:
			result = Constant.PAYXGLOBE_CNY_RIPPLE_ACC;
			break;

		default:
			break;
		}
		return result;
	}

}
