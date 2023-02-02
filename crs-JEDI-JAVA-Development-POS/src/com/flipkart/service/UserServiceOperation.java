/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Student;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.data.SharedTempData;
import com.flipkart.data.TempData;

/**
 * @author ashwin.kumar2
 *
 */
public class UserServiceOperation implements UserService{
	TempData td = SharedTempData.td;
	public void registerAccount() {
		// register student account
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student's ID (Int)");
		int sid = sc.nextInt();
		System.out.println("Enter Student's Name");
		String sname = sc.next();
		System.out.println("Enter Student Branch");
		String sbranch = sc.next();
		System.out.println("Enter Student's Address");
		String sadd = sc.next();
		System.out.println("Enter Student's Gender (M/F/O)");
		String sgend = sc.next();
		System.out.println("Enter Account Passoword");
		String pwd = sc.next();
		
		Student std  = new Student("User98989", sname, Role.STUDENT, pwd, Gender.MALE, sadd, sadd, sbranch, sid, 2019, false);
		ArrayList<Student> pending = td.getPendingStudents();
		ArrayList<Student> allStudent = td.getStudents();
		
		pending.add(std);
		allStudent.add(std);
		
		td.setPendingStudents(pending);
		td.setStudents(allStudent);
		
		
		System.out.println("Student registration complete. Approval request sent to admin");
		
	}
	
	public void editAccount() {
		// edit student account
		
	}
	
	public void loginAccount() {
		// login to the account
	
	}

}
