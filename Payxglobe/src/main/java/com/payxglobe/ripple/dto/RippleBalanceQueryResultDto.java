package com.payxglobe.ripple.dto;

public class RippleBalanceQueryResultDto {

	private boolean success;
	private String ledger;
	private boolean validated;
	
	private RippleCurrBalanceDto[] balances;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getLedger() {
		return ledger;
	}

	public void setLedger(String ledger) {
		this.ledger = ledger;
	}

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	public RippleCurrBalanceDto[] getBalances() {
		return balances;
	}

	public void setBalances(RippleCurrBalanceDto[] balances) {
		this.balances = balances;
	}
	
	
	
	
}
