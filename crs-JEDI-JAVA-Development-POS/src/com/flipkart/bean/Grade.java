package com.flipkart.bean;

public class Grade {
	private String courseId;
	private String studentId;
	private String grade;
	
	public Grade(String courseId, String studentId, String grade) {
		this.courseId = courseId;
		this.studentId = studentId;
		this.grade = grade;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
