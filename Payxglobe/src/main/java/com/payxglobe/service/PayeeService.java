package com.payxglobe.service;

import java.util.List;

import com.payxglobe.dto.FXRateDto;
import com.payxglobe.dto.FXRateResultDto;
import com.payxglobe.dto.PayeeDto;

public interface PayeeService {

	public List<PayeeDto> getPayeeList();
}
