package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;

public interface StudentService {

	public ArrayList<Course> courseList();
	
	public boolean addCourse(Course c);
	
	public void dropCourse(Course c);
	
	public  ArrayList<Course> approvedList();
	
	public int calculateTotalFee();
	
	public void payFee();
	
	public void viewGrade();
}
