package com.payxglobe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payxglobe.dto.FXRateDto;
import com.payxglobe.dto.FXRateResultDto;
import com.payxglobe.dto.PayeeDto;
import com.payxglobe.dto.RippleBalanceDto;
import com.payxglobe.dto.SpotRateDto;
import com.payxglobe.dto.SpotRatesDto;
import com.payxglobe.dto.UserViewDto;
import com.payxglobe.service.FXRateService;
import com.payxglobe.service.PayeeService;
import com.payxglobe.service.RippleService;

@Configuration
@RestController
public class PayxGlobeController {

	@Autowired
	private FXRateService fxRateService;
	
	@Autowired
	private RippleService rippleService;
	
	@Autowired
	private PayeeService payeeService;

	@RequestMapping(value = "/getFXRate", method = RequestMethod.POST)
	private FXRateResultDto getFXRate(@RequestBody FXRateDto fxRateDto, @RequestParam String ts) {
		return fxRateService.getFxRate(fxRateDto);
	}
	
	@RequestMapping(value = "/getPayeeList", method = RequestMethod.GET)
	private UserViewDto getPayeeList( @RequestParam String ts) {
		UserViewDto userViewDto = new UserViewDto();
		userViewDto.setPayeeList(payeeService.getPayeeList());
		
		List<SpotRateDto> spotRates = new ArrayList<SpotRateDto>();
		spotRates.add(new SpotRateDto("USD:CNY", 6.53));
		spotRates.add(new SpotRateDto("CNY:USD", 1.53));
		
		userViewDto.setSpotRates(spotRates);
		
		
		return userViewDto;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	private FXRateResultDto test( @RequestParam String ts) {
		return fxRateService.getFxRate(null);
	}
	
	@RequestMapping(value = "/getAccBalance", method = RequestMethod.GET)
	private RippleBalanceDto accBal( @RequestParam String ts) {
		List<String> addresses = new ArrayList<String>();
		addresses.add("rhQPVGSTmkcNxvb1QeiCg6rHaFKewso9tN");
		addresses.add("snVEhnrw8UwCxp466Xv3jTfVqAFG8");
		return rippleService.getBalanceFromRipple(addresses);
	}
	
	

}
