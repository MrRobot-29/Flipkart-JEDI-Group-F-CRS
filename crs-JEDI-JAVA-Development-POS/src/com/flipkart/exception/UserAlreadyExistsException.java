package com.flipkart.exception;

public class UserAlreadyExistsException extends Exception{
	private String userId;

	/***
	 * Setter function for UserId
	 * @param userId
	 */
	public UserAlreadyExistsException(String id) {
		userId = id;
	}

	/**
	 * Message thrown by exception
	 */
	
	public String getMessage() {
		return "User with email: " + userId + " already present";
	}
}
