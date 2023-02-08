package com.flipkart.bean;

/**
 * Class for payment notification
 */
public class PaymentNotification {
	private int studentId;
	private String studentName;
	private double billAmount;
	private String modeOfPayment;
	private String paymentDetails;
	private String paymentId;
	
	public PaymentNotification(int studentId, String studentName, double billAmount, String modeOfPayment,
			String paymentDetails, String paymentId) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.billAmount = billAmount;
		this.modeOfPayment = modeOfPayment;
		this.paymentDetails = paymentDetails;
		this.paymentId = paymentId;
	}

	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public double getBillAmount() {
		return billAmount;
	}
	
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	
	public String getPaymentDetails() {
		return paymentDetails;
	}
	public void setPaymentDetails(String paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	
	public String getPaymentId() {
		return paymentId;
	}
	
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	
}
