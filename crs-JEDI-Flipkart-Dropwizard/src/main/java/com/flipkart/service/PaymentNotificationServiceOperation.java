package com.flipkart.service;

import com.flipkart.bean.PaymentNotification;
import com.flipkart.bean.Student;
import com.flipkart.dao.PaymentNotificationDaoImpl;

public class PaymentNotificationServiceOperation implements PaymentNotificationService {

	@Override
	public String sendFeePaymentNotification(Student s, double billAmount) {
		// TODO Auto-generated method stub

		String result = "";

		PaymentNotificationDaoImpl pndi = new PaymentNotificationDaoImpl();
		PaymentNotification pn = pndi.sendFeePaymentNotification(s, billAmount);
		System.out.println("Payment Successful");
		System.out.println("Generating Payment info");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%14s %14s %14s %21s %28s %14s", "Student Id", "Student Name", "Bill Amount", "Mode of Payment", "Payment Details", "Payment Id");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		return pn.getStudentId() + " " + pn.getStudentName() + " " +pn.getBillAmount() + " " +pn.getModeOfPayment() + " " +pn.getPaymentDetails() +" " + pn.getPaymentId();
	}

}
