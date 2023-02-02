package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

public interface AdminService {
	
	public boolean dropCourse();

    public boolean addCourse();

    public ArrayList<Course> viewCourses();

// student related services

    public ArrayList<Student> viewPendingStudents();

    public ArrayList<Student> viewAllStudents();

    public boolean validateStudent(int studentId);


// professor related services

    public void addProfessor(String professorId);

    public void dropProfessor(String professorId);
    
    public void viewProfessors();


    // gradecard related services
    public void generateGradeCard(String studentId, String semester);

}
