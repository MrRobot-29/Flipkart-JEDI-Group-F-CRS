package com.flipkart.client;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

import com.flipkart.bean.*;
import com.flipkart.service.AdminServiceOperation;

/**
 * Class that display Admin Client Menu
 */
public class AdminCRSMenu {
	Scanner scanner = new Scanner(System.in); 
	AdminServiceOperation aso = new AdminServiceOperation();
	StringBuffer buffer = new StringBuffer();
	Formatter fmt = new Formatter(buffer); 
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLUE = "\u001B[34m";
		
	boolean isLoggedIn = true;

	/**
	 * Method to create admin menu
	 * @param ad: admin object
	 */
	public void createMenu(Admin ad) {
		
		while(isLoggedIn) {
			System.out.println("");
			System.out.println("***********************************");
			System.out.println("************* Admin ***************");
			System.out.println("***********************************");
			System.out.println("Logged in as : " + ad.getName() + "\n");
			System.out.println("1. View course in catalog");
			System.out.println("2. Add Course to catalog");
			System.out.println("3. Delete Course from catalog");
			System.out.println("4. View List of Students");
			System.out.println("5: Aprove Student");
			System.out.println("6. Add Professor");
			System.out.println("7. Drop Professor");
			System.out.println("8. Generate grade cards");
			System.out.println("9. Logout");
			System.out.println("*****************************");
			System.out.println("");
			System.out.println("Enter your choice");
			
			int choice = scanner.nextInt();
			
			switch(choice) {
			case 1:
				/**
				 * view course in catalog
				 */
				ArrayList<Course> cl = aso.viewCourses();
				
				fmt.format("\n%15s %15s %15s %15s\n\n", "Course ID", "Course Name", "Professor", "Course Price");  
				aso.viewCourses().forEach(course -> fmt.format("%14s %14s %14s %14s\n", course.getCourseId(),course.getCourseName(),course.getInstructorId(),course.getCourseFee()));
				System.out.println(fmt);
				buffer.setLength(0);
				break;
				
			case 2:
				/**
				 * add course to catalog
				 */
				if(aso.addCourse()) {
					System.out.println(ANSI_GREEN+"Course Added to the catalog"+ANSI_RESET);	
				}
				else
				{
					System.out.println(ANSI_BLUE+"Course Failed to Add to the catalog"+ANSI_RESET);	
				}
				break;
				
			case 3:
				/**
				 * delete course from catalog
				 */
				if(aso.dropCourse()) {
					System.out.println(ANSI_GREEN+"Course Deleted to the catalog"+ANSI_RESET);	
				}
				else
				{
					System.out.println(ANSI_BLUE+"Course Failed to Delete to the catalog"+ANSI_RESET);	
				}
				break;
				
			case 4:
				/**
				 * view list of student
				 */
				System.out.println("1. List of Approved Students");
				System.out.println("2. List of Non-approved Students");
				System.out.println("3. Go back!!");
				
				
				int cas = scanner.nextInt();
				
				
				switch(cas) {
					case 1:
						
						fmt.format("\n%15s %15s %15s\n\n", "Student ID", "Name", "Branch");  
						aso.viewAllStudents().forEach(student -> fmt.format("%14s %14s %14s\n", student.getStudentID(), student.getName(),student.getBranch()));
						System.out.println(fmt);
						buffer.setLength(0);
						break;
						
					case 2:
						
						fmt.format("\n%15s %15s %15s\n\n", "Student ID", "Name", "Branch");  
						aso.viewPendingStudents().forEach(student -> fmt.format("%14s %14s %14s\n", student.getStudentID(), student.getName(),student.getBranch()));
						System.out.println(fmt);
						buffer.setLength(0);
						
					case 3:
						break;
					
					default:
						System.out.println("Invalid Input");
						break;
				}
				break;
			
			case 5:
				/**
				 * approve student
				 */
				System.out.println("Enter Student ID to approve");
				int stId = scanner.nextInt();
				aso.validateStudent(stId);
				break;
			case 6:
				/**
				 * add professor
				 */
				aso.addProfessor();
				break;
			case 7:
				/**
				 * remove professor
				 */
				aso.dropProfessor();
				break;
			case 8:
				/**
				 * generate grade cards
				 */
				aso.generateGradeCard();
				break;
			case 9:
				/**
				 * logout
				 */
				isLoggedIn = false;
				break;
			
			default:
				System.out.println("Wrong Option");
			}

	}
}
}
