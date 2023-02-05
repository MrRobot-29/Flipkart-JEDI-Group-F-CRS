package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;

public interface StudentService {

	public ArrayList<Course> courseList();
	
	public  boolean addCourse(String courseId);
	
	public boolean dropCourse(String courseId);
	
	public  ArrayList<Course> approvedList();
	
	public double calculateTotalFee(ArrayList<Course> approvedCourses);
	
	public void payFee(String user);
	
	public ArrayList<ArrayList<String>> viewGrade(int studentId);
	
	public ArrayList<Course> viewSelectedCourses();
	
	public boolean registerCourses();
}
