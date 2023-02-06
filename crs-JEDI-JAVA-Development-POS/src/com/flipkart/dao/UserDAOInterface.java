package com.flipkart.dao;

import com.flipkart.bean.Student;

public interface UserDAOInterface {
	
	public boolean registerAccount(Student std);
	
	public void editAccount();
	
	public void loginAccount(String userName, String Password, String role);

}
