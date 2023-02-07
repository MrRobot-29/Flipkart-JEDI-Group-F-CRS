package com.flipkart.exception;

public class NoProfessorFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "No professor Found";
	}
}
