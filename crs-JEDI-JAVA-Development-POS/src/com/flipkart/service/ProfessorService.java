package com.flipkart.service;

import java.util.List;

public interface ProfessorService {
	
	public List<String> viewCourseList(int instructorId);
	
	public boolean selectCourseToTeach(String courseId, int instructorId);
	
	public void viewEnrolledStudents();
	
	 public boolean addGrade(String courseId, int studentId, String grade);
	
}
