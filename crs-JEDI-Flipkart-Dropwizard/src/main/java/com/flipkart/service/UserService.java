package com.flipkart.service;

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
	public void registerAccount() throws UserAlreadyExistsException;

	/**
	 * method to edit account
	 */
	public void editAccount();

	/**
	 * method for login
	 */
	public void loginAccount() throws UserNotFoundException, WrongPasswordException; 

}
