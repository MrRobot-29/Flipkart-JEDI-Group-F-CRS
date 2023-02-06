package com.flipkart.client;

import java.util.ArrayList;
import java.util.HashMap;
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
				String courseId = sc.next();
				boolean status = sso.dropCourse(std.getStudentID(),courseId);
				if(status)
					System.out.println("Course Dropped Successfully");
				break;
			case 4:
				status = sso.freezeCourseCart(std.getStudentID());
				if(status)
					System.out.println("Course Cart Freezed Successfully");
				else
					System.out.println("Operation Failed! Please make sure you have selected 4 primary and 2 secondary courses");
				break;
			case 5:
				ArrayList<String> selectedCourse = sso.viewSelectedCourses(std.getStudentID());
				for(String finalcourse: selectedCourse)
				{
					System.out.println(finalcourse);
				}
				break;
			case 6:
				sso.payFee(std);
				break;
			case 7:
				HashMap<String,String> grades = sso.viewGrade(std.getStudentID(), std.getSemester());
				if(grades == null)
				{
					System.out.println("Grade Card Awaited!! Contact Admin");
					break;
				}
				for(String course: grades.keySet()) {
					System.out.print("Course Name - " + course);
					System.out.println(" : Course Grade - " + grades.get(course));
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
