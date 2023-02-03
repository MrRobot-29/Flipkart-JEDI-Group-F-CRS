package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Student;

public interface StudentService {

	public ArrayList<Course> courseList();
	
	public  boolean addCourse(String courseId);
	
	public boolean dropCourse(String courseId);
	
	public  ArrayList<Course> approvedList();
	
	public int calculateTotalFee();
	
	public void payFee(String user);
	
	public ArrayList<ArrayList<String>> viewGrade(String studentId);
}
