package com.flipkart.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.service.StudentServiceOperation;

public class StudentCRSMenu {
	static boolean isLoggedIn = true;
	public void createMenu(String user)
	{
		Scanner sc = new Scanner(System.in);
		StudentServiceOperation sso = new StudentServiceOperation();
		while(isLoggedIn == true)
		{
			System.out.println("Login as : " + user + "\n");
			System.out.println("Welcome to Student Menu !!");
			System.out.println("1. View available Course List");
			System.out.println("2. Add Course");
			System.out.println("3. Drop Course");
			System.out.println("4. View registered Course");
			System.out.println("5. Pay Fee");
			System.out.println("6. View Grade Card");
			System.out.println("7. Log Out");
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
				System.out.println("Enter Course ID to add");
				String cid = sc.next();
				if(sso.addCourse(cid)) {
				   System.out.println("Course added successfully");	
				}else {
				   System.out.println("Course not added");	
				}
				break;
			case 3:
				System.out.println("Enter Course ID to drop");
				String cid1 = sc.next();
				sso.dropCourse(cid1);
				break;
			case 4:
				ArrayList<Course> cl1 = sso.approvedList();
				int num1 = 1;
				for(var c: cl1) {
					System.out.println(num1);
					System.out.println("Course Name: " + c.getCourseName());
					System.out.println("Course ID: " + c.getCourseId());
					num1++;
				}
				break;
			case 5:
				
				break;
			case 6:
				break;
			case 7:
				isLoggedIn = false;
				break;
			default:
				System.out.println("Invalid Choice!! Try Again");
			}
			
		}
		isLoggedIn = true;
		
	}

}
