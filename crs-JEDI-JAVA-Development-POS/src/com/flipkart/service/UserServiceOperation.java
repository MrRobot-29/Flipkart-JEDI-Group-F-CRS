/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Student;
import com.flipkart.client.AdminCRSMenu;
import com.flipkart.client.ProfessorCRSMenu;
import com.flipkart.client.StudentCRSMenu;
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
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user name(Student ID for student) : ");
		String userName = sc.next();
		System.out.println("Enter Password : ");
		String password = sc.next();
		System.out.println("Enter Role : ");
		String role = sc.next();
		if(role.equals("professor")) {
			ProfessorCRSMenu professorMenu = new ProfessorCRSMenu();
			professorMenu.createMenu(userName);
		}
		else if(role.equals("student")) {
			StudentCRSMenu studentMenu = new StudentCRSMenu();
			
			int StudentId = Integer.parseInt(userName);
			
			ArrayList<Student> approvedStudents = td.getApprovedStudents();
			ArrayList<Student> allStudents = td.getStudents();
			boolean found = false;
			
			for(int i = 0; i < allStudents.size(); i++) {
				if(allStudents.get(i).getStudentID() == StudentId) {
					found = true;
					break;
				}
			}
			
			if(!found) {
				System.out.println("Account does not exist. Kindly register first");
				return;
			}
			
			found = false; 
			
			for(int i = 0; i < approvedStudents.size(); i++) {
				if(approvedStudents.get(i).getStudentID() == StudentId) {
					found = true;
					break;
				}
			}
			
			if(found)
				studentMenu.createMenu(userName);
			else {
				System.out.println("Account is not approved yet! Check with admin");
			}
		}
		else if(role.equals("admin")) {
			AdminCRSMenu adminMenu = new AdminCRSMenu();
			adminMenu.createMenu(userName);
		}
		else
		{
			System.out.println("Invalid Role!!");
		}
	
	}

}
