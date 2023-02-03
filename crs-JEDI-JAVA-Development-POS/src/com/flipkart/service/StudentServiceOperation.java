/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;
import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
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
	
	
	
	public int calculateTotalFee() {
		// calculate the total fees based on the registered courses.
		ArrayList<Course> approvedCourses = td.getStudentApprovedCourses();
		
		int totalFee = 0;
		
		for(var course: approvedCourses) {
			totalFee += course.getCourseFee();
		}
		
		return totalFee;
	}
	
	
	
	public void payFee(String user) {
		
		Student st = null;
		
		for (Student student : td.getApprovedStudents()) {
			if(student.getName() == user) {
				st = student;
				break;
			}
		}


		int totalFee = this.calculateTotalFee();
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
	
	public void assignCourse(int studentId)
	{
		
		td.getStudentTakenCourses().put(studentId, td.getStudentCourseCart());
	}
	
	
	public ArrayList<ArrayList<String>> viewGrade(String studentId) {
		//view the grade card with exception handling
		
		TempData data = new TempData();
		ArrayList<Grade> grades = new ArrayList<Grade>();
		ArrayList<Course> courses = new ArrayList<Course>();
		ArrayList<ArrayList<String>> gradeCard = new ArrayList<ArrayList<String>>();
		grades = data.getGrades();
		courses = data.getCourseList();
		for(Grade grade : grades) {
			if(grade.getStudentId().equals(studentId)) {
				for(Course course : courses) {
					if(grade.getCourseId().equals(course.getCourseId())) { 
						ArrayList<String> courseGrade = new ArrayList<String>();
						courseGrade.add(course.getCourseName());
						courseGrade.add(grade.getGrade());
						gradeCard.add(courseGrade);
					}
				}
			}
		}
		return gradeCard;
		
	}
	
}
