/**
 * 
 */
package com.flipkart.service;

import java.util.Scanner;

import com.flipkart.dao.*;

import com.flipkart.bean.Student;
import com.flipkart.constant.Color;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.dao.UserDAOImpl;
import com.flipkart.exception.UserAlreadyExistsException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.exception.WrongPasswordException;

/**
 * @author ashwin.kumar2
 * Implementation of user service operation
 */
public class UserServiceOperation implements UserService{
	public void registerAccount(Student student) throws UserAlreadyExistsException{
		// register student account
		UserDAOImpl uDao = new UserDAOImpl();
		try {
			if(!uDao.registerAccount(student)) {
				throw new UserAlreadyExistsException(student.getUserId());
			}
		} catch (UserAlreadyExistsException e) {
			throw e;
		}
	}
	
	public void editAccount() {
		// edit student account
		
	}
	
	public boolean loginAccount(String Username, String password, String role) throws UserNotFoundException, WrongPasswordException{
		// login to the account
		UserDAOImpl uDao = new UserDAOImpl();
		try {
			return uDao.loginAccount(Username, password, role);
		} catch (UserNotFoundException | WrongPasswordException e) {
			throw e;
		}
	}

}
