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

/**
 * @author ashwin.kumar2
 *
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

	
//	public boolean registerCourses() {
//		ArrayList<Course> registeredCourses = new ArrayList<Course>();
//		for(var c: td.getStudentCourseCart()) {
//			registeredCourses.add(c);
//		}
//		td.setStudentApprovedCourses(registeredCourses);
//		HashMap<Integer,ArrayList<Course>> studentTakenCourse = td.getStudentTakenCourses();
//		studentTakenCourse.put(10001, registeredCourses);
//		return true;
//	}
//	
	
	public double calculateTotalFee(ArrayList<Course> approvedCourses) {
		// calculate the total fees based on the registered courses.
		
		
		double totalFee = 0.0;
		
		for(var course: approvedCourses) {
			totalFee += course.getCourseFee();
		}
		
		return totalFee;
	}
	
	
	
	public void payFee(String user) {
		
		Student st = null;
		
		for (Student student : td.getApprovedStudents()) {
			if(student.getStudentID() == Integer.parseInt(user)) {
				st = student;
				break;
			}
		}

		ArrayList<Course> approvedCourses = td.getStudentApprovedCourses();
		double totalFee = this.calculateTotalFee(approvedCourses);
		System.out.println(totalFee);
		PaymentServiceOperation pso = new PaymentServiceOperation();
		
		pso.initiatePayment(totalFee, st, td.getStudentApprovedCourses());
		
		
		// pay for the fees and return receipt
		/*
		 * 
		 * if else for the payment status.
		 * 
		 */
		
	}
	
	public HashMap<String,String> viewGrade(int studentId,int sem) {
		//view the grade card with exception handling
		return studentDao.viewGrade(studentId, sem);
		
	}
	
}
