package com.flipkart.dao;

import com.flipkart.bean.PaymentNotification;
import com.flipkart.bean.Student;

public interface PaymentNotificationDaoInterface {
	
	/*
	 * @param s: Student object
	 * @param billAmount: bill Amount
	 * 
	 * 
	 */
	public PaymentNotification sendFeePaymentNotification(Student s,double billAmount);
}
