package com.flipkart.exception;

import com.flipkart.constant.Color;

public class UserAlreadyExistsException extends Exception{
	private String userId;

	public UserAlreadyExistsException(String id) {
		userId = id;
	}

	/**
	 * Message thrown by exception
	 */
	
	public String getMessage() {
		return Color.ANSI_YELLOW+"User with email: " + userId + " already present"+Color.ANSI_RESET;
	}

}
