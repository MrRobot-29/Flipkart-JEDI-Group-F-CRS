/**
 * 
 */
package com.flipkart.exception;

import com.flipkart.constant.Color;

/**
 * @author jasan
 *
 */
public class CourseNotOptedException extends Exception{

	private String courseId;

	/**
	 * Constructor
	 * @param courseId
	 */
	public CourseNotOptedException(String courseId)
	{	
		this.courseId = courseId;
	}


	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return  Color.ANSI_YELLOW+"Course " + courseId + " has not been opted by you."+Color.ANSI_RESET;
	}
}
