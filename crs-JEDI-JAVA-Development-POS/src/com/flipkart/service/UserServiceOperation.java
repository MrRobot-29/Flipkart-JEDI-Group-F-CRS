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
	public void registerAccount() throws UserAlreadyExistsException{
		// register student account
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student's email");
		String email = sc.next();
		System.out.println("Enter Student's ID (Integer)");
		int sid = sc.nextInt();
		System.out.println("Enter Student's Name");
		String sname = sc.next();
		System.out.println("Enter Student Branch");
		String sbranch = sc.next();

		System.out.println("Choose your Current semester : ");
		for(int i = 1;i <= 8;i++) {
			System.out.println("Semster " + i );
		}

		int sem = sc.nextInt();
		System.out.println("Enter Account Password");
		String pwd = sc.next();
		
		Student std  = new Student(email, sname, Role.STUDENT, pwd, Gender.MALE, "India", "India", sbranch, sid, sem, false);
		
		UserDAOImpl uDao = new UserDAOImpl();
		
		StudentDaoInterface uDaao = new StudentDaoImpl();
		
		
		
		try {
			if(uDao.registerAccount(std)) {
				System.out.println(Color.ANSI_GREEN + "Student registration complete. Approval request sent to admin" + Color.ANSI_RESET);	
			}else {
				System.out.println(Color.ANSI_YELLOW + "Student cannot be registered. Please try again!" + Color.ANSI_RESET);
			}
		} catch (UserAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
		
			
	}
	
	public void editAccount() {
		// edit student account
		
	}
	
	public void loginAccount() throws UserNotFoundException, WrongPasswordException{
		// login to the account
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user email : ");
		String userName = sc.next();
		System.out.println("Enter Password : ");
		String password = sc.next();
		System.out.println("Enter Role : ");
		String role = sc.next();

		UserDAOImpl uDao = new UserDAOImpl();
		try {
			uDao.loginAccount(userName, password, role);
		} catch (UserNotFoundException | WrongPasswordException e) {
			throw e;
		}
	}

}
