/**
 * 
 */
package com.flipkart.service;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

/**
 * @author shivam.agrawal1
 *
 */
public class PaymentServiceOperation implements PaymentService {
	
	Scanner sc = new Scanner(System.in);
	Console cnsl= System.console();
	
	public void initiatePayment(double fee, Student st, ArrayList<Course> studentApprovedCourses) {
		
		System.out.println("Initiating payment..");
		System.out.println();
		System.out.println("****** Bill *******");
		System.out.println("Name of Student :" + st.getName());
		System.out.println("Student ID : "+st.getStudentID());
		System.out.println("Opted Courses:");
		for(Course course : studentApprovedCourses) {
			System.out.println(course.getCourseName() + ": Rs."+ course.getCourseFee());
		}
		System.out.println("************");
		System.out.println("Total Bill : "+ fee);
		
		System.out.println("Select mode of payment");
		System.out.println("1-Online");
		System.out.println("2-Offline");
		int option = sc.nextInt();
		switch(option) {
		case 1:
			payOnline();
			break;
		
		case 2:
			payOffline();
			break;
			
		default:
			System.out.println("Invalid input");
			break;
		}
		
	}
	
	
	public void payOnline() {
		// payment for the online mode
		System.out.println("You opted for Online payment");
		System.out.println("1-UPI");
		System.out.println("2-Debit Card");
		System.out.println("3-Credit Card");
		int option = sc.nextInt();
		switch(option) {
		case 1:
			System.out.println("UPI payment opted");
			System.out.println("Enter upi ID");
			String upiID = sc.nextLine();
			System.out.println("Bill requested on upi ID "+ upiID);
			break;
		
		case 2:
			System.out.println("Enter name on Debit Card: ");
			String name = sc.nextLine();
			System.out.println("Enter Debit Card Number: ");
			String cardNum = sc.nextLine();
			System.out.println("Enter CVV");
			char[] cvv = cnsl.readPassword();
			System.out.println("Payment requested");
			break;
			
		case 3 : 
			System.out.println("Enter name on Credit Card: ");
			name = sc.nextLine();
			System.out.println("Enter Credit Card Number: ");
			cardNum = sc.nextLine();
			System.out.println("Enter CVV");
			cvv = cnsl.readPassword();
			System.out.println("Payment requested");
			break;
			
		default:
			System.out.println("Invalid input");
			break;
		}
		System.out.println("Contact admin for fee payment approval");
		
	}
	
	public void payOffline() {
		// payment for the offline mode
		System.out.println("Offline payment requested. Contact admin for fee payment approval");
	}

}
