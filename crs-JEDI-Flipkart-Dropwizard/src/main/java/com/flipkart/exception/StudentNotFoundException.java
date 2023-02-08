package com.flipkart.exception;

import com.flipkart.constant.Color;

public class StudentNotFoundException extends Exception{
	private int studentId;

	/***
	 * Setter function for UserId
	 * @param userId
	 */
	public StudentNotFoundException(int id) {
		studentId = id;
	}

	/**
	 * Message thrown by exception
	 */
	
	public String getMessage() {
		return Color.ANSI_YELLOW+"Student with studentID: " + studentId + " not found."+Color.ANSI_RESET;
	}
}
