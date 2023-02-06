/**
 * 
 */
package com.flipkart.bean;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

/**
 * @author gaurav.dash
 *
 */
public class Student extends User {
	private int studentID;
	private String branch;
	private boolean isApproved;
	private int semester;

	/**
	 * @return the semester
	 */
	

	public Student(String userId, String name, Role role, String password, Gender gender, String address,
			String country,String branchName,int studentId,int semester, boolean isApproved) {
		super(userId, name, role, password, gender, address, country);
		this.branch = branchName;
		this.studentID = studentId;
		this.isApproved = isApproved;
		this.semester = semester;
	}
	
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
	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	// methods start
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
