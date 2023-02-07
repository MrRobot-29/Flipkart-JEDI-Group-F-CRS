package com.flipkart.exception;

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
		return "Student with studentID: " + studentId + " not found.";
	}
}
