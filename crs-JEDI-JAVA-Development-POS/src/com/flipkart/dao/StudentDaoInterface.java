package com.flipkart.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

/**
 * Interface for student Dao
 */
public interface StudentDaoInterface {

	/**
	 * Method to get student id
	 * @param email
	 * @return student id
	 */
	public int getStudentId(String email);

	/**
	 *
	 * @param studentId
	 * @return status of is student approved
	 */
	public boolean isApproved(int studentId) ;

	/**
	 *
	 * @param studentId
	 * @return current semester of student
	 */
	public int getCurrentSemester(int studentId);

	/**
	 * Method to add student to database
	 * @param student
	 * @param semester
	 */
	public void addStudent(Student student, int semester);

	/**
	 * Method to get count of primary course of student from database
	 * @param student_id
	 * @return count of primary course of student from database
	 */
	public int primaryCourseFreq(int student_id);

	/**
	 * Method to get count of secondary course of student from database
	 * @param student_id
	 * @return count of secondary course of student from database
	 */
	public int secondaryCourseFreq(int student_id);

	/**
	 * Method to add course in database
	 * @param student_id
	 * @param course_id
	 * @param course_type
	 * @return return status of is course added
	 */
	public boolean addCourseBucket(int student_id, String course_id, int course_type);

	/**
	 * Method to drop course by student
	 * @param studentId
	 * @param courseId
	 * @return status of is course is removed by student
	 */
	public boolean drop_course(int studentId, String courseId);

	/**
	 * Method to get list of courses in given semester
	 * @param sem: semester
	 * @return list of courses in given semester
	 */
	public ArrayList<Course> courseList(int sem);

	/**
	 * Method to get course availability by course id
	 * @param course_id
	 * @return status of course availability
	 */
	public boolean getCourseAvailabilityStatus(String course_id);

	/**
	 * Method to get Registered course list of students
	 * @param student_id
	 * @return registered course list of students
	 */
	public ArrayList<String> getRegisteredCourseList(int student_id);

	/**
	 * Method to get status of if course is frozen
	 * @param student_id
	 * @return status of if course is frozen bu student
	 */
	public boolean freezeCourses(int student_id) ;

	/**
	 * Method to get total fee of registered course
	 * @param student_id
	 * @return return total fee of registered course
	 */
	public double calculate_total_fee(int student_id);
	public HashMap<String,String> viewGrade(int student_id, int semester);
	public String isGradeReleased(int semester);
	public boolean payFee(int student_id, String payment_id, String payment_method, String payment_details);
}
