/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Student;
import com.flipkart.data.SharedTempData;
import com.flipkart.data.TempData;

/**
 * @author ashwin.kumar2
 *
 */

public class StudentServiceOperation implements StudentService{
	
	TempData td = SharedTempData.td;
	
	public ArrayList<Course> courseList() {
		// get the list of all the courses and return it.
		
		return td.getCourseList();
		
	}
	
	
	
	public boolean addCourse(String courseId) {
		// add the course
		ArrayList<Course> courseList = td.getCourseList();
		int ind = -1;
		
		for(int i = 0; i < courseList.size(); i++) {
			if(courseList.get(i).getCourseId().compareTo(courseId) == 0) {
				ind = i;
				break;
			}
		}
		
		if(ind == -1) {
			
			return false;
		}
		ArrayList<Course> stdCart = td.getStudentCourseCart();
		if(stdCart.size() > 6) return false;	
		stdCart.add(courseList.get(ind));
		td.setStudentCourseCart(stdCart);
		return true;
	
	}
	
	public boolean dropCourse(String courseId) {
		// drop the course
		
		ArrayList<Course> stdCart = td.getStudentCourseCart();
		
		stdCart.removeIf(c -> c.getCourseId() == courseId);
		
		return true;
		
	}
	
	public ArrayList<Course> approvedList() {
		// get the list of approved registered courses
		return td.getStudentCourseCart();
	}
	
	
	
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

		ArrayList<Course> approvedCourses = td.getStudentCourseCart();
		double totalFee = this.calculateTotalFee(approvedCourses);
		System.out.println(totalFee);
		PaymentServiceOperation pso = new PaymentServiceOperation();
		
		pso.initiatePayment(totalFee, st, td.getStudentCourseCart());
		
		
		// pay for the fees and return receipt
		/*
		 * 
		 * if else for the payment status.
		 * 
		 */
		
	}
	
	public void assignCourse(int studentId)
	{
		
		td.getStudentTakenCourses().put(studentId, td.getStudentCourseCart());
	}
	
	
	public String viewGrade(RegisteredCourse rc) {
		//view the grade card with exception handling
		
		return rc.getGradesObtained();
		
	}
	
}
