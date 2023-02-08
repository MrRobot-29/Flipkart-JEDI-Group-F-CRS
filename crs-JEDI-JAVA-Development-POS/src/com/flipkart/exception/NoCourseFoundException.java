package com.flipkart.exception;

import com.flipkart.constant.Color;

public class NoCourseFoundException extends Exception{

	@Override
	public String getMessage() {
		return Color.ANSI_YELLOW+"No Courses Found"+Color.ANSI_RESET;
	}
}
