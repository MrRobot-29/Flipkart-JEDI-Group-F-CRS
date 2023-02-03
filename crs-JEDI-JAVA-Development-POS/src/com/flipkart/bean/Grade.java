package com.flipkart.bean;

public class Grade {
	private String courseId;
	private int studentId;
	private String grade;
	
	public Grade(String courseId, int studentId, String grade) {
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

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
