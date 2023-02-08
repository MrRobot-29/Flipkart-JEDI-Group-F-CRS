package com.flipkart.exception;

public class PaymentNotCompletedException extends Exception {

	
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Payment not Successful";
	}
}
