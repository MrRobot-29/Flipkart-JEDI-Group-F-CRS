package com.flipkart.dao;

import java.util.ArrayList;

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
	public boolean drop_course(Student student, Course course);
	public ArrayList<Course> courseList(int sem);
	public boolean getCourseAvailabilityStatus(String course_id);
	public ArrayList<String> getRegisteredCourseList(Student student);
}
