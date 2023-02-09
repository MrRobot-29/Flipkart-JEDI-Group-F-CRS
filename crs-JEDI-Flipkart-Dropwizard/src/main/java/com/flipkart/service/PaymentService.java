package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.PaymentNotCompletedException;

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
	public void initiatePayment(double fee, Student st, ArrayList<String> studentApprovedCourses) throws PaymentNotCompletedException;

	/**
	 * Method to pay online
	 * @param std : Student object
	 * @param fee : total fee
	 */
	public boolean payOnline(Student std, double fee) throws PaymentNotCompletedException;

	/**
	 * Method to pay offline
	 * @return 
	 */
	public boolean payOffline(Student std, double fee) throws PaymentNotCompletedException;

}
