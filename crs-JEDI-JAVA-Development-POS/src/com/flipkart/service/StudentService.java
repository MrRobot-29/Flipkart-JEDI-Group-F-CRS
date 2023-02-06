package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;

public interface StudentService {

	public ArrayList<Course> courseList(int sem);
	
	public boolean addCourse(int student_id, String courseId, int course_type);
	
	public boolean dropCourse(String courseId);
	
	public  ArrayList<String> approvedList(String student_id);
	
	public double calculateTotalFee(ArrayList<Course> approvedCourses);
	
	public void payFee(String user);
	
	public ArrayList<ArrayList<String>> viewGrade(int studentId);
	
	public ArrayList<String> viewSelectedCourses(String student_id);
	
	//public boolean registerCourses();
	
	public boolean getCourseAvailabilityStatus(String courseId);
	public int primaryCourseFreq(int student_id) ;
	public int secondaryCourseFreq(int student_id) ;
}
