package com.flipkart.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

public interface StudentDaoInterface {
	
	public int getStudentId(String email);
	public boolean isApproved(int studentId) ;
	public int getCurrentSemester(int studentId);
	public void addStudent(Student student, int semester);
	public int primaryCourseFreq(int student_id);
	public int secondaryCourseFreq(int student_id);
	public boolean addCourseBucket(int student_id, String course_id, int course_type);
	public boolean drop_course(int studentId, String courseId);
	public ArrayList<Course> courseList(int sem);
	public boolean getCourseAvailabilityStatus(String course_id);
	public ArrayList<String> getRegisteredCourseList(int student_id);
	public boolean freezeCourses(int student_id) ;
	public double calculate_total_fee(int student_id);
	public HashMap<String,String> viewGrade(int student_id, int semester);
	public String isGradeReleased(int semester);
}
