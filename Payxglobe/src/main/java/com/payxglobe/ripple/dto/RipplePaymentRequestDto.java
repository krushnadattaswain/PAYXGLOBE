package com.payxglobe.ripple.dto;

public class RipplePaymentRequestDto {

	private String secret;
	private String client_resource_id;
	private double max_fee;
	private double fixed_fee;
	private RipplePaymentDto payment;
	
	
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getClient_resource_id() {
		return client_resource_id;
	}
	public void setClient_resource_id(String client_resource_id) {
		this.client_resource_id = client_resource_id;
	}
	
	public RipplePaymentDto getPayment() {
		return payment;
	}
	public void setPayment(RipplePaymentDto payment) {
		this.payment = payment;
	}
	public double getMax_fee() {
		return max_fee;
	}
	public void setMax_fee(double max_fee) {
		this.max_fee = max_fee;
	}
	public double getFixed_fee() {
		return fixed_fee;
	}
	public void setFixed_fee(double fixed_fee) {
		this.fixed_fee = fixed_fee;
	}
	
}
