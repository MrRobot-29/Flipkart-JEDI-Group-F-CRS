package com.flipkart.data;

        import java.util.ArrayList;

        import com.flipkart.bean.Course;
        import com.flipkart.bean.Grade;

public class TempData {

    private ArrayList<Course> courseList = new ArrayList<Course>();
    private ArrayList<Course> studentCourseCart = new ArrayList<Course>();
    private ArrayList<Course> studentApprovedCourses = new ArrayList<Course>();

    private ArrayList<Grade> grades = new ArrayList<Grade>();


    public TempData() {
        super();
        for(int i = 0; i < 100; i++) {
            Course c = new Course("Course" + (i+1),"crs-id-"+(i+1),"ins-"+(i+1), true, 100.1);
            courseList.add(c);
        }

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


}