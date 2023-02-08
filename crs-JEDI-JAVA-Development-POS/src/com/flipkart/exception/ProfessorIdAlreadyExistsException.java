package com.flipkart.exception;

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
		return "Professor ID: " + profId + " is already present";
	}
}
