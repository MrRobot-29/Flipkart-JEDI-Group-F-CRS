package com.flipkart.dao;

public interface PaymentDaoInterface {
	
	/*
	 * Function to calculate Bill due 
	 * @param studentId : student ID
	 * @param fee : Fee for the semester
	 * @returns Due bill 
	 */
	public double calculateBillDue(int studentId,double bill);
}
