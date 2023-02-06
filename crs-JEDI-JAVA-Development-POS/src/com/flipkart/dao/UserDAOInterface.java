package com.flipkart.dao;

import com.flipkart.bean.Student;

/**
 * Interface for User Dao
 */
public interface UserDAOInterface {

	/**
	 *	Method to Register student in database and get the status of student registration
	 * @param std student object
	 * @return status of student registration from database
	 */
	public boolean registerAccount(Student std);

	/**
	 * Method to edit account in database
	 */
	public void editAccount();

	/**
	 * Method to login using database
	 * @param userName: name of user
	 * @param Password: password of user
	 * @param role: role of user
	 */
	public void loginAccount(String userName, String Password, String role);

}
