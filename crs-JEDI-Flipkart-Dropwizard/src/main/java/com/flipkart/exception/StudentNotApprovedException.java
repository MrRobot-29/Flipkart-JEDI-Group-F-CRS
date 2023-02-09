/**
 * 
 */
package com.flipkart.exception;

import com.flipkart.constant.Color;

/**
 * @author adity
 *
 */
public class StudentNotApprovedException extends Exception{
private String studentId;
	
	public StudentNotApprovedException(String id) {
		studentId = id;
	}
	
	/**
	 * Getter function for studentId
	 * @return
	 */
	public String getStudentId() {
		return studentId;
	}
	

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return Color.ANSI_YELLOW+"StudentId: " + studentId + "has not been approved!"+Color.ANSI_RESET;
	}
}
