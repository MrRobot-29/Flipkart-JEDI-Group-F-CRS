/**
 * 
 */
package com.flipkart.bean;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

/**
 * @author gaurav.dash
 * Student Class
 */
public class Student extends User {
	private int studentID;
	private String branch;
	private boolean isApproved;
	private int semester;

	/**
	 *
	 * @param userId: user id
	 * @param name: username
	 * @param role: role of user
	 * @param password: password of user
	 * @param gender: gender of user
	 * @param address: address of user
	 * @param country: country of user
	 * @param branchName: branch of student
	 * @param studentId: id of student
	 * @param semester: semester of student
	 * @param isApproved: is approved by admin
	 */
	public Student(String userId, String name, Role role, String password, Gender gender, String address,
			String country,String branchName,int studentId,int semester, boolean isApproved) {
		super(userId, name, role, password, gender, address, country);
		this.branch = branchName;
		this.studentID = studentId;
		this.isApproved = isApproved;
		this.semester = semester;
	}

	/**
	 *
	 * @return student id
	 */
	public int getStudentID() {
		return studentID;
	}

	/**
	 * method to set student id
	 * @param studentID: student id
	 */
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	/**
	 *
	 * @return branch of student
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * method to set branch of student
	 * @param branch: branch of student
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}

	/**
	 *
	 * @return status of student approval
	 */
	public boolean isApproved() {
		return isApproved;
	}

	/**
	 * method to set status of student approval
	 * @param isApproved: status of student approval
	 */
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	/**
	 *
	 * @return semester of student
	 */
	public int getSemester() {
		return semester;
	}

	/**
	 * method to set student semester
	 * @param semester: student semester
	 */
	public void setSemester(int semester) {
		this.semester = semester;
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
