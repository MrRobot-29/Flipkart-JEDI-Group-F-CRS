package com.flipkart.service;

import java.util.List;

/**
 * interface for professor service operation
 */
public interface ProfessorService {

	/**
	 * Method to get list of courses the professor is teaching
	 * @param instructorId: instructor id
	 * @return returns list of courses the professor is teaching
	 */
	public List<String> viewCourseList(int instructorId);

	/**
	 * Method to assign course to professor and return status of assigning the course to professor for teaching
	 * @param courseId: course id
	 * @param instructorId: instructor id
	 * @return status of assigning the course to professor for teaching
	 */
	public boolean selectCourseToTeach(String courseId, int instructorId);

	/**
	 * Method to get list of enrolled students corresponding to current professor id and course id
	 * @param instructorId: instructor id
	 * @param courseId: course id
	 * @return list of enrolled students corresponding to current professor id and course id
	 */
	public List<String> viewEnrolledStudents(int instructorId,String courseId);

	/**
	 * Method to add grade to student and get status if grade is added or not
	 * @param courseId: course id
	 * @param studentId: student id
	 * @param grade: student grade
	 * @return returns status if grade is added or not
	 */
	 public boolean addGrade(String courseId, int studentId, String grade);
	
}
