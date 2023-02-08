package com.flipkart.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.bean.Professor;
import com.flipkart.constant.Color;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.dao.AdminDAOImpl;
import com.flipkart.data.SharedTempData;
import com.flipkart.data.TempData;
import com.flipkart.exception.*;

/**
 * Implementations of Admin Service Operations
 */
public class AdminServiceOperation implements AdminService {
	static int profId = 1;
    public boolean dropCourse(String courseID) throws CourseNotFoundException {
    	AdminDAOImpl aDao = new AdminDAOImpl();
		try {
			aDao.dropCourse(courseID);
		}catch(CourseNotFoundException e){
			throw e;
		}
    	return true;
    }

    public boolean addCourse(Course newCourse) throws CourseAlreadyExistsException {

		AdminDAOImpl aDao = new AdminDAOImpl();
		try {			
			aDao.addCourse(newCourse);
		} catch(CourseAlreadyExistsException e) {
			throw e;
		}
    	return true;
    	
    }
    public ArrayList<Course> viewCourses() throws  NoCourseFoundException{
    	AdminDAOImpl aDao = new AdminDAOImpl();
		try{
	    	return aDao.viewCourses();
		}catch (NoCourseFoundException e){
			throw e;
		}

    }
    // student related services
    public ArrayList<Student> viewPendingStudents() throws NoStudentFoundException {


    	AdminDAOImpl aDao  = new AdminDAOImpl();
    	
    	return aDao.viewPendingStudents();
    }

    public ArrayList<Student> viewAllStudents() throws NoStudentFoundException {
    	
    	AdminDAOImpl aDao  = new AdminDAOImpl();
    	
    	return aDao.viewAllStudents();
    	
    }

    public boolean validateStudent(int studentId) throws  StudentNotFoundException{
    	
    	AdminDAOImpl aDao  = new AdminDAOImpl();

		try {
			return aDao.validateStudent(studentId);
		} catch (StudentNotFoundException e) {
			throw e;
		}

	}


    // professor related services
    public void addProfessor(Professor prof) throws  ProfessorIdAlreadyExistsException{
    	
    	try {
    	AdminDAOImpl adminDao = new AdminDAOImpl();
		adminDao.addProfessor(prof);
		} catch (ProfessorIdAlreadyExistsException e) {
			throw e;
		}
    }

    public void dropProfessor(int profId) throws ProfessorCannotBeDroppedException {
    	try {
	    	AdminDAOImpl adminDao = new AdminDAOImpl();
			adminDao.dropProfessor(profId);
		} catch (ProfessorCannotBeDroppedException e) {
			throw e;
		}
	}
    public void viewProfessors() {

    }


    // gradecard related services
    public void generateGradeCard(int sem) throws GradeCardNotGeneratedException{
    	AdminDAOImpl  aDao = new AdminDAOImpl();
		try {
			aDao.generateGradeCard(sem);
		} catch (GradeCardNotGeneratedException e) {
			throw e;
		}
	}
}


