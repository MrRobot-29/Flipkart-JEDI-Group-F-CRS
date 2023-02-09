package com.flipkart.service;

import com.flipkart.bean.PaymentNotification;
import com.flipkart.bean.Student;
import com.flipkart.dao.PaymentNotificationDaoImpl;

public class PaymentNotificationServiceOperation implements PaymentNotificationService {

	@Override
	public PaymentNotification sendFeePaymentNotification(Student s, double billAmount) {
		// TODO Auto-generated method stub

		String result = "";

		PaymentNotificationDaoImpl pndi = new PaymentNotificationDaoImpl();
		PaymentNotification pn = pndi.sendFeePaymentNotification(s, billAmount);
		return pn;
	}

}
