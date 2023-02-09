package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;

/**
 * Interface for Semester Course Operation
 */
public interface SemesterCourseService {
	
	public ArrayList<Course> viewCourses();
	
	public void addCourses();
	
	public void dropCourses();
	
	public void listStudentsCourses();
	
	public void viewOptedCourses();
	
	public void submitOptedCourse();
}
