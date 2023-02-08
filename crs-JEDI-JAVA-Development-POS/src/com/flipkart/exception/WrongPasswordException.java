package com.flipkart.exception;

import com.flipkart.constant.Color;

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
		return Color.ANSI_YELLOW+"Wrong password for user with userId: " + userId +Color.ANSI_RESET;
	}

}
