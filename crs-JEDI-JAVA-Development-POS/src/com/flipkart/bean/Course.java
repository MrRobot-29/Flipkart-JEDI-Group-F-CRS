package com.flipkart.bean;

public class Course {
	private String courseName;
	private String courseId;
	private String instructorId;
	private Double courseFee;
	private boolean isCourseAvailable;
	
	

	public Course(String courseName, String courseId, String instructorId, boolean isCourseAvailable, Double fee) {
		this.courseName = courseName;
		this.courseId = courseId;
		this.instructorId = instructorId;
		this.isCourseAvailable = isCourseAvailable;
		this.courseFee = fee;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}

	public boolean isCourseAvailable() {
		return isCourseAvailable;
	}

	public void setCourseAvailable(boolean isCourseAvailable) {
		this.isCourseAvailable = isCourseAvailable;
	}
	
	public Double getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(Double courseFee) {
		this.courseFee = courseFee;
	}

}
