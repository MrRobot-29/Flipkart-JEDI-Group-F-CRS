package com.flipkart.service;

import java.util.List;

public interface ProfessorService {
	
	public  List<String> viewCourseList(String instructorId);
	
	public boolean selectCourseToTeach(String courseId, String instructorId);
	
	public void viewEnrolledStudents();
	
	public boolean addGrade(String courseId, String studentId, String grade);
	
}
