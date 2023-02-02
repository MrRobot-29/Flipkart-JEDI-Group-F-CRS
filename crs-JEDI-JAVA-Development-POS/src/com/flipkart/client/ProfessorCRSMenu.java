package com.flipkart.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.service.ProfessorService;
import com.flipkart.service.ProfessorServiceOperation;

public class ProfessorCRSMenu {
	
	
	ProfessorService service = new ProfessorServiceOperation();
	boolean isLogin = true;
	public void createMenu(String user) {
		
		System.out.println("Login as : " + user + "\n");
		while(isLogin) {
			
			
			System.out.println("Enter your choise : ");
			System.out.println("1. view Course");
			System.out.println("2. View Enrolled Student");
			System.out.println("3. Add Grade");
			System.out.println("4. Select course to teach");
			System.out.println("5. log out");
			
			Scanner sc = new Scanner(System.in);
			
			int selectedOption = sc.nextInt();

			switch(selectedOption)
			{
			case 1:
				System.out.println("Enter Instructor Id: ");
				String instructorId = sc.next();
				List<String> takenCourses = service.viewCourseList("ins-"+instructorId);
				for(String course: takenCourses)
					System.out.println(course);
				break;
			case 2:
				break;
			case 3:
				System.out.println("Enter Course Id: ");
				String courseId = sc.next();
				System.out.println("Enter Student Id: ");
				String studentId = sc.next();
				System.out.println("Enter Grade: ");
				String grade = sc.next();
				boolean status = service.addGrade("crs-id-"+courseId, studentId, grade);
				if(status)
					System.out.println("Grade Assigned");
				else
					System.out.println("Operation Unsuccessful");
				break;
			case 4:
				System.out.println("Enter Course Id: ");
				courseId = sc.next();
				System.out.println("Enter Instructor Id: ");
				instructorId = sc.next();
				status = service.selectCourseToTeach("crs-id-"+courseId,"ins-"+instructorId);
				if(status)
					System.out.println("Successfully Assigned");
				else
					System.out.println("Operation Unsuccessful");
				break;
			case 5:
				isLogin = false;
				break;
			default:
				break;
						
				
			}
		}
		isLogin = true;
		
	}

}
