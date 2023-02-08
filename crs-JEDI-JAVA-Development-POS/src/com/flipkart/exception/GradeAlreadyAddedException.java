/**
 * 
 */
package com.flipkart.exception;

import com.flipkart.constant.Color;

/**
 * @author adity
 *
 */
public class GradeAlreadyAddedException extends Exception{
	private String courseId,studentId;

	/**
	 * Constructor
	 * @param courseId
	 * @param studentId
	 */
	public GradeAlreadyAddedException(String courseId, String studentId)
	{	
		this.courseId = courseId;
		this.studentId = studentId;
	}


	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return  Color.ANSI_YELLOW+"Student " + studentId + " has already been graded for course : " + courseId+Color.ANSI_RESET;
	}
}
