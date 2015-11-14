package com.payxglobe.ripple.dto;

public class RipplePaymentPathResponseDto {

	private boolean success;
	private RipplePaymentDto[] payments;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public RipplePaymentDto[] getPayments() {
		return payments;
	}
	public void setPayments(RipplePaymentDto[] payments) {
		this.payments = payments;
	}
	
	
}
