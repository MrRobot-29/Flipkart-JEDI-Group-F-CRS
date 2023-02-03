package com.flipkart.service;
        import java.util.ArrayList;
        import java.util.List;

        import com.flipkart.bean.Course;
        import com.flipkart.bean.Grade;
import com.flipkart.data.SharedTempData;
import com.flipkart.data.TempData;

/**
 * @author manish.kumar24
 *
 */
        
public class ProfessorServiceOperation implements ProfessorService {

    static TempData data = SharedTempData.td;
    public  List<String> viewCourseList(String instructorId) {
        // view List of courses taken by professor
        List<String> takenCourses = new ArrayList<String>();

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

    public boolean addGrade(String courseId, int studentId, String grade) {
        Grade newgrade = new Grade(courseId, studentId, grade);
        data.getGrades().add(newgrade);
        return true;
    }

}
