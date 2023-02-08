package com.flipkart.exception;

import com.flipkart.constant.Color;

public class NoStudentFoundException extends Exception{

	
	@Override
	public String getMessage() {
		return Color.ANSI_YELLOW+"No student found"+Color.ANSI_RESET;
	}
	
}
