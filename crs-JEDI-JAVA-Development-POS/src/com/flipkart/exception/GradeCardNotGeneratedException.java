/**
 * 
 */
package com.flipkart.exception;

/**
 * @author adity
 *
 */
public class GradeCardNotGeneratedException extends Exception{
	


	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return  "Grade card not generated";
	}
}
