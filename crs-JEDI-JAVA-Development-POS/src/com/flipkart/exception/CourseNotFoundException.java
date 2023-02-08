/**
 * 
 */
package com.flipkart.exception;

import com.flipkart.constant.Color;

/**
 * @author adity
 *
 */
public class CourseNotFoundException extends Exception{
	private String courseId;

	/**
	 * Constructor
	 * @param courseId
	 */
	public CourseNotFoundException(String courseId)
	{	
		this.courseId = courseId;
	}


	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return Color.ANSI_YELLOW+"Course with course id: " + courseId + " not found."+Color.ANSI_RESET;
	}
}
