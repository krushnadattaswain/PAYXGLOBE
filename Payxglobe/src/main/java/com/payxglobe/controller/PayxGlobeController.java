package com.payxglobe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payxglobe.cache.GatewayCache;
import com.payxglobe.constants.Constant;
import com.payxglobe.dto.FXRateDto;
import com.payxglobe.dto.FXRateResultDto;
import com.payxglobe.dto.PayeeDto;
import com.payxglobe.dto.PaymentDto;
import com.payxglobe.dto.RippleBalanceDto;
import com.payxglobe.dto.SpotRateDto;
import com.payxglobe.dto.SpotRatesDto;
import com.payxglobe.dto.TxnStatusDto;
import com.payxglobe.dto.UserViewDto;
import com.payxglobe.enums.CurrencyEnum;
import com.payxglobe.service.FXRateService;
import com.payxglobe.service.PayeeService;
import com.payxglobe.service.PaymentService;
import com.payxglobe.service.RippleService;
import com.payxglobe.util.NumberUtil;

import static com.payxglobe.enums.CurrencyEnum.*;

@Configuration
@RestController
public class PayxGlobeController {

	@Autowired
	private FXRateService fxRateService;
	
	@Autowired
	private RippleService rippleService;
	
	@Autowired
	private PayeeService payeeService;
	
	@Autowired
	PaymentService paymentService;

	@RequestMapping(value = "/getFXRate", method = RequestMethod.POST)
	private FXRateResultDto getFXRate(@RequestBody FXRateDto fxRateDto, @RequestParam String ts) {
		return fxRateService.getFxRateWithBrokerComparison(fxRateDto);
	}
	
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	private TxnStatusDto pay(@RequestBody PaymentDto paymentDto, @RequestParam String ts) {
		return paymentService.pay(paymentDto);
	}
	
	@RequestMapping(value = "/getPayeeList", method = RequestMethod.GET)
	private UserViewDto getPayeeList( @RequestParam String ts) {
		UserViewDto userViewDto = new UserViewDto();
		userViewDto.setPayeeList(payeeService.getPayeeList());
		
		
		List<SpotRateDto> spotRates = new ArrayList<SpotRateDto>();
		spotRates.add(new SpotRateDto("USD:CNY", NumberUtil.formatNumberTwoDecimalPlaces(rippleService.getFXRateFromRipple(USD, CNY))));
		spotRates.add(new SpotRateDto("CNY:USD", NumberUtil.formatNumberTwoDecimalPlaces(rippleService.getFXRateFromRipple(CNY, USD))));
		
		userViewDto.setSpotRates(spotRates);
		
		
		return userViewDto;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	private double test( @RequestParam String ts) {
		FXRateDto fxRateDto = new FXRateDto();
		fxRateDto.setFrom(CurrencyEnum.USD);
		fxRateDto.setTo(CurrencyEnum.CNY);
		return fxRateService.getFxRate(fxRateDto);
	}
	
	@RequestMapping(value = "/getAccBalance", method = RequestMethod.GET)
	private RippleBalanceDto accBal( @RequestParam String ts) {
		List<String> addresses = new ArrayList<String>();
		addresses.add(Constant.PAYXGLOBE_USD_RIPPLE_ACC);
		addresses.add(Constant.PAYXGLOBE_CNY_RIPPLE_ACC);
		return rippleService.getBalanceFromRipple(addresses);
	}
	
	

}
