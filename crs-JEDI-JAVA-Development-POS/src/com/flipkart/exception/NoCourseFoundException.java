package com.flipkart.exception;

public class NoCourseFoundException extends Exception{

	@Override
	public String getMessage() {
		return "No Courses Found";
	}
}
