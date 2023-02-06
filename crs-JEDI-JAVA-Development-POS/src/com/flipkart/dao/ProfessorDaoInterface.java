package com.flipkart.dao;

import java.util.List;

/**
 * Interface for Admin Dao
 */
public interface ProfessorDaoInterface {

	/**
	 *
	 * @param instructorId: instructor id
	 * @return returns the course list taught by the corresponding professor
	 */
	public List<String> viewCourseList(int instructorId);

	/**
	 *
	 * @param courseId: course id
	 * @param instructorId: instructor id
	 * @return returns the status of course taught by professor after adding into database
	 */
	public boolean selectCourseToTeach(String courseId, int instructorId);

	/**
	 *
	 * @param instructorId: instructor id
	 * @param courseId: course id
	 * @return return the enrolled students for the corresponding professor and course.
	 */
	public List<String> viewEnrolledStudents(int instructorId,String courseId);

	/**
	 *
	 * @param courseId: course id
	 * @param studentId: student id
	 * @param grade: grade of corresponding student
	 * @return returns the status after adding the grade
	 */
	 public boolean addGrade(String courseId, int studentId, String grade);
}
