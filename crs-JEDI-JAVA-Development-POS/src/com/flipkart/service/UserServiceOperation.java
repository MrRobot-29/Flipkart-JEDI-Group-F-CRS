/**
 * 
 */
package com.flipkart.service;

import java.util.Scanner;

import com.flipkart.dao.*;

import com.flipkart.bean.Student;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.dao.UserDAOImpl;
import com.flipkart.data.SharedTempData;
import com.flipkart.data.TempData;

/**
 * @author ashwin.kumar2
 * Implementation of user service operation
 */
public class UserServiceOperation implements UserService{
	TempData td = SharedTempData.td;
	public void registerAccount() {
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
//		System.out.println("Enter Student's current semester (1-8)");

		int sem = sc.nextInt();
		System.out.println("Enter Account Password");
		String pwd = sc.next();
		
		Student std  = new Student(email, sname, Role.STUDENT, pwd, Gender.MALE, "India", "India", sbranch, sid, sem, false);
		
		UserDAOImpl uDao = new UserDAOImpl();
		
		StudentDaoInterface uDaao = new StudentDaoImpl();
		
//		if(uDaao.addStudent(std, sem)){
//			System.out.println("Student registration complete. Approval request sent to admin");	
//		}
//		else {
//			System.out.println("Student cannot be registered. Please try again!");
//		}
		
		
		if(uDao.registerAccount(std)) {
			System.out.println("Student registration complete. Approval request sent to admin");	
		}else {
			System.out.println("Student cannot be registered. Please try again!");
		}
		
		
	}
	
	public void editAccount() {
		// edit student account
		
	}
	
	public void loginAccount() {
		// login to the account
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user email : ");
		String userName = sc.next();
		System.out.println("Enter Password : ");
		String password = sc.next();
		System.out.println("Enter Role : ");
		String role = sc.next();

		UserDAOImpl uDao = new UserDAOImpl();
		uDao.loginAccount(userName, password, role);
		
	}

}
