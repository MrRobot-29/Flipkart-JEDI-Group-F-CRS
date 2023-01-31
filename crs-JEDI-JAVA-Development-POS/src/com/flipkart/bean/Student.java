/**
 * 
 */
package com.flipkart.bean;

/**
 * @author gaurav.dash
 *
 */
public class Student {
	private int studentID;
	private String branch;
	
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public void viewGrade() {
		System.out.println("Student Grade");
	}
	public void register() {
		System.out.println("Register student for courses");
	}
	public void payFee() {
		System.out.println("Student pay fee");
	}
	
}
