package com.flipkart.bean;

public class Course {
	private String courseName;
	private String courseId;
	private int instructorId;
	private Double courseFee;
	private boolean isCourseAvailable;
	private int semester;
	

	public Course(String courseName, String courseId, int instructorId, boolean isCourseAvailable, Double fee, int semester) {
		this.courseName = courseName;
		this.courseId = courseId;
		this.instructorId = instructorId;
		this.isCourseAvailable = isCourseAvailable;
		this.courseFee = fee;
		this.semester = semester;
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

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
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

	/**
	 * @return the semester
	 */
	public int getSemester() {
		return semester;
	}

	/**
	 * @param semester the semester to set
	 */
	public void setSemester(int semester) {
		this.semester = semester;
	}

}
