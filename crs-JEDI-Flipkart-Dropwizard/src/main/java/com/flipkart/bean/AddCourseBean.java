package com.flipkart.bean;

public class AddCourseBean {

    private Integer student_id;

    private String courseId;
    private Integer course_type;




    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getCourse_type() {
        return course_type;
    }

    public void setCourse_type(Integer course_type) {
        this.course_type = course_type;
    }



}
