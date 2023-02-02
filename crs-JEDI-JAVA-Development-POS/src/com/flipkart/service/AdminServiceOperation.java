package com.flipkart.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.bean.Professor;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.data.TempData;

public class AdminServiceOperation implements AdminService {

	TempData td = new TempData();
	
	Scanner sc = new Scanner(System.in);
	static int profId = 1;
    // course services
    public boolean dropCourse() {
    	System.out.println("Enter Course Id to be deleted");
    	String cid = sc.next();
    	ArrayList<Course> cl = td.getCourseList();
    	cl.removeIf(c -> c.getCourseId().compareTo(cid) == 0);
    	return true;
    }

    public boolean addCourse() {
    	System.out.println("Enter Course Name");
    	String cname = sc.next();
    	System.out.println("Enter Course ID");
    	String cid = sc.next();
    	System.out.println("Enter Instructor ID (NA if not assigned)");
    	String insid = sc.next();
    	System.out.println("Enter Course Fee");
    	Double courseFee = sc.nextDouble();
    	Course newCourse = new Course(cname, cid, insid, true, courseFee);
    	ArrayList<Course> cl = td.getCourseList();
    	cl.add(newCourse);
    	td.setCourseList(cl);
    	return true;
    	
    }
    public ArrayList<Course> viewCourses(){
    	
    	return td.getCourseList();
    	
    }
    // student related services
    public ArrayList<Student> viewPendingStudents() {
    	
    	ArrayList<Student> st1 = td.getPendingStudents();
    	
    	return st1;
    }

    public ArrayList<Student> viewAllStudents() {
    	
    	ArrayList<Student> st1 = td.getApprovedStudents();
    	
    	return st1;
    	
    }

    public boolean validateStudent(int studentId){
    	
    	ArrayList<Student> st1 = td.getPendingStudents();
    	
    	int flag = -1;
    	
    	for(Student at : st1) {
    		if(at.getStudentID() == studentId) {
    			flag = at.getStudentID();
    			
    			// validate
    			at.setApproved(true);
    			
    			td.removePendingStudents(at);
    			
    			td.setApprovedStudents(at);
    			
    			break;
    		}
    	}
    	
    	if(flag == -1) {
    		return false;
    	}
    	
    	
    	
    	return true;
    }


    // professor related services
    public void addProfessor() {
    	System.out.println("Enter Professor Details");
    	System.out.println("Enter Name: ");
    	String name = sc.next();
    	System.out.println("Enter Password: ");
    	String pwd = sc.next();
    	System.out.println("Enter Designation: ");
    	String desg = sc.next();
    	System.out.println("Enter Gender ");
    	String gender = sc.next();
    	Gender profGender;
    	if(gender.equalsIgnoreCase("male"))
    		profGender = Gender.MALE;
    	else if(gender.equalsIgnoreCase("female"))
    		profGender = Gender.FEMALE;
    	else
    		profGender = Gender.OTHER;
    	Professor prof = new Professor(Integer.toString(profId),name,Role.PROFESSOR,pwd,profGender,"India","India","CS",desg);
    	profId++;
    	td.getProfessor().add(prof);
    	System.out.println("Professor Added Successfully");
    }

    public void dropProfessor(){
    	System.out.println("Enter Professor Id: ");
    	String id = sc.next();
    	td.getProfessor().removeIf(prof -> prof.getUserId().compareTo(id) == 0);
    	System.out.println("Professor Dropped Successfully");
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
    public void generateGradeCard(String studentId, String semester){

    }
}


