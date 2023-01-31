package com.flipkart.bean;

public class Online extends Payment{
	
	private String bankName;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String getReferenceID() {
		// TODO Auto-generated method stub
		
		return this.referenceID;
	}

	@Override
	public void setReferenceID(String referenceID) {
		// TODO Auto-generated method stub
		this.referenceID = referenceID;
		
	}

	@Override
	public void setPaymentAmount(float amount) {
		// TODO Auto-generated method stub
		this.paymentAmount = amount;
		
	}

	@Override
	public void setStatus(boolean status) {
		// TODO Auto-generated method stub
		this.status = status;
		
	}

}
