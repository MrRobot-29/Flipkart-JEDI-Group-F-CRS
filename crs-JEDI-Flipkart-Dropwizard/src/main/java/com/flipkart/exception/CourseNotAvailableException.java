/**
 * 
 */
package com.flipkart.exception;

import com.flipkart.constant.Color;

/**
 * @author adity
 *
 */
public class CourseNotAvailableException extends Exception{
	private String courseId;

	/**
	 * Constructor
	 * @param courseId
	 */
	public CourseNotAvailableException(String courseId)
	{	
		this.courseId = courseId;
	}


	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return  Color.ANSI_YELLOW+"Course " + courseId + " has already been assigned to some other professor!"+Color.ANSI_RESET;
	}
}
