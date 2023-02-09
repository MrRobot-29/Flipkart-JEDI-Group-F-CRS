/**
 * 
 */
package com.flipkart.exception;

import com.flipkart.constant.Color;

/**
 * @author adity
 *
 */
public class GradeNotAllotedException extends Exception{
	private String studentId;
	 
	/**
	 * Constructor
	 * @param studentId
	 */
	 public GradeNotAllotedException(String studentId)
	 {
		 this.studentId=studentId;
	 }
	 
	 /**
	  * Getter function for studentId
	  * @return
	  */
	 public String getStudentId()
	 {
		 return studentId;
	 }
	 
	 /**
		 * Message returned when exception is thrown
	 */
	 
	 public String getMessage() 
	 {
			return Color.ANSI_YELLOW+"Student with id: " + studentId + " has not been alloted all the grades"+Color.ANSI_RESET;
	 }
}
