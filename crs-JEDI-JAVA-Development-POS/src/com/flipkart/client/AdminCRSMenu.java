package com.flipkart.client;
import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.service.AdminServiceOperation;

public class AdminCRSMenu {
	Scanner scanner = new Scanner(System.in); 
	AdminServiceOperation aso = new AdminServiceOperation();
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
		System.out.println("6. Logout");
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
			System.out.println("approveStudent()");
			break;
		

		
		case 5:
			aso.addProfessor();
			break;
		

		
		default:
			System.out.println("Wrong Option");
		}
		
	}
}
