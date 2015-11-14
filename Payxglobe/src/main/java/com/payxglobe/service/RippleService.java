package com.payxglobe.service;

import java.util.List;

import com.payxglobe.dto.RippleBalanceDto;

public interface RippleService {
	
	public RippleBalanceDto getBalanceFromRipple(List<String> rippleAddresses);
}
