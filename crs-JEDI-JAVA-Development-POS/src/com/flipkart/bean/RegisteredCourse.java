package com.flipkart.bean;

public class RegisteredCourse extends Course{

	private String courseCode;
	private String semester;
	private int studentId;
	private String gradesObtained;
	
	
	
	
	public RegisteredCourse(String courseName, String courseId, String instructorId, boolean isCourseAvailable, 
			String courseCode, String semester, int studentId, String gradesObtained, double fee) {
		super(courseName, courseId, instructorId, isCourseAvailable, fee);
		this.courseCode = courseCode;
		this.semester = semester;
		this.studentId = studentId;
		this.gradesObtained = gradesObtained;
		
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getGradesObtained() {
		return gradesObtained;
	}
	public void setGradesObtained(String gradesObtained) {
		this.gradesObtained = gradesObtained;
	}

	
	
	public void viewGrade() {
		System.out.println("View grade");
	}
	public void dropCourse() {
		System.out.println("Drop Course");		
	}

}
