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

    static TempData data = new TempData();
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

    public boolean addGrade(String courseId, String studentId, String grade) {
        Grade newgrade = new Grade(studentId,courseId,grade);
        data.getGrades().add(newgrade);
        System.out.print(data.getGrades().get(0).getGrade());
        return true;
    }

    public static void main(String args[])
    {
        ProfessorService chk = new ProfessorServiceOperation();
        boolean assign = chk.addGrade("crs-id-1","1234","A");
        for(Grade grade: data.getGrades())
            System.out.println(grade.getCourseId());
    }

}
