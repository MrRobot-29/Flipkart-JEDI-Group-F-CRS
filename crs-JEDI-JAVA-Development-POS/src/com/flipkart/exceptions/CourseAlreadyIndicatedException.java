/**
 * 
 */
package com.crs.flipkart.exceptions;

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
		return  "You already teach the course : " + courseId;
	}

}
