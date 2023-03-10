package com.flipkart.data;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.bean.*;
import java.util.*;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;

public class TempData {

    private ArrayList<Course> courseList = new ArrayList<Course>();
    private ArrayList<Course> studentCourseCart = new ArrayList<Course>();
    private ArrayList<Course> studentApprovedCourses = new ArrayList<Course>();
    private ArrayList<Grade> grades = new ArrayList<Grade>();
    
	

	//private Hashtable<Integer, Integer> studentCourseMap = new Hashtable<Integer, Integer>();
    
    private ArrayList<Professor> professor = new ArrayList<Professor>();



    private ArrayList<Student> approvedStudents = new ArrayList<Student>();
	private ArrayList<Student> pendingStudents = new ArrayList<Student>();
	

    

    private ArrayList<Student> students = new ArrayList<Student>();
    private HashMap<Integer,ArrayList<Course>> studentTakenCourses = new HashMap<Integer,ArrayList<Course>>();
    
    
    
    public HashMap<Integer, ArrayList<Course>> getStudentTakenCourses() {
		return studentTakenCourses;
	}


	public void setStudentTakenCourses(HashMap<Integer, ArrayList<Course>> studentTakenCourses) {
		this.studentTakenCourses = studentTakenCourses;
	}


	/**
	 * @return the students
	 */
	public ArrayList<Student> getStudents() {
		return students;
	}


	/**
	 * @param students the students to set
	 */
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}


	/**
	 * @return the approvedStudents
	 */

    public TempData() {
        super();
        for(int i = 0; i < 10; i++) {
            Course c = new Course("Course" + (i+1),"crs-id-"+(i+1),2, true, 100.1, 8);
            courseList.add(c);
        }
        
        for(int i=0; i<100; i++) {
        	Random rd = new Random(); // creating Random object
        	boolean isApproved = rd.nextBoolean();
        	
//        	String studentId, String name, Role role, String password, Gender gender, String address,
//			String country,String branchName,int studentId,int batch,boolean isApproved
        	
        	Student st = new Student("2019" + (i+1), "name" + (i+1), Role.STUDENT, "password", 
        			Gender.MALE, "Lucknow", "India", "ECE", 100+i+1, 2019, isApproved);
        	
        	students.add(st);
        	
        	if(isApproved) {
        		approvedStudents.add(st);
        	}
        	else {
        		pendingStudents.add(st);
        	}
        }
        
        Student st = new Student("201969", "GD", Role.STUDENT, "password", 
    			Gender.MALE, "Lucknow", "India", "ECE", 10001, 2019, true);
        
        students.add(st);
        approvedStudents.add(st);
    }
    
    


	/**
	 * @param approvedStudents the approvedStudents to set
	 */
	public void setApprovedStudents(Student st) {
		
		this.approvedStudents.add(st);
		
	}

	public ArrayList<Student> getApprovedStudents() {
		return approvedStudents;
	}



	/**
	 * @return the pendingStudents
	 */
	public ArrayList<Student> getPendingStudents() {
		return pendingStudents;
	}


	/**
	 * @param pendingStudents the pendingStudents to set
	 */
	
	public void setPendingStudents(ArrayList<Student> pendingStudents) {
		this.pendingStudents = pendingStudents;
	}
	
	public void removePendingStudents(Student st) {
			
		Iterator itr = this.pendingStudents.iterator();
		
		while(itr.hasNext()) {
			Student it = (Student)itr.next();
			if(it == st) {
				itr.remove();
				break;
			}
		}
	}
	
	
	
	public void setStudentCourseMap(int studentId, int courseId) {
//		studentCourseMap.put(courseId);
	
	}
	
	public void getStudentCourseMap(int StudentId) {
//		return 
	}



    public ArrayList<Course> getCourseList() {
        return courseList;
    }


    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Grade> grades) {
        this.grades = grades;
    }



    /**
     * @return the studentCourseCart
     */
    public ArrayList<Course> getStudentCourseCart() {
        return studentCourseCart;
    }




    /**
     * @param studentCourseCart the studentCourseCart to set
     */
    public void setStudentCourseCart(ArrayList<Course> studentCourseCart) {
        this.studentCourseCart = studentCourseCart;
    }




    /**
     * @return the studentApprovedCourses
     */
    public ArrayList<Course> getStudentApprovedCourses() {
        return studentApprovedCourses;
    }




    /**
     * @param studentApprovedCourses the studentApprovedCourses to set
     */
    public void setStudentApprovedCourses(ArrayList<Course> studentApprovedCourses) {
        this.studentApprovedCourses = studentApprovedCourses;
    }




	public ArrayList<Professor> getProfessor() {
		return professor;
	}




	public void setProfessor(ArrayList<Professor> professor) {
		this.professor = professor;
	}

    
    


}