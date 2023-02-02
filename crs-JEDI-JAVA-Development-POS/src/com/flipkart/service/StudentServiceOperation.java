/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Student;
import com.flipkart.data.TempData;

/**
 * @author ashwin.kumar2
 *
 */

public class StudentServiceOperation implements StudentService{
	
	TempData td = new TempData();
	
	
	public ArrayList<Course> courseList() {
		// get the list of all the courses and return it.
		
		return td.getCourseList();
		
	}
	
	
	
	public boolean addCourse(Course c) {
		// add the course
		ArrayList<Course> stdCart = td.getStudentCourseCart();
		if(stdCart.size() > 6) return false;	
		stdCart.add(c);
		return true;
	
	}
	
	public void dropCourse(Course c) {
		// drop the course
		
		ArrayList<Course> stdCart = td.getStudentCourseCart();
		
		stdCart.remove(c);
		
	}
	
	public ArrayList<Course> approvedList() {
		// get the list of approved registered courses
		return td.getStudentApprovedCourses();
	}
	
	
	
	public int calculateTotalFee() {
		// calculate the total fees based on the registered courses.
		ArrayList<Course> approvedCourses = td.getStudentApprovedCourses();
		
		int totalFee = 0;
		
		for(var course: approvedCourses) {
			totalFee += course.getCourseFee();
		}
		
		return totalFee;
	}
	
	
	
	public void payFee(Student s) {
		
		
		int totalFee = this.calculateTotalFee();
		
		PaymentServiceOperation pso = new PaymentServiceOperation();
		
		pso.initiatePayment(totalFee, s);
		
		
		// pay for the fees and return receipt
		/*
		 * 
		 * if else for the payment status.
		 * 
		 */
		
	}
	
	
	public String viewGrade(RegisteredCourse rc) {
		//view the grade card with exception handling
		
		return rc.getGradesObtained();
		
	}
	
}
