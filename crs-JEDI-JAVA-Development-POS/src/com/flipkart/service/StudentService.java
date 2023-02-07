package com.flipkart.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseAlreadyOptedException;
import com.flipkart.exception.CourseCountExceededException;
import com.flipkart.exception.CourseNotAvailableException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.GradeNotAllotedException;
import com.flipkart.exception.NoCourseFoundException;
import com.flipkart.exception.PaymentNotCompletedException;

/**
 * Interface for Student Service Operation
 */
public interface StudentService {

	/**
	 * Method to return list of courses taken by student
	 * @param sem: semester of student
	 * @return list of courses taken by student
	 */
	public ArrayList<Course> courseList(int sem) throws NoCourseFoundException;

	/**
	 * Method to add course to student and return status of is course added to student
	 * @param student_id: student id
	 * @param courseId: course id
	 * @param course_type: course type
	 * @return status of is course added to student
	 */
	public boolean addCourse(int student_id, String courseId, int course_type) throws CourseAlreadyOptedException, CourseCountExceededException, CourseNotFoundException, CourseNotAvailableException;

	/**
	 * Method to drop course and return status of is course removed
	 * @param student
	 * @param courseId
	 * @return status of is course removed
	 */
	public boolean dropCourse(int student, String courseId) throws CourseNotFoundException ;

	/**
	 * Method to pay fee
	 * @param std: object of student who is paying fee
	 */
	public void payFee(Student std) throws PaymentNotCompletedException;
	
	/**
	 * Method to view Grade of student
	 * @param studentId: student id
	 * @return list of course and corresponding grade
	 */
	public HashMap<String,String> viewGrade(int studentId,int sem) throws GradeNotAllotedException;
	

	
	/**
	 * Method to get list of selected course by student
	 * @param student_id: student id
	 * @return list of selected course by student
	 */
	public ArrayList<String> viewSelectedCourses(int student_id) throws NoCourseFoundException;

	/**
	 * Method to freeze the course
	 * @param studentId: student id
	 * @return status of is course cart frozen
	 */
	public boolean freezeCourseCart(int studentId) throws CourseNotAvailableException;
	
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
