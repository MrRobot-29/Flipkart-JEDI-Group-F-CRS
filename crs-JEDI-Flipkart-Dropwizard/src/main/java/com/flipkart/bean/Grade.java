package com.flipkart.bean;

/**
 * Class to store grade
 */
public class Grade {
	private String courseId;
	private int studentId;
	private String grade;

	/**
	 * Constructor
	 * @param courseId: course id
	 * @param studentId: student id
	 * @param grade: grade
	 */
	public Grade(String courseId, int studentId, String grade) {
		this.courseId = courseId;
		this.studentId = studentId;
		this.grade = grade;
	}

	/**
	 *
	 * @return the course id
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 * Method to set course id
	 * @param courseId: course id
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/**
	 *
	 * @return student id
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * Method to set student id
	 * @param studentId: student id
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 *
	 * @return grade of student
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * Method to set grade of student
	 * @param grade: grade of student
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
