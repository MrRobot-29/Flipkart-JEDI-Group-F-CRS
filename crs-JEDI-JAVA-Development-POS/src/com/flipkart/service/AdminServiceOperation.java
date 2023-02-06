package com.flipkart.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.bean.Professor;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.dao.AdminDAOImpl;
import com.flipkart.data.SharedTempData;
import com.flipkart.data.TempData;

public class AdminServiceOperation implements AdminService {

	TempData td = SharedTempData.td;
	
	Scanner sc = new Scanner(System.in);
	static int profId = 1;
    // course services
    public boolean dropCourse() {
    	System.out.println("Enter Course Id to be deleted");
    	String cid = sc.next();
    	AdminDAOImpl aDao = new AdminDAOImpl();
    	aDao.dropCourse(cid);
    	return true;
    }

    public boolean addCourse() {
    	System.out.println("Enter Course Name");
    	String cname = "";
    	cname += sc.nextLine();
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
    	aDao.addCourse(newCourse);
    	return true;
    	
    }
    public ArrayList<Course> viewCourses(){
    	AdminDAOImpl aDao = new AdminDAOImpl();
    	return aDao.viewCourses();
    	
    }
    // student related services
    public ArrayList<Student> viewPendingStudents() {
    	
    	AdminDAOImpl aDao  = new AdminDAOImpl();
    	
    	return aDao.viewPendingStudents();
    }

    public ArrayList<Student> viewAllStudents() {
    	
    	AdminDAOImpl aDao  = new AdminDAOImpl();
    	
    	return aDao.viewAllStudents();
    	
    }

    public boolean validateStudent(int studentId){
    	
    	AdminDAOImpl aDao  = new AdminDAOImpl();
    	
    	 return aDao.validateStudent(studentId);
    	
    }


    // professor related services
    public void addProfessor() {
    	
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
    	System.out.println("Professor Added Successfully");
    }

    public void dropProfessor(){
    	System.out.println("Enter Professor Id: ");
    	int id = sc.nextInt();
    	AdminDAOImpl adminDao = new AdminDAOImpl();
    	adminDao.dropProfessor(id);
    }
    public void viewProfessors() {
    	for(Professor prof: td.getProfessor())
    	{
    		System.out.println("Name: "+prof.getName());
    		System.out.println("Id: "+prof.getUserId());
    		System.out.println("Desgination: "+prof.getDesignation());
    		System.out.println("Department: "+prof.getDepartment());
    		System.out.println("Address: "+prof.getAddress());
    	}
    		
    }


    // gradecard related services
    public void generateGradeCard(){
    	System.out.println("Enter semester for which grade card needs to be generated: ");
		int sem = sc.nextInt();
    	AdminDAOImpl  aDao = new AdminDAOImpl();
    	aDao.generateGradeCard(sem);
    }
}


