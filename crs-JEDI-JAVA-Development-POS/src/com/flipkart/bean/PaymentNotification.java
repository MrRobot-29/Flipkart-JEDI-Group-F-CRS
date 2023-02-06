package com.flipkart.bean;

/**
 * Class for payment notification
 */
public class PaymentNotification {
	private String studentId;
	private String referenceId;
	private String notificationId;
	private String notificationMessage;

	/**
	 * Constructor
	 * @param studentId: student id
	 * @param referenceId: id of payment reference
	 * @param notificationId: notification id of payment
	 * @param notificationMessage: notification message of payment
	 */
	public PaymentNotification(String studentId, String referenceId, String notificationId,
			String notificationMessage) {
		this.studentId = studentId;
		this.referenceId = referenceId;
		this.notificationId = notificationId;
		this.notificationMessage = notificationMessage;
	}

	/**
	 *
	 * @return student id
	 */
	public String getStudentId() {
		return studentId;
	}

	/**
	 *
	 * @param studentId: student id
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	/**
	 *
	 * @return reference id of payment
	 */
	public String getReferenceId() {
		return referenceId;
	}

	/**
	 * Method to set reference id
	 * @param referenceId: reference id of payment
	 */
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	/**
	 *
	 * @return get notification id of payment
	 */
	public String getNotificationId() {
		return notificationId;
	}

	/**
	 *
	 * @param notificationId: notification id
	 */
	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}

	/**
	 *
	 * @return get notification message of payment
	 */
	public String getNotificationMessage() {
		return notificationMessage;
	}

	/**
	 * method to set notification message of payment
	 * @param notificationMessage: notification message of payment
	 */
	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}
	
}
