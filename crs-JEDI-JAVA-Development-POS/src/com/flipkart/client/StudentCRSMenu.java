package com.flipkart.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.service.StudentServiceOperation;

public class StudentCRSMenu {
	static boolean isLoggedIn = true;
	public void createMenu(Student std)
	{
		Scanner sc = new Scanner(System.in);
		StudentServiceOperation sso = new StudentServiceOperation();
		while(isLoggedIn == true)
		{
			System.out.println("Logged in as : " + std.getName() + "\n");
			System.out.println("Welcome to Student Menu !!");
			System.out.println("1. View available Course List");
			System.out.println("2. Add Course to course Cart");
			System.out.println("3. Drop Course from course Cart");
			System.out.println("4. View and Freeze Course Cart");
			System.out.println("5. View registered Course");
			System.out.println("6. Pay Fee");
			System.out.println("7. View Grade Card");
			System.out.println("8. Log Out");
			System.out.println("Enter Your Choice: ");
			
			int selectedOption = sc.nextInt();
			
			switch(selectedOption)
			{
			case 1:
				ArrayList<Course> cl = sso.courseList();
				int num = 1;
				for(var c: cl) {
					System.out.println(num);
					System.out.println("Course Name: " + c.getCourseName());
					System.out.println("Course ID: " + c.getCourseId());
					num++;
				}
				
				break;
			case 2:
				int numberOfCoursesToAdd = 6-sso.viewSelectedCourses().size();
				
				if(numberOfCoursesToAdd == 0) {
					System.out.println("You have already seleceted 6 courses");
				}else {
					System.out.println("Enter "+ numberOfCoursesToAdd +" Course IDs to add");
					while( numberOfCoursesToAdd != 0) {
						String cid = sc.next();
						if(sso.addCourse(cid)) {
						   System.out.println("Course added successfully");	
						}else {
						   System.out.println("Course not added");	
						}
						numberOfCoursesToAdd = 6-sso.viewSelectedCourses().size();
					}
				}
				
				
				
				break;
			case 3:
				System.out.println("Enter Course ID to drop");
				String cid1 = sc.next();
				sso.dropCourse(cid1);
				break;
			case 4:
				ArrayList<Course> cl2 = sso.viewSelectedCourses();
				int num2 = 1;
				for(var c: cl2) {
					System.out.println(num2);
					System.out.println("Course Name: " + c.getCourseName());
					System.out.println("Course ID: " + c.getCourseId());
					num2++;
				}
				System.out.println("Proceed for registration");
				System.out.println("1. Yes");
				System.out.println("2. Go back");
				int sel = sc.nextInt();
				if(sel == 1) {
					sso.registerCourses();
					System.out.println("Courses Registered Successfully. Proceed to pay fee");
				}
				break;
			case 5:
				ArrayList<Course> cl1 = sso.approvedList();
				int num1 = 1;
				for(var c: cl1) {
					System.out.println(num1);
					System.out.println("Course Name: " + c.getCourseName());
					System.out.println("Course ID: " + c.getCourseId());
					num1++;
				}
				break;
			case 6:
				
				sso.payFee(std.getName());
				break;
			case 7:
				ArrayList<ArrayList<String>>  grades = sso.viewGrade(10001);
				for(var c: grades) {
					System.out.print("Course Name - " + c.get(0));
					System.out.println(": Course Grade - " + c.get(1));
				}
				break;
			case 8:
				isLoggedIn = false;
				break;
			default:
				System.out.println("Invalid Choice!! Try Again");
			}
			
		}
		isLoggedIn = true;
		
	}

}
