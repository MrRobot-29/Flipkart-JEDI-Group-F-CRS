package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

/**
 * Interface for Admin Dao
 */
public interface AdminDAOInterface {

    /**
     * Delete Course using SQL commands
     * @throws
     * @param courseId: course id
     */
	public void dropCourse(String courseId);

    /**
     *
     * @param c: course object
     * @return status of is course added
     */
    public boolean addCourse(Course c);

    /**
     * Method to view all courses
     * @return all courses
     */
    public ArrayList<Course> viewCourses();

// student related services

    /**
     * Method to get all pending students
     * @return pending students
     */
    public ArrayList<Student> viewPendingStudents();

    /**
     * Method to get list of all the students
     * @return list of all the students
     */
    public ArrayList<Student> viewAllStudents();

    /**
     * Method to check if student is valid or not
     * @param studentId
     * @return status of valid student
     */
    public boolean validateStudent(int studentId);


// professor related services

    /**
     * Method to add professor
     * @param prof: professor object
     */
    public void addProfessor(Professor prof);

    /**
     * Method to drop professor
     * @param ProfId: professor id
     */
    public void dropProfessor(int ProfId);

    /**
     * Method to view professors
     * @return list of professors
     */
    public ArrayList<Professor> viewProfessors();


    // gradecard related services

    /**
     * Method to generate grade card of a semester
     * @param semester
     */
    public void generateGradeCard(int semester);
}
