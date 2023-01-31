/**
 * 
 */
package com.flipkart.bean;

import java.time.LocalDate;

/**
 * @author gaurav.dash
 *
 */
public class SemesterRegistration {
  
	private int studentId;
	private String semester;
	private LocalDate dateOfRegistration;
	
	
	
	public SemesterRegistration(int studentId, String semester, LocalDate dateOfRegistration) {
		this.studentId = studentId;
		this.semester = semester;
		this.dateOfRegistration = dateOfRegistration;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public LocalDate getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(LocalDate dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public void registerCourses() {
		
	}
	
    public void addCourses() {
		
	}
    public void dropCourses() {
		
	}
    public void payFee() {
    	
    }
    public void viewRegisteredCourses() {
    	
    }
}
