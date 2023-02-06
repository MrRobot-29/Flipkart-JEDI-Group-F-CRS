package com.flipkart.bean;


import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

/**
 * Admin Class
 */
public class Admin extends User{

	/**
	 *
	 * @param userId: user id
	 * @param name: name of user
	 * @param role: role of user
	 * @param password: password of user
	 * @param gender: gender of user
	 * @param address: address of user
	 * @param country: country of user
	 */
	public Admin(String userId, String name, Role role, String password, Gender gender, String address,
			String country) {
		super(userId, name, role, password, gender, address, country);
	}
	
	public void approveStudent() {
		
	}
	

	public void addProfessor() {
		
	}
	
	public void addAdmin() {
		
	}
	
	public void generateReportCard() {
		
	}
	public void modifyCourseCatlogue() {
		
	}
}
