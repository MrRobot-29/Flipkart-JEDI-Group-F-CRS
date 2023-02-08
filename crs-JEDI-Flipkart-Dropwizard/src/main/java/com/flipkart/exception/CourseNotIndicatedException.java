/**
 * 
 */
package com.flipkart.exception;

import com.flipkart.constant.Color;

/**
 * @author adity
 *
 */
public class CourseNotIndicatedException extends Exception{
	private String courseId;

	/**
	 * Constructor
	 * @param courseId
	 */
	public CourseNotIndicatedException(String courseId)
	{	
		this.courseId = courseId;
	}


	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return  Color.ANSI_YELLOW+"You do not teach the course : " + courseId+Color.ANSI_RESET;
	}
}
