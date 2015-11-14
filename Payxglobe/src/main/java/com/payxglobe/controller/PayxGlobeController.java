package com.payxglobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payxglobe.dto.FXRateDto;
import com.payxglobe.dto.FXRateResultDto;
import com.payxglobe.service.FXRateService;

@Configuration
@RestController
public class PayxGlobeController {

	@Autowired
	private FXRateService fxRateService;

	@RequestMapping(value = "/getFXRate", method = RequestMethod.POST)
	private FXRateResultDto getFXRate(@RequestBody FXRateDto fxRateDto) {
		return fxRateService.getFxRate(fxRateDto);
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	private FXRateResultDto test() {
		return fxRateService.getFxRate(null);
	}
	
	

}
