package com.flipkart.bean;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

import javax.validation.constraints.NotNull;

public class Professor extends User {
	@NotNull
	private int profId;
	@NotNull
	private String department;
	private String designation;

	/**
	 *
	 * Constructor
	 * @param userId: id of user
	 * @param name: name of the professor
	 * @param role: role of the professor
	 * @param password: password the of professor
	 * @param gender: gender of the professor
	 * @param address: address of the professor
	 * @param country: country of the professor
	 * @param department: department of the professor
	 * @param designation: designation of the professor
	 * @param profId: id of the professor
	 */
	
	public Professor() {
		super();
	}

	
	public Professor(String userId, String name, Role role, String password, Gender gender, String address,
			String country, String department, String designation, int profId) {
		super(userId, name, role, password, gender, address, country);
		this.profId = profId;
		this.department = department;
		this.designation = designation;
	}

	/**
	 *
	 * @return: get id of the professor
	 */
	public int getProfId() {
		return profId;
	}

	/**
	 *
	 * @param profId: id of the professor
	 */
	public void setProfId(int profId) {
		this.profId = profId;
	}

	/**
	 *
	 * @return: get department of the professor
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 *
	 * @param department: department of the professor
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 *
	 * @return: get the designation of professor
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 *
	 * @param designation: designation of the professor
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
