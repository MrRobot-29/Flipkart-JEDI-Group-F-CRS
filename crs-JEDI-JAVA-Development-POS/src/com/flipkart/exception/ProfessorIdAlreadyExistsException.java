package com.flipkart.exception;

import com.flipkart.constant.Color;

public class ProfessorIdAlreadyExistsException extends Exception{
private static final long serialVersionUID = 1L;
private int profId;
	
	
	/***
	 * Setter function for EmailId
	 * @param emailId
	 */
	
	public ProfessorIdAlreadyExistsException(int id) {
		profId = id;
	}
	
	/***
	 * Getter function for EmailId
	 * @param emailId
	 */
	
	public int getProfId() {
		return profId;
	}
	
	
	@Override
	public String getMessage() {
		return Color.ANSI_YELLOW+"Professor ID: " + profId + " is already present"+Color.ANSI_RESET;

	}
}
