package com.flipkart.client;
import java.util.Scanner;

public class AdminCRSMenu {
	Scanner scanner = new Scanner(System.in); 
	
	public void createMenu(String user) {
		
		
		System.out.println("***********************************");
		System.out.println("********* Admin *******************");
		System.out.println("***********************************");
		System.out.println("Login as : " + user + "\n");
		System.out.println("1. View course in catalog");
		System.out.println("2. Add Course to catalog");
		System.out.println("3. Delete Course from catalog");
		System.out.println("4. Approve Students");
		System.out.println("5. Add Professor");
		System.out.println("6. Assign Courses To Professor");
		System.out.println("7. Logout");
		System.out.println("*****************************");
		
		int choice = scanner.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println("viewCoursesInCatalogue()");
			break;
			
		case 2:
			System.out.println("addCourseToCatalogue()");
			break;
			
		case 3:
			System.out.println("deleteCourse()");
			break;
			
		case 4:
			System.out.println("approveStudent()");
			break;
		

		
		case 5:
			System.out.println("addProfessor()");
			break;
		
		case 6:
			System.out.println("assignCourseToProfessor()");
			break;
		
		default:
			System.out.println("Wrong Option");
		}
		
	}
}
