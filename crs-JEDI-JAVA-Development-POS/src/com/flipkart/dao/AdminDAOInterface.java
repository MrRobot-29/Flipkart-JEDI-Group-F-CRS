package com.flipkart.dao;

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
 * Interface for Admin Dao
 */
public interface AdminDAOInterface {

    /**
     * Delete Course using SQL commands
     * @throws
     * @param courseId: course id
     */
	public void dropCourse(String courseId) throws CourseNotFoundException;

    /**
     *
     * @param c: course object
     * @return status of is course added
     */
    public boolean addCourse(Course c) throws CourseAlreadyExistsException;

    /**
     * Method to view all courses
     * @return all courses
     */
    public ArrayList<Course> viewCourses() throws NoCourseFoundException;

// student related services

    /**
     * Method to get all pending students
     * @return pending students
     */
    public ArrayList<Student> viewPendingStudents()throws NoStudentFoundException;

    /**
     * Method to get list of all the students
     * @return list of all the students
     */
    public ArrayList<Student> viewAllStudents() throws NoStudentFoundException;

    /**
     * Method to check if student is valid or not
     * @param studentId
     * @return status of valid student
     */
    public boolean validateStudent(int studentId) throws StudentNotFoundException;


// professor related services

    /**
     * Method to add professor
     * @param prof: professor object
     */
    public void addProfessor(Professor prof)  throws EmailAlreadyInUseException, ProfessorIdAlreadyExistsException;

    /**
     * Method to drop professor
     * @param ProfId: professor id
     */
    public void dropProfessor(int ProfId) throws ProfessorCannotBeDroppedException;

    /**
     * Method to view professors
     * @return list of professors
     */
    public void viewProfessors() throws NoProfessorFoundException;


    // gradecard related services

    /**
     * Method to generate grade card of a semester
     * @param semester
     */
    public void generateGradeCard(int semester) throws GradeCardNotGeneratedException;
}
