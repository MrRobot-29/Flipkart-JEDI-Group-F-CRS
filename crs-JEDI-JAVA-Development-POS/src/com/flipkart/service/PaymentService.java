package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

/**
 * Interface for Payment Service Operation
 */
public interface PaymentService {

	/**
	 * Method to initiate payment
	 * @param fee: fee for payment
	 * @param st: student object
	 * @param studentApprovedCourses: list of approved course of student
	 */
	public void initiatePayment(double fee, Student st, ArrayList<String> studentApprovedCourses);

	/**
	 * Method to pay online
	 */
	public void payOnline(Student std, double fee);

	/**
	 * Method to pay offline
	 */
	public void payOffline(Student std, double fee);

}
