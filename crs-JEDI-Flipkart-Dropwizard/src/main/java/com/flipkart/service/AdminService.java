package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseAlreadyExistsException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.EmailAlreadyInUseException;
import com.flipkart.exception.GradeCardNotGeneratedException;
import com.flipkart.exception.NoCourseFoundException;
import com.flipkart.exception.NoProfessorFoundException;
import com.flipkart.exception.NoStudentFoundException;
import com.flipkart.exception.ProfessorCannotBeDroppedException;
import com.flipkart.exception.ProfessorIdAlreadyExistsException;
import com.flipkart.exception.StudentNotFoundException;

/**
 * Interface for Admin Service Operations
 */
public interface AdminService {

    /**
     * Method to drop a course
     * @return status of drop course
     */
	public boolean dropCourse(String courseId) throws CourseNotFoundException;

    /**
     * Method to add courses
     * @return status of add course
     */
    public boolean addCourse(Course newCourse) throws CourseAlreadyExistsException;

    /**
     * Method to get list of courses in catalog
     * @return list of course in catalog
     */
    public ArrayList<Course> viewCourses() throws NoCourseFoundException;

// student related services

    /**
     * Method to view Students yet to be approved by Admin
     * @return List of Students with pending registration
     */
    public ArrayList<Student> viewPendingStudents() throws NoStudentFoundException;

    /**
     * Method to view all Students
     * @return list of all students
     */
    public ArrayList<Student> viewAllStudents() throws NoStudentFoundException;

    /**
     * Method to validate student
     * @param studentId: student id
     * @return status of validation
     */
    public boolean validateStudent(int studentId) throws StudentNotFoundException;


// professor related services

    /**
     * Method to add professor
     */
    public void addProfessor(Professor prof) throws EmailAlreadyInUseException, ProfessorIdAlreadyExistsException;

    /**
     * method to drop professor
     */
    public void dropProfessor(int profId) throws ProfessorCannotBeDroppedException;

    /**
     * method to view professors
     */
    public void viewProfessors() throws NoProfessorFoundException;


    // gradecard related services

    /**
     * method to generate grade card
     */
    public void generateGradeCard(int sem) throws GradeCardNotGeneratedException;

}
