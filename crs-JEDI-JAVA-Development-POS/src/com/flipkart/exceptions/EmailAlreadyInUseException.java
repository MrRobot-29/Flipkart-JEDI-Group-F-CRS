/**
 * 
 */
package com.crs.flipkart.exceptions;

/**
 * @author adity
 *
 */
public class EmailAlreadyInUseException extends Exception{
private String emailId;
	
	
	/***
	 * Setter function for EmailId
	 * @param emailId
	 */
	
	public EmailAlreadyInUseException(String id) {
		emailId = id;
	}
	
	/***
	 * Getter function for EmailId
	 * @param emailId
	 */
	
	public String getEmailId() {
		return emailId;
	}
	
	
	@Override
	public String getMessage() {
		return "EmailId: " + emailId + " is already in use.";
	}
}
