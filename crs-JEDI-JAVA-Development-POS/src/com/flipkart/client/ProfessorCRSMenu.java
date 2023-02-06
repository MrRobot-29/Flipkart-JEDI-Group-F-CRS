package com.flipkart.client;

import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Professor;
import com.flipkart.service.ProfessorService;
import com.flipkart.service.ProfessorServiceOperation;

/**
 * Class that display Professor Client Menu
 */
public class ProfessorCRSMenu {
	
	ProfessorService service = new ProfessorServiceOperation();
	boolean isLogin = true;
	Scanner sc = new Scanner(System.in);


	/**
	 * Method to create Professor menu
	 * @param p: professor object obtained after logging into the system
	 * returns displays all the options for the professor, and provides navigation
	 */
	public void createMenu(Professor p) {
		
		System.out.println("Login as : " + p.getName() + "\n");
		
		// To show menu till Professor logs out
		while(isLogin) {
			
			// Menu
			System.out.println("Enter your choise : ");
			System.out.println("1. view Course");
			System.out.println("2. View Enrolled Student");
			System.out.println("3. Add Grade");
			System.out.println("4. Select course to teach");
			System.out.println("5. log out");
			
			
			//Input to take menu choice
			int selectedOption = sc.nextInt();

			switch(selectedOption)
			{
			case 1:
				/**
				 * view all the courses taught by the professor
				 */
				List<String> takenCourses = service.viewCourseList(p.getProfId());
				for(String course: takenCourses)
					System.out.println(course);
				break;
			case 2:
				/**
				 * view all the enrolled students for the course
				 */
				System.out.println("Enter Course Id: ");
				sc.nextLine();
				String courseId = sc.nextLine();
				List<String> enrolledStudents = service.viewEnrolledStudents(p.getProfId(), courseId);
				for(String student: enrolledStudents)
					System.out.println(student);
				break;
			case 3:
				/**
				 * add grade for a student
				 */
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
				/**
				 * select course for professor to teach
				 */
				System.out.println("Enter Course Id: ");
				sc.nextLine();
				courseId = sc.nextLine();
				service.selectCourseToTeach(courseId,p.getProfId());
				break;
			case 5:
				/**
				 * logout from the system
				 */
				isLogin = false;
				break;
			default:
				break;
						
				
			}
		}
		isLogin = true;
		
	}

}
