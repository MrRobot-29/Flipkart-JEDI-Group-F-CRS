package com.flipkart.service;

import com.flipkart.bean.Student;

public interface PaymentService {
	
	public void initiatePayment(double fee, Student st);
	
	public void payOnline();
	
	public void payOffline();

}
