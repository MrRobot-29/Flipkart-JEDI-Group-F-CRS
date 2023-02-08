/**
 * 
 */
package com.flipkart.exception;

import com.flipkart.constant.Color;

/**
 * @author adity
 *
 */
public class UserNotFoundException extends Exception{
	
	private String userId;

	/***
	 * Setter function for UserId
	 * @param userId
	 */
	public UserNotFoundException(String id) {
		userId = id;
	}

	/**
	 * Message thrown by exception
	 */
	
	public String getMessage() {
		return Color.ANSI_YELLOW+"User with userId: " + userId + " not found."+Color.ANSI_RESET;
	}
}
