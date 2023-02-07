/**
 * 
 */
package com.flipkart.service;

import java.io.Console;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.dao.StudentDaoInterface;

/**
 * @author shivam.agrawal1
 *
 */
public class PaymentServiceOperation implements PaymentService {
	
	Scanner sc = new Scanner(System.in);
	StudentDaoInterface studentDao = new StudentDaoImpl();
	
	public void initiatePayment(double fee, Student st, ArrayList<String> studentApprovedCourses) {
		
		System.out.println("Initiating payment..");
		System.out.println();
		System.out.println("****** Bill *******");
		System.out.println("Name of Student :" + st.getName());
		System.out.println("Student ID : "+st.getStudentID());
		System.out.println("Opted Courses:");
		for(String course : studentApprovedCourses) {
			System.out.print(course+" ");
		}
		System.out.println();
		System.out.println("************");
		System.out.println("Total Bill : "+ fee);
		
		System.out.println("Select mode of payment");
		System.out.println("1-Online");
		System.out.println("2-Offline");
		int option = sc.nextInt();
		switch(option) {
		case 1:
			payOnline(st,fee);
			break;
		
		case 2:
			payOffline(st,fee);
			break;
			
		default:
			System.out.println("Invalid Input!! Payment Failed");
			break;
		}
		
	}
	
	
	public void payOnline(Student std,double fee) {
		// payment for the online mode
		System.out.println("You opted for Online payment");
		System.out.println("1-UPI");
		System.out.println("2-Debit Card");
		System.out.println("3-Credit Card");
		int option = sc.nextInt();
		String method = "Online";
		Random rand = new Random();
		String trans_id = Integer.toString(rand.nextInt(10000000));
		boolean status;
		switch(option) {
		case 1:
			System.out.println("UPI payment opted");
			System.out.println("Enter upi ID");
			sc.nextLine();
			String upiID = sc.nextLine();
			status = studentDao.payFee(std.getStudentID(), trans_id, method, "Rs. "+Double.toString(fee)+" paid by UPI");
			if(status)
				System.out.println("Bill requested on upi ID "+ upiID);
			else
				System.out.println("Payment Failed");
			break;
		
		case 2:
			System.out.println("Enter name on Debit Card: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Enter Debit Card Number: ");
			sc.nextLine();
			String cardNum = sc.nextLine();
			System.out.println("Enter CVV");
			sc.nextLine();
			String cvv = sc.nextLine();
			status = studentDao.payFee(std.getStudentID(), trans_id, method, "Rs. "+Double.toString(fee)+" paid by Debit Card");
			if(status)
				System.out.println("Payment Requested");
			else
				System.out.println("Payment Failed");
			break;
			
		case 3 : 
			System.out.println("Enter name on Credit Card: ");
			name = sc.nextLine();
			System.out.println("Enter Credit Card Number: ");
			cardNum = sc.nextLine();
			System.out.println("Enter CVV");
			cvv = sc.nextLine();
			status = studentDao.payFee(std.getStudentID(), trans_id, method, "Rs. "+Double.toString(fee)+" paid by Credit Card");
			if(status)
				System.out.println("Payment Requested");
			else
				System.out.println("Payment Failed");
			break;
			
		default:
			System.out.println("Invalid input");
			break;
		}
		System.out.println("Contact admin for fee payment approval");
		
	}
	
	public void payOffline(Student std, double fee) {
		// payment for the offline mode
		String method = "Offline";
		Random rand = new Random();
		String trans_id = Integer.toString(rand.nextInt(10000000));
		System.out.println("Offline payment requested. Contact admin for fee payment approval");
		boolean status = studentDao.payFee(std.getStudentID(), trans_id, method, "Rs. "+Double.toString(fee)+" paid by Cash/Cheque");
		if(status)
			System.out.println("Payment Requested");
		else
			System.out.println("Payment Failed");
	}

}
