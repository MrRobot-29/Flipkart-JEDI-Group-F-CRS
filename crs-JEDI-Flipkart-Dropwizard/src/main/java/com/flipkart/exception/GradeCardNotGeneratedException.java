/**
 * 
 */
package com.flipkart.exception;

import com.flipkart.constant.Color;

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
		return  Color.ANSI_YELLOW+"Grade card not generated"+Color.ANSI_RESET;
	}
}
