package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;

public interface AdminService {
	
	public boolean dropCourse();

    public boolean addCourse();

    public ArrayList<Course> viewCourses();

// student related services

    public void viewPendingStudents();

    public void viewAllStudents();

    public void validateStudent(String studentId);


// professor related services

    public void addProfessor();

    public void dropProfessor();
    
    public void viewProfessors();


    // gradecard related services
    public void generateGradeCard(String studentId, String semester);

}
