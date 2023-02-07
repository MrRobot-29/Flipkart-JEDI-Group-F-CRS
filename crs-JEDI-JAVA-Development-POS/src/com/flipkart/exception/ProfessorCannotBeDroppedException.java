package com.flipkart.exception;

public class ProfessorCannotBeDroppedException extends Exception{
	private static final long serialVersionUID = 1L;
	private int profId;
		
		
		/***
		 * Setter function for EmailId
		 * @param emailId
		 */
		
		public ProfessorCannotBeDroppedException(int id) {
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
			return "Professor ID: " + profId + " can not be dropped";
		}
}
