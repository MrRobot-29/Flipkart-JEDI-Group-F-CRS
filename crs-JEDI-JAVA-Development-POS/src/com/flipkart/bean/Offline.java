package com.flipkart.bean;

public class Offline extends Payment{
	
	

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
