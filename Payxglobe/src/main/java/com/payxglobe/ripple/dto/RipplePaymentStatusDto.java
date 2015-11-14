package com.payxglobe.ripple.dto;

public class RipplePaymentStatusDto {
	private boolean success;
	private String client_resource_id;
	private String status_url;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getClient_resource_id() {
		return client_resource_id;
	}
	public void setClient_resource_id(String client_resource_id) {
		this.client_resource_id = client_resource_id;
	}
	public String getStatus_url() {
		return status_url;
	}
	public void setStatus_url(String status_url) {
		this.status_url = status_url;
	}
	
	
}
