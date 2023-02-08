/**
 * 
 */
package com.flipkart.exception;

import com.flipkart.constant.Color;

public class CourseAlreadyExistsException extends Exception{
	private String courseId;
		
		/***
		 * Constructor
		 * @param courseId
		 */
		public CourseAlreadyExistsException(String courseId) {
			this.courseId = courseId;
		}
		
	
		/**
		 * Getter method
		 * @return course id
		 */
		public String getCourseId() {
			return courseId;
		}
	
		/**
		 * Message returned when exception is thrown
		 */
		@Override
		public String getMessage() {
			return Color.ANSI_YELLOW+"Course: " + courseId + " already exists in catalog."+Color.ANSI_RESET;
		}
}
