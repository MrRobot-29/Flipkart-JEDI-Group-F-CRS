package com.flipkart.client;
import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.*;
import com.flipkart.service.AdminServiceOperation;
import com.flipkart.data.*;

public class AdminCRSMenu {
	Scanner scanner = new Scanner(System.in); 
	AdminServiceOperation aso = new AdminServiceOperation();
	
	
		
	boolean isLoggedIn = true;
	public void createMenu(String user) {
		
		while(isLoggedIn) {
			System.out.println("***********************************");
			System.out.println("********* Admin *******************");
			System.out.println("***********************************");
			System.out.println("Login as : " + user + "\n");
			System.out.println("1. View course in catalog");
			System.out.println("2. Add Course to catalog");
			System.out.println("3. Delete Course from catalog");
			System.out.println("4. View List of Students");
			System.out.println("5: Aprove Student");
			System.out.println("6. Add Professor");
			System.out.println("7. Logout");
			System.out.println("*****************************");
			
			int choice = scanner.nextInt();
			
			switch(choice) {
			case 1:
	
				ArrayList<Course> cl = aso.viewCourses();
				int num = 1;
				for(var c: cl) {
					System.out.println(num);
					System.out.println("Course Name: " + c.getCourseName());
					System.out.println("Course ID: " + c.getCourseId());
					num++;
				}
				
				System.out.println("viewCoursesInCatalogue()");
				
	

				
				System.out.println("viewCoursesInCatalogue()");
				

				break;
				
			case 2:
				if(aso.addCourse()) {
					System.out.println("Course Added to the catalog");	
				}
				break;
				
			case 3:
				if(aso.dropCourse()) {
				    System.out.println("Course Dropped Successfully from the catalog");	
			    }
				break;
				
			case 4:
				System.out.println("1. List of Approved Students");
				System.out.println("2. List of Non-approved Students");
				System.out.println("3. Go back!!");
				
				
				int cas = scanner.nextInt();
				
				
				switch(cas) {
					case 1:
						ArrayList<Student> st = aso.viewAllStudents();
						
						for(Student at : st) {
							System.out.println("Student Id: " + at.getStudentID() + "\nName: " + 
									at.getName() + "\nBranch: " + at.getBranch());
							System.out.println("");
						}
						break;
						
					case 2:
						ArrayList<Student> st1 = aso.viewPendingStudents();
						
						for(Student at : st1) {
							System.out.println("Student Id: " + at.getStudentID() + "\nName" + 
									at.getName() + "\nBranch: " + at.getBranch());
						}
						break;
						
					case 3:
						break;
					
					default:
						System.out.println("Invalid Input");
						break;
				}
				
	//			System.out.println("approveStudent()");
				break;
			
			case 5:
				System.out.println("Enter Student ID to approve");
				int stId = scanner.nextInt();
				
				aso.validateStudent(stId);
				
			case 6:
				System.out.println("addProfessor()");
				break;
			
			case 7:
				isLoggedIn = false;
				break;
			
			default:
				System.out.println("Wrong Option");
			}
		}
	}
}
