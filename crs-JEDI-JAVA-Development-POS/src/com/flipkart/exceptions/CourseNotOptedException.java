/**
 * 
 */
package com.crs.flipkart.exceptions;

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
		return  "Course " + courseId + " has not been opted by you.";
	}
}
