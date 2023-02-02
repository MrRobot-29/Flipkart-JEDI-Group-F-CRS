package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

public interface PaymentService {
	
	public void initiatePayment(double fee, Student st, ArrayList<Course> studentApprovedCourses);
	
	public void payOnline();
	
	public void payOffline();

}
