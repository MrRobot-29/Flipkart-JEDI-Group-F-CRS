package com.flipkart.bean;


import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

public class Admin extends User{
	
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
