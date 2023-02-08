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
	private int num;

	/**
	 * Constructor
	 * @param num number of courses
 	 */
	public CourseCountExceededException(int num )
	{	
		this.num = num;
	}


	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() 
	{
		return Color.ANSI_YELLOW+"You have already opted for " + num + " courses"+Color.ANSI_RESET;
	}
}
