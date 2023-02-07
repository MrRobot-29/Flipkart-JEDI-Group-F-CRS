package com.flipkart.exception;

public class NoStudentFoundException extends Exception{

	
	@Override
	public String getMessage() {
		return "No student found";
	}
	
}
