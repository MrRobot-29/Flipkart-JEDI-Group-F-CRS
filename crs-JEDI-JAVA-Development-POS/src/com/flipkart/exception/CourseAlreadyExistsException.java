/**
 * 
 */
package com.flipkart.exception;


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
			return "Course: " + courseId + " already exists in catalog.";
		}
}
