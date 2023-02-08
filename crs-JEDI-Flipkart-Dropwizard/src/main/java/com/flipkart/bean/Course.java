package com.flipkart.bean;

/**
 * Class to store course information
 */
public class Course {
	private String courseName;
	private String courseId;
	private int instructorId;
	private Double courseFee;
	private boolean isCourseAvailable;
	private int semester;


	/**
	 *
	 * @param courseName: name of the course
	 * @param courseId: course id
	 * @param instructorId: instructor id
	 * @param isCourseAvailable: course availability
	 * @param fee: fee for the course
	 * @param semester: semester of the course
	 */
	public Course(String courseName, String courseId, int instructorId, boolean isCourseAvailable, Double fee, int semester) {
		this.courseName = courseName;
		this.courseId = courseId;
		this.instructorId = instructorId;
		this.isCourseAvailable = isCourseAvailable;
		this.courseFee = fee;
		this.semester = semester;
	}

	/**
	 *
	 * @return course name
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * method to set course name
	 * @param courseName: course name
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 *
	 * @return returns the course id
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 *
	 * @param courseId: course id
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/**
	 *
	 * @return returns the instructor id
	 */
	public int getInstructorId() {
		return instructorId;
	}

	/**
	 *
	 * @param instructorId: instructor id
	 */
	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	/**
	 *
	 * @return returns if course is available or not
	 */
	public boolean isCourseAvailable() {
		return isCourseAvailable;
	}

	/**
	 * Method to set course availability
	 * @param isCourseAvailable: course availability
	 */
	public void setCourseAvailable(boolean isCourseAvailable) {
		this.isCourseAvailable = isCourseAvailable;
	}

	/**
	 *
	 * @return returns the fee of current course
	 */
	public Double getCourseFee() {
		return courseFee;
	}

	/**
	 *
	 * @param courseFee: fee for the current course
	 */
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
	 * @param semester: semester for the course
	 */
	public void setSemester(int semester) {
		this.semester = semester;
	}

}
