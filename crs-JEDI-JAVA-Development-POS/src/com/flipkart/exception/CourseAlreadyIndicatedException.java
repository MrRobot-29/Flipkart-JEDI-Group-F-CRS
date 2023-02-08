/**
 * 
 */

package com.flipkart.exception;

import com.flipkart.constant.Color;

/**
 * @author jasan
 *
 */
public class CourseAlreadyIndicatedException extends Exception{
	
	private String courseId;

	/**
	 * Constructor
	 * @param courseId
	 */
	public CourseAlreadyIndicatedException(String courseId)
	{	
		this.courseId = courseId;
	}


	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return  Color.ANSI_YELLOW+"You already teach the course : " + Color.ANSI_RESET;
	}

}
