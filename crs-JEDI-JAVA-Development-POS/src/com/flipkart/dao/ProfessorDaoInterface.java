package com.flipkart.dao;

import java.util.List;

public interface ProfessorDaoInterface {
	
	public List<String> viewCourseList(int instructorId);
	
	public boolean selectCourseToTeach(String courseId, int instructorId);
	
	public List<String> viewEnrolledStudents(int instructorId,String courseId);
	
	 public boolean addGrade(String courseId, int studentId, String grade);
}
