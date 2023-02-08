/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
//import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.data.SharedTempData;
import com.flipkart.data.TempData;
import com.flipkart.exception.PaymentNotCompletedException;

/**
 * @author ashwin.kumar2
 * Implementation for Student Service Operation
 */

public class StudentServiceOperation implements StudentService{
	
	StudentDaoInterface studentDao = new StudentDaoImpl();
	static TempData td = SharedTempData.td;
	
	public ArrayList<Course> courseList(int sem) {
		// get the list of all the courses and return it.
		return studentDao.courseList(sem);		
	}
	
	public boolean getCourseAvailabilityStatus(String courseId) {
		
		return studentDao.getCourseAvailabilityStatus(courseId);
		
	}
	
	public boolean addCourse(int student_id, String courseId, int course_type) {
		// add the course
		return studentDao.addCourseBucket(student_id, courseId, course_type);
	
	}
	
	public int primaryCourseFreq(int student_id) {
		// add the course
		return studentDao.primaryCourseFreq(student_id);
	
	}
	
	public int secondaryCourseFreq(int student_id) {
		// add the course
		return studentDao.secondaryCourseFreq(student_id);
	
	}
	
	public boolean dropCourse(int student, String courseId) {
		// drop the course
		
		studentDao.drop_course(student, courseId);
		
		return true;
		
	}
	
	public boolean freezeCourseCart(int studentId) {
		return studentDao.freezeCourses(studentId);
	}
	
	public ArrayList<String> viewSelectedCourses(int student_id) {
		// get the list of approved registered courses
		return studentDao.getRegisteredCourseList(student_id);
	}
	
	public void payFee(Student std) {
		
		double amt = studentDao.calculate_total_fee(std.getStudentID());
		PaymentService pso = new PaymentServiceOperation();	
		try {
			pso.initiatePayment(amt, std, studentDao.getRegisteredCourseList(std.getStudentID()));
		} catch (PaymentNotCompletedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public HashMap<String,String> viewGrade(int studentId,int sem) {
		//view the grade card with exception handling
		return studentDao.viewGrade(studentId, sem);
		
	}
	
	public boolean checkCourse(int studentId, String courseId) 
	{
		return studentDao.checkCourse(studentId, courseId);
	}
	
}
