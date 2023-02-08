package com.flipkart.exception;

import com.flipkart.constant.Color;

public class NoProfessorFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return Color.ANSI_YELLOW+"No professor Found"+Color.ANSI_RESET;
	}
}
