/**
 * 
 */
package com.crs.flipkart.exceptions;

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
		return  "You do not teach the course : " + courseId;
	}
}
