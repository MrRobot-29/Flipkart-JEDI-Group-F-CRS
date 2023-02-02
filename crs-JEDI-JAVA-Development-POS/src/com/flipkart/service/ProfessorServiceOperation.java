/**
 * 
 */
package com.flipkart.service;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.data.TempData;

/**
 * @author manish.kumar24
 *
 */
public class ProfessorServiceOperation implements ProfessorService {
	
	public  List<String> viewCourseList(String instructorId) {
		// view List of courses taken by professor
		List<String> takenCourses = new ArrayList<String>();
		TempData data = new TempData();
		
		for(Course course: data.getCourseList())
		{
			if(course.getInstructorId().equalsIgnoreCase(instructorId)) {
				takenCourses.add(course.getCourseName());
			}
		}
		return takenCourses;
		
	}
	
	public boolean selectCourseToTeach(String courseId, String instructorId)
	{
		TempData data = new TempData();
		
		List<Course> courseList = data.getCourseList();
		
		for(Course course: courseList)
		{
			if(course.getCourseId().equalsIgnoreCase(courseId)) {
				course.setInstructorId(instructorId);
				return true;
			}
		}
		return false;
	}
	
	public void viewEnrolledStudents() {
		// view List of professor enrolled in professor's courses
		
	}
	
	public boolean addGrade(String courseId, String studentId, String grade) {
		Grade newgrade = new Grade(studentId,courseId,grade);
		//TODO: Add newgrade to an ArrayList
		return true;
	}
	
//	public static void main(String args[])
//	{
//		ProfessorService chk = new ProfessorServiceOperation();
//		boolean assign = chk.selectCourseToTeach("crs-id-1","123");
//		System.out.println(assign);
//	}

}
