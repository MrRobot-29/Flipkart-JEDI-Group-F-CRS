/**
 * 
 */
package com.crs.flipkart.exceptions;

/**
 * @author adity
 *
 */
public class GradeCardNotGeneratedException extends Exception{
	private String studentId;

	/**
	 * Constructor
	 * @param studentId
	 */
	public GradeCardNotGeneratedException(String studentId)
	{	
		this.studentId = studentId;
	}


	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return  "Grade card not generated for student : " + studentId;
	}
}
