/**
 * 
 */
package com.flipkart.service;
import java.util.ArrayList;

import com.flipkart.bean.*;
import com.flipkart.data.*;

/**
 * @author ashwin.kumar2
 *
 */
public class SemesterCourseOperation implements SemesterCourseService {
	
	
	TempData td;
	
	public SemesterCourseOperation() {
		td = new TempData();
	}
	
	public ArrayList<Course> viewCourses() {
		// view the list of all the courses
		
		ArrayList<Course> courseList = td.getCourseList();
		
		return courseList;
		

	}
	
	public void addCourses() {
		// add the new course service for the admin
		
	}
	
	public void dropCourses() {
		// drop the particular course
		
	}
	
	public void listStudentsCourses() {
		// list all the students alloted in a particular subject
		
	}
	
	public void viewOptedCourses() {
		// view the registered course by the student
		
	}
	
	
	
	public void submitOptedCourse() {
		// submit the list of opted courses for the student.
		
	}
	

}
