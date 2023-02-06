package com.flipkart.service;

import java.util.List;

/**
 * interface for professor service operation
 */
public interface ProfessorService {

	/**
	 *
	 * @param instructorId: instructor id
	 * @return returns list of courses the professor is teaching
	 */
	public List<String> viewCourseList(int instructorId);

	/**
	 *
	 * @param courseId: course id
	 * @param instructorId: instructor id
	 * @return status of assigning the course to professor for teaching
	 */
	public boolean selectCourseToTeach(String courseId, int instructorId);

	/**
	 *
	 * @param instructorId: instructor id
	 * @param courseId: course id
	 * @return list of enrolled students corresponding to current professor id and course id
	 */
	public List<String> viewEnrolledStudents(int instructorId,String courseId);

	/**
	 *
	 * @param courseId: course id
	 * @param studentId: student id
	 * @param grade: student grade
	 * @return returns status if grade is added or not
	 */
	 public boolean addGrade(String courseId, int studentId, String grade);
	
}
