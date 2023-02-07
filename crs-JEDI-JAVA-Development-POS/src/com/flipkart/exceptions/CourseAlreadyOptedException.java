/**
 * 
 */
package com.crs.flipkart.exceptions;

/**
 * @author adity
 *
 */
public class CourseAlreadyOptedException extends Exception{
	private String courseId;

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
		return  "Course " + courseId + " has already been opted by you!";
	}
}
