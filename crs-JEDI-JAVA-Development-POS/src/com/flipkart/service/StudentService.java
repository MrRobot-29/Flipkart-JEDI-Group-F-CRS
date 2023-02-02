package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Student;

public interface StudentService {

	public ArrayList<Course> courseList();
	
	public boolean addCourse(Course c);
	
	public void dropCourse(Course c);
	
	public  ArrayList<Course> approvedList();
	
	public int calculateTotalFee();
	
	public void payFee(Student s);
	
	public String viewGrade(RegisteredCourse rc);
}
