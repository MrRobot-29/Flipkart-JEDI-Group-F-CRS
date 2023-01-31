package com.flipkart.bean;

public class PaymentNotification {
	private String studentId;
	private String referenceId;
	private String notificationId;
	private String notificationMessage;
	
	public PaymentNotification(String studentId, String referenceId, String notificationId,
			String notificationMessage) {
		this.studentId = studentId;
		this.referenceId = referenceId;
		this.notificationId = notificationId;
		this.notificationMessage = notificationMessage;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}

	public String getNotificationMessage() {
		return notificationMessage;
	}

	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}
	
}
