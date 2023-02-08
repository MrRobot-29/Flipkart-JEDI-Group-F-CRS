/**
 * 
 */
package com.flipkart.exception;

import com.flipkart.constant.Color;

/**
 * @author adity
 *
 */
public class CourseCountExceededException extends Exception{
	private String type;

	/**
	 * Constructor
	 * @param num number of courses
 	 */
	public CourseCountExceededException(String type )
	{	
		this.type = type;
	}


	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() 
	{
		return Color.ANSI_YELLOW+"You have already opted for " + type + " courses"+Color.ANSI_RESET;
	}
}
