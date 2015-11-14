package com.payxglobe.ripple.dto;

public class RipplePaymentDto {

	private String source_account;
	private String source_tag;
	private RippleAmountDto source_amount ;
	private String source_slippage ;
	private String destination_account;
	private String destination_tag;
	private RippleAmountDto destination_amount ;
	private String invoice_id;
	private String paths;
	private boolean partial_payment;
	private boolean no_direct_ripple;
	
	
	public String getSource_account() {
		return source_account;
	}
	public void setSource_account(String source_account) {
		this.source_account = source_account;
	}
	public String getSource_tag() {
		return source_tag;
	}
	public void setSource_tag(String source_tag) {
		this.source_tag = source_tag;
	}
	public RippleAmountDto getSource_amount() {
		return source_amount;
	}
	public void setSource_amount(RippleAmountDto source_amount) {
		this.source_amount = source_amount;
	}
	public String getSource_slippage() {
		return source_slippage;
	}
	public void setSource_slippage(String source_slippage) {
		this.source_slippage = source_slippage;
	}
	public String getDestination_account() {
		return destination_account;
	}
	public void setDestination_account(String destination_account) {
		this.destination_account = destination_account;
	}
	public String getDestination_tag() {
		return destination_tag;
	}
	public void setDestination_tag(String destination_tag) {
		this.destination_tag = destination_tag;
	}
	public RippleAmountDto getDestination_amount() {
		return destination_amount;
	}
	public void setDestination_amount(RippleAmountDto destination_amount) {
		this.destination_amount = destination_amount;
	}
	public String getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(String invoice_id) {
		this.invoice_id = invoice_id;
	}
	public String getPaths() {
		return paths;
	}
	public void setPaths(String paths) {
		this.paths = paths;
	}
	public boolean isPartial_payment() {
		return partial_payment;
	}
	public void setPartial_payment(boolean partial_payment) {
		this.partial_payment = partial_payment;
	}
	public boolean isNo_direct_ripple() {
		return no_direct_ripple;
	}
	public void setNo_direct_ripple(boolean no_direct_ripple) {
		this.no_direct_ripple = no_direct_ripple;
	}

	
}
