package com.flipkart.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Professor;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.GradeAlreadyAddedException;
import com.flipkart.exception.NoCourseFoundException;
import com.flipkart.exception.NoStudentFoundException;
import com.flipkart.service.ProfessorService;
import com.flipkart.service.ProfessorServiceOperation;

/**
 * Class that display Professor Client Menu
 */
public class ProfessorCRSMenu {
	
	ProfessorService service = new ProfessorServiceOperation();
	boolean isLogin = true,status;
	Scanner sc = new Scanner(System.in);
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLUE = "\u001B[34m";


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
				try {
					System.out.println("Course Taken: \n");
					service.viewCourseList(p.getProfId()).forEach(course -> System.out.println(course));
				} catch (NoCourseFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				/**
				 * view all the enrolled students for the course
				 */
				System.out.println("Enter Course Id: ");
				sc.nextLine();
				String courseId = sc.nextLine();
				try {
					
					System.out.println("Enrolled Students: ");
					service.viewEnrolledStudents(p.getProfId(), courseId).forEach(student -> System.out.println(student));
					
				} catch (NoStudentFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
				
				ArrayList<String> grades = new ArrayList<>(Arrays.asList("A","A-","B","B-","C","C-","D","D-","E","E-","F","F-"));
		    	boolean aGrade = false;
		    	String grade = null;
		    	while(!aGrade)
		    	{
		    		System.out.println("Enter Grade: ");
		    		grade = sc.next();
		    		aGrade = grades.contains(grade);
		    		if(!aGrade)System.out.println("Invalid Grade ");
		    	}
		    					
				
				try {
					status = service.addGrade(courseId, studentId, grade);
					if(status)
						System.out.println(ANSI_GREEN+"Grade Assigned"+ANSI_RESET);
					else
						System.out.println(ANSI_BLUE+"Operation Unsuccessful"+ANSI_RESET);
				} catch (GradeAlreadyAddedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				break;
			case 4:
				/**
				 * select course for professor to teach
				 */
				System.out.println("Enter Course Id: ");
				sc.nextLine();
				courseId = sc.nextLine();
				try {
					status = service.selectCourseToTeach(courseId,p.getProfId());
					if(status)
						System.out.println(ANSI_GREEN+"Course Selected"+ANSI_RESET);
					else
						System.out.println(ANSI_BLUE+"Operation Unsuccessfull!! Please Try Again"+ANSI_RESET);
				} catch (CourseNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
