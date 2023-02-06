package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;

/**
 * Interface for Student Service Operation
 */
public interface StudentService {

	/**
	 * Method to return list of courses taken by student
	 * @param sem: semester of student
	 * @return list of courses taken by student
	 */
	public ArrayList<Course> courseList(int sem);

	/**
	 * Method to add course to student and return status of is course added to student
	 * @param student_id: student id
	 * @param courseId: course id
	 * @param course_type: course type
	 * @return status of is course added to student
	 */
	public boolean addCourse(int student_id, String courseId, int course_type);

	/**
	 * Method to drop course and return tatus of is course removed
	 * @param courseId: course id
	 * @return status of is course removed
	 */
	public boolean dropCourse(String courseId);

	/**
	 * Method to get the list of approved registered courses
	 * @param student_id: student id
	 * @return list of approved registered courses
	 */
	public  ArrayList<String> approvedList(String student_id);

	/**
	 * Method to get total fee of approved courses
	 * @param approvedCourses: list of approved courses
	 * @return total fee of approved courses
	 */
	public double calculateTotalFee(ArrayList<Course> approvedCourses);

	/**
	 * Method to pay fee
	 * @param user: user who is paying the fee
	 */
	public void payFee(String user);

	/**
	 * Method to view Grade of student
	 * @param studentId: student id
	 * @return list of course and corresponding grade
	 */
	public ArrayList<ArrayList<String>> viewGrade(int studentId);

	/**
	 * Method to get list of selected course by student
	 * @param student_id: student id
	 * @return list of selected course by student
	 */
	public ArrayList<String> viewSelectedCourses(String student_id);
	
	//public boolean registerCourses();

	/**
	 * Method to get status of course availability
	 * @param courseId: course id
	 * @return status of course availability
	 */
	public boolean getCourseAvailabilityStatus(String courseId);

	/**
	 * Method to get count of primary courses
	 * @param student_id: student id
	 * @return count of primary courses
	 */
	public int primaryCourseFreq(int student_id) ;

	/**
	 * Method to get count of secondary courses
	 * @param student_id: student id
	 * @return count of secondary courses
	 */
	public int secondaryCourseFreq(int student_id) ;
}
