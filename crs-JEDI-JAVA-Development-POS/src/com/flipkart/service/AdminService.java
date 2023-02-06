package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

/**
 * Interface for Admin Service Operations
 */
public interface AdminService {

    /**
     * Method to drop a course
     * @return status of drop course
     */
	public boolean dropCourse();

    /**
     * Method to add courses
     * @return status of add course
     */
    public boolean addCourse();

    /**
     * Method to get list of courses in catalog
     * @return list of course in catalog
     */
    public ArrayList<Course> viewCourses();

// student related services

    /**
     * Method to view Students yet to be approved by Admin
     * @return List of Students with pending registration
     */
    public ArrayList<Student> viewPendingStudents();

    /**
     * Method to view all Students
     * @return list of all students
     */
    public ArrayList<Student> viewAllStudents();

    /**
     * Method to validate student
     * @param studentId: student id
     * @return status of validation
     */
    public boolean validateStudent(int studentId);


// professor related services

    /**
     * Method to add professor
     */
    public void addProfessor();

    /**
     * method to drop professor
     */
    public void dropProfessor();

    /**
     * method to view professors
     */
    public void viewProfessors();


    // gradecard related services

    /**
     * method to generate grade card
     */
    public void generateGradeCard();

}
