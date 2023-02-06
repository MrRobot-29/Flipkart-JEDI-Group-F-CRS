package com.flipkart.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.service.ProfessorService;
import com.flipkart.service.ProfessorServiceOperation;

public class ProfessorCRSMenu {
	
	
	ProfessorService service = new ProfessorServiceOperation();
	boolean isLogin = true;
	public void createMenu(Professor p) {
		
		System.out.println("Login as : " + p.getName() + "\n");
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
				int instructorId = sc.nextInt();
				List<String> takenCourses = service.viewCourseList(instructorId);
				for(String course: takenCourses)
					System.out.println(course);
				break;
			case 2:
				System.out.println("Enter Instructor Id: ");
				instructorId = sc.nextInt();
				System.out.println("Enter Course Id: ");
				sc.nextLine();
				String courseId = sc.nextLine();
				List<String> enrolledStudents = service.viewEnrolledStudents(instructorId, courseId);
				for(String student: enrolledStudents)
					System.out.println(student);
				break;
			case 3:
				System.out.println("Enter Course Id: ");
				sc.nextLine();
				courseId = sc.nextLine();
				System.out.println("Enter Student Id(Int): ");
				int studentId = sc.nextInt();
				System.out.println("Enter Grade: ");
				String grade = sc.next();
				boolean status = service.addGrade(courseId, studentId, grade);
				if(status)
					System.out.println("Grade Assigned");
				else
					System.out.println("Operation Unsuccessful");
				break;
			case 4:
				System.out.println("Enter Course Id: ");
				sc.nextLine();
				courseId = sc.nextLine();
				System.out.println("Enter Instructor Id: ");
				instructorId = sc.nextInt();
				service.selectCourseToTeach(courseId,instructorId);
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
