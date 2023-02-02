package com.flipkart.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.data.TempData;

public class AdminServiceOperation implements AdminService {

	TempData td = new TempData();
    // course services
    public boolean dropCourse() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter Course Id to be deleted");
    	String cid = sc.next();
    	ArrayList<Course> cl = td.getCourseList();
    	cl.removeIf(c -> c.getCourseId().compareTo(cid) == 0);
    	return true;
    }

    public boolean addCourse() {
    	Scanner sc = new Scanner(System.in);
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
    public void viewPendingStudents() {

    }

    public void viewAllStudents() {

    }

    public void validateStudent(String studentId){


    }


    // professor related services
    public void addProfessor(String professorId) {

    }

    public void dropProfessor(String professorId){

    }
    public void viewProfessors() {

    }


    // gradecard related services
    public void generateGradeCard(String studentId, String semester){

    }
}


