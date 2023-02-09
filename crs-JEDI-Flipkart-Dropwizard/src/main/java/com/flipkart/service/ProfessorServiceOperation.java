package com.flipkart.service;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.ProfessorDaoImpl;

import com.flipkart.data.SharedTempData;
import com.flipkart.data.TempData;


/**
 * @author manish.kumar24
 * class to implement professor service operation
 */
        
public class ProfessorServiceOperation implements ProfessorService {

    static TempData data = SharedTempData.td;
    ProfessorDaoImpl pdi = new ProfessorDaoImpl();
    
    public  List<Course> viewCourseList(int instructorId) {
        // view List of courses taken by professor
        List<Course> takenCourses = pdi.viewCourseList(instructorId);
        return takenCourses;
    }

    public boolean selectCourseToTeach(String courseId, int instructorId)
    {

        return pdi.selectCourseToTeach(courseId, instructorId);
    }

	public List<Student> viewEnrolledStudents(int instructorId, String courseId) {
        // view List of professor enrolled in professor's courses
    	return pdi.viewEnrolledStudents(instructorId, courseId);

    }

    public boolean addGrade(String courseId, int studentId, String grade) {
        pdi.addGrade(courseId, studentId, grade);
        return true;
    }

}
