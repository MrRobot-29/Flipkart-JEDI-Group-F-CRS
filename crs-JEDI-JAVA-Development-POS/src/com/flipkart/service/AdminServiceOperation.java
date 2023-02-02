package com.flipkart.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
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


