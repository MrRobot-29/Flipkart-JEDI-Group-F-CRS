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
	Scanner sc = new Scanner(System.in);
	static int profId = 1;
	
	
    public boolean dropCourse() throws CourseNotFoundException {
    	System.out.println("Enter Course Id to be deleted");
    	String cid = sc.next();
    	AdminDAOImpl aDao = new AdminDAOImpl();

		try {
			aDao.dropCourse(cid);
		}catch(CourseNotFoundException e){
			throw e;
		}
    	return true;
    }

    public boolean addCourse() throws CourseAlreadyExistsException {
    	System.out.println("Enter Course Name");
    	String cname = "";
    	cname = sc.nextLine();
    	System.out.println("Enter Course ID");
    	String cid = sc.next();
    	System.out.println("Enter Instructor ID (0 if not assigned)");
    	int insid = sc.nextInt();
    	System.out.println("Enter Course Fee");
    	Double courseFee = sc.nextDouble();
    	System.out.println("Enter semester to which the course is offered");
    	int sem = sc.nextInt();
    	Course newCourse = new Course(cname, cid, insid, true, courseFee, sem);

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
    public void addProfessor() throws  ProfessorIdAlreadyExistsException{
    	
    	try {
    		
    	System.out.println("Professor Details");
    	System.out.println("Enter Professor email:");
    	String email = sc.next();
    	System.out.println("Enter Professor pwd:");
    	String pwd = sc.next();
    	System.out.println("Enter Name: ");
    	String name = sc.next();
    	System.out.println("Enter Dept: ");
    	String dept = sc.next();
    	System.out.println("Enter Gender ");
    	String gender = sc.next();
    	System.out.println("Enter Professor Id(Integer): ");
    	int profId = sc.nextInt();
    	Gender profGender;
    	
    	if(gender.equalsIgnoreCase("male"))
    		profGender = Gender.MALE;
    	else if(gender.equalsIgnoreCase("female"))
    		profGender = Gender.FEMALE;
    	else
    		profGender = Gender.OTHER;
    	
    	Professor prof = new Professor(email,name,Role.PROFESSOR,pwd,profGender,"India","India",dept,"Associate Professor", profId);
    	AdminDAOImpl adminDao = new AdminDAOImpl();
		adminDao.addProfessor(prof);
		System.out.println(Color.ANSI_GREEN + "Professor Added Successfully" + Color.ANSI_RESET);
		} catch (ProfessorIdAlreadyExistsException e) {
			throw e;
		} catch (InputMismatchException im) {
			System.out.println(Color.ANSI_YELLOW + "Invalid input" + Color.ANSI_RESET);
			sc.nextLine();
			return;
		}
    }

    public void dropProfessor() throws ProfessorCannotBeDroppedException {
    	try {
	    	System.out.println("Enter Professor Id: ");
	    	int id = sc.nextInt();
	    	AdminDAOImpl adminDao = new AdminDAOImpl();
			adminDao.dropProfessor(id);
		} catch (ProfessorCannotBeDroppedException e) {
			throw e;
		} catch (InputMismatchException im) {
			System.out.println(Color.ANSI_YELLOW + "Professor ID must be a number " + Color.ANSI_RESET);
			sc.nextLine();
			return;
		}
	}
    public void viewProfessors() {

    }


    // gradecard related services
    public void generateGradeCard() throws GradeCardNotGeneratedException{
    	System.out.println("Enter semester for which grade card needs to be generated: ");
		int sem = sc.nextInt();
    	AdminDAOImpl  aDao = new AdminDAOImpl();
		try {
			aDao.generateGradeCard(sem);
		} catch (GradeCardNotGeneratedException e) {
			throw e;
		}
	}
}


