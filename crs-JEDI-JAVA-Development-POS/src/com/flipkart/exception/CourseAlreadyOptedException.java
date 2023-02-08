/**
 * 
 */
package com.flipkart.exception;

import com.flipkart.constant.Color;

/**
 * @author adity
 *
 */
public class CourseAlreadyOptedException extends Exception{
	private String courseId;
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RESET = "\u001B[0m";

	/**
	 * Constructor
	 * @param courseId
	 */
	public CourseAlreadyOptedException(String courseId)
	{	
		this.courseId = courseId;
	}


	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return  Color.ANSI_YELLOW+"Course " + courseId + " has already been opted by you!"+Color.ANSI_RESET;
	}
}
