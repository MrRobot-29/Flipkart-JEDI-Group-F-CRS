package com.flipkart.service;

import com.flipkart.bean.Student;

public interface PaymentNotificationService {
	
	/*
	 * @param s: Student object
	 * @param billAmount: bill Amount
	 * 
	 * 
	 */
	public String sendFeePaymentNotification(Student s,double billAmount);
}
