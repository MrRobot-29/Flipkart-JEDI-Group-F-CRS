package com.flipkart.exception;

public class WrongPasswordException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String userId;

	/***
	 * Setter function for UserId
	 * @param userId
	 */
	public WrongPasswordException(String id) {
		userId = id;
	}

	/**
	 * Message thrown by exception
	 */
	@Override
	public String getMessage() {
		return "Wrong password for user with userId: " + userId;
	}

}
