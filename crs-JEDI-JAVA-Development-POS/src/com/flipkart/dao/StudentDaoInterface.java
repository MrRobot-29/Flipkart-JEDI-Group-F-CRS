package com.flipkart.dao;

import com.flipkart.bean.Student;

public interface StudentDaoInterface {
	
	public int getStudentId(String email);
	public boolean isApproved(int studentId) ;
	public int getSemester(int studentId);
	public void addStudent(String email, String name, String branch, String semester, String password, Student student);

}
