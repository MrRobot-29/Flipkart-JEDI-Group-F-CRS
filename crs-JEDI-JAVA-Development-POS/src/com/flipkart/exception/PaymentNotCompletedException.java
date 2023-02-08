package com.flipkart.exception;

import com.flipkart.constant.Color;

public class PaymentNotCompletedException extends Exception {

	
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return Color.ANSI_YELLOW+"Payment not Successful"+Color.ANSI_RESET;
	}
}
