package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

/**
 * Interface for Admin Dao Operation
 */
public interface AdminDAOInterface {

    /**
     * Delete Course using SQL commands
     * @throws
     * @param courseId: course id
     */
	public void dropCourse(String courseId);

    public boolean addCourse(Course c);

    public ArrayList<Course> viewCourses();

// student related services

    public ArrayList<Student> viewPendingStudents();

    public ArrayList<Student> viewAllStudents();

    public boolean validateStudent(int studentId);


// professor related services

    public void addProfessor(Professor prof);

    public void dropProfessor(int ProfId);
    
    public void viewProfessors();


    // gradecard related services
    public void generateGradeCard(int semester);
}
