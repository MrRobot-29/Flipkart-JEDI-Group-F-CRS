package com.flipkart.dao;

import com.flipkart.bean.Student;
import com.flipkart.exception.UserAlreadyExistsException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.exception.WrongPasswordException;

/**
 * Interface for User Dao
 */
public interface UserDAOInterface {

	/**
	 *	Method to Register student in database and get the status of student registration
	 * @param std student object
	 * @return status of student registration from database
	 * @throws UserAlreadyExistsException 
	 */
	public boolean registerAccount(Student std) throws UserAlreadyExistsException;

	/**
	 * Method to edit account in database
	 */
	public void editAccount();

	/**
	 * Method to login using database
	 * @param userName: name of user
	 * @param Password: password of user
	 * @param role: role of user
	 * @throws WrongPasswordException 
	 * @throws UserNotFoundException 
	 */
	public void loginAccount(String userName, String Password, String role) throws UserNotFoundException, WrongPasswordException;

}
