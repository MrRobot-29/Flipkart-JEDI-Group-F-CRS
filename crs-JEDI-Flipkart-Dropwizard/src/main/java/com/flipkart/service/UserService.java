package com.flipkart.service;

import com.flipkart.bean.Student;
import com.flipkart.exception.UserAlreadyExistsException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.exception.WrongPasswordException;

/**
 * Interface for user service operation
 */
public interface UserService {

	/**
	 * method to register account
	 */
	public void registerAccount(Student student) throws UserAlreadyExistsException;

	/**
	 * method to edit account
	 */
	public void editAccount();

	/**
	 * method for login
	 */
	public boolean loginAccount(String Username, String password, String role) throws UserNotFoundException, WrongPasswordException;

}
