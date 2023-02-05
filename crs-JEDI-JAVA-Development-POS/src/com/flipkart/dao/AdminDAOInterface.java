package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

public interface AdminDAOInterface {
	public void dropCourse(String courseId);

    public boolean addCourse(Course c);

    public ArrayList<Course> viewCourses();

// student related services

    public ArrayList<Student> viewPendingStudents();

    public ArrayList<Student> viewAllStudents();

    public boolean validateStudent(int studentId);


// professor related services

    public void addProfessor();

    public void dropProfessor(int ProfId);
    
    public void viewProfessors();


    // gradecard related services
    public void generateGradeCard(String studentId, String semester);
}
