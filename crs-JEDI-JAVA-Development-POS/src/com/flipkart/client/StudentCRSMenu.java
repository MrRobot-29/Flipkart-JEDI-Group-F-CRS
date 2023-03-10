package com.flipkart.client;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constant.Color;
import com.flipkart.exception.CourseAlreadyOptedException;
import com.flipkart.exception.CourseCountExceededException;
import com.flipkart.exception.CourseNotAvailableException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.CourseNotOptedException;
import com.flipkart.exception.GradeNotAllotedException;
import com.flipkart.exception.NoCourseFoundException;
import com.flipkart.exception.PaymentNotCompletedException;
import com.flipkart.service.StudentService;
import com.flipkart.service.StudentServiceOperation;

public class StudentCRSMenu {
	static boolean isLoggedIn = true;
	public void createMenu(Student std)
	{
		Scanner sc = new Scanner(System.in);
		StudentService sso = new StudentServiceOperation();
		StringBuffer buffer = new StringBuffer();
		Formatter fmt = new Formatter(buffer);  
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
				ArrayList<Course> cl;
				try {
					cl = sso.courseList(std.getSemester());
					if(cl.size() == 0) {
						System.out.println("No courses to show for " + std.getSemester() + " semester");
					}else {
						fmt.format("\n%15s %15s %15s\n\n", "Course ID", "Course Name", "Professor");  
						cl.forEach(course -> fmt.format("%14s %14s %14s\n", course.getCourseId(),course.getCourseName(),course.getInstructorId()));
						System.out.println(fmt);
					}
				} catch (NoCourseFoundException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				
				if(!sso.add_drop_status(std.getStudentID())) {
					System.out.println("Course Status Frezzed. Could not add more courses!!!!");
					break;
				}
				
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
					sc.nextLine();
					String courseId = sc.nextLine();
					if(courseId.equalsIgnoreCase("0"))
						break;
					
					System.out.println("Enter Course Type: ");
					System.out.println("0 for Primary and 1 for Secondary");
					int type = sc.nextInt();
//					if(type == 0 && primaryCnt == 4)
//					{
//						System.out.println("You have already filled all the slot for primary courses");
//						continue;
//					}
//					if(type == 1 && primaryCnt == 2)
//					{
//						System.out.println("You have already filled all the slot for secondary courses");
//						continue;
//					}
					boolean status;
					try {
						status = sso.addCourse(std.getStudentID(), courseId, type);
						if(status)
							System.out.println("Course Added Successfully");
						else
							System.out.println("Operation Failed !!");
						
					} catch (CourseAlreadyOptedException | CourseCountExceededException | CourseNotAvailableException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					
				}
				break;
			case 3:
				
				if(!sso.add_drop_status(std.getStudentID())) {
					System.out.println("Course Status Frezzed. Could not drop the current course");
					break;
				}
				
				System.out.println("Enter Course ID to drop");
				sc.nextLine();
				String courseId = sc.nextLine();
				boolean status;
				try {
					status = sso.dropCourse(std.getStudentID(),courseId);
					if(status)
						System.out.println(Color.ANSI_GREEN+"Course Dropped Successfully"+Color.ANSI_RESET);
				} catch (CourseNotOptedException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
				break;
			case 4:
				try {
					status = sso.freezeCourseCart(std.getStudentID());
					if(status)
						System.out.println("Course Cart Freezed Successfully");
					else
						System.out.println("Operation Failed! Please make sure you have selected 4 primary and 2 secondary courses");
				} catch (CourseNotAvailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			case 5:
				ArrayList<String> selectedCourse;
				try {
					System.out.println("\nSelected Courses:\n");
					sso.viewSelectedCourses(std.getStudentID()).forEach(courseName -> System.out.println(courseName+" "));
				} catch (NoCourseFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			case 6:
				try {
					sso.payFee(std);
				} catch (PaymentNotCompletedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 7:
				HashMap<String, String> grades;
				try {
					grades = sso.viewGrade(std.getStudentID(), std.getSemester());
					if(grades == null)
					{
						System.out.println("Grade Card Awaited!! Contact Admin");
						break;
					}
					buffer.setLength(0);
					fmt.format("\n%15s %15s\n\n", "Course Name", "Grade");  
					grades.forEach((courseName,grade) -> fmt.format("%14s %14s\n", courseName,grade));
					System.out.println(fmt);
				} catch (GradeNotAllotedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
