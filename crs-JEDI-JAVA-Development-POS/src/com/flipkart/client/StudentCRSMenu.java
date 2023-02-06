package com.flipkart.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.service.StudentService;
import com.flipkart.service.StudentServiceOperation;

public class StudentCRSMenu {
	static boolean isLoggedIn = true;
	public void createMenu(Student std)
	{
		Scanner sc = new Scanner(System.in);
		StudentService sso = new StudentServiceOperation();
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
				System.out.println(std.getSemester());
				ArrayList<Course> cl = sso.courseList(std.getSemester());
				int num = 1;
				for(var c: cl) {
					System.out.println(num);
					System.out.println("Course Name: " + c.getCourseName());
					System.out.println("Course ID: " + c.getCourseId());
					num++;
				}
				
				break;
			case 2:
				int primaryCnt = sso.primaryCourseFreq(std.getStudentID()), secCnt = sso.secondaryCourseFreq(std.getStudentID());
				System.out.println(primaryCnt);
				if(primaryCnt == 4 && secCnt == 2)
				{
					System.out.println("You have already selected all the required primary and secondary course !!");
					System.out.println("Please Drop Course");
					break;
				}
				while(true)
				{
					System.out.println("Enter Course-Id: (0 to go back)");
					String courseId = sc.next();
					if(courseId.equalsIgnoreCase("0"))
						break;
					if(!sso.getCourseAvailabilityStatus(courseId))
					{
						System.out.println("Course Unavailable!!");
						break;
					}
					System.out.println("Enter Course Type: ");
					System.out.println("0 for Primary and 1 for Secondary");
					int type = sc.nextInt();
					if(type == 0 && primaryCnt == 4)
					{
						System.out.println("You have already filled all the slot for primary courses");
						break;
					}
					if(type == 1 && primaryCnt == 2)
					{
						System.out.println("You have already filled all the slot for secondary courses");
						break;
					}
					boolean status = sso.addCourse(std.getStudentID(), courseId, type);
					if(status)
						System.out.println("Course Added Successfully");
					else
						System.out.println("Operation Failed !!");
				}
				
				break;
			case 3:
				System.out.println("Enter Course ID to drop");
				String cid1 = sc.next();
				sso.dropCourse(cid1);
				break;
			case 4:
//				ArrayList<Course> cl2 = sso.viewSelectedCourses();
//				int num2 = 1;
//				for(var c: cl2) {
//					System.out.println(num2);
//					System.out.println("Course Name: " + c.getCourseName());
//					System.out.println("Course ID: " + c.getCourseId());
//					num2++;
//				}
//				System.out.println("Proceed for registration");
//				System.out.println("1. Yes");
//				System.out.println("2. Go back");
//				int sel = sc.nextInt();
//				if(sel == 1) {
//					sso.registerCourses();
//					System.out.println("Courses Registered Successfully. Proceed to pay fee");
//				}
				break;
			case 5:
//				ArrayList<Course> cl1 = sso.approvedList();
//				int num1 = 1;
//				for(var c: cl1) {
//					System.out.println(num1);
//					System.out.println("Course Name: " + c.getCourseName());
//					System.out.println("Course ID: " + c.getCourseId());
//					num1++;
//				}
//				break;
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
