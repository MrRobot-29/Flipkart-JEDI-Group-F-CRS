package com.flipkart.bean;

/**
 * class to store payment
 */
public class Payment {
	public int studentID;
	public String referenceID;
	public float paymentAmount;
	public String modeOfPayment;
	public boolean status;

	/**
	 *
	 * @return student id
	 */
	public int getStudentID() {
		return studentID;
	}

	/**
	 * Method to set student id
	 * @param studentID: id of student
	 */
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	/**
	 *
	 * @return reference id of payment
	 */
	public String getReferenceID() {
		return referenceID;
	}

	/**
	 * Method to set reference id
	 * @param referenceID: reference id of payment
	 */
	public void setReferenceID(String referenceID) {
		this.referenceID = referenceID;
	}

	/**
	 *
	 * @return payment amount
	 */
	public float getPaymentAmount() {
		return paymentAmount;
	}

	/**
	 *
	 * @param paymentAmount: payment amount
	 */
	public void setPaymentAmount(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	/**
	 *
	 * @return status of payment
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * Method to set payment status
	 * @param status: status of payment
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 *
	 * @return mode of payment
	 */
	public String getModeOfPayment() {
		return modeOfPayment;
	}

	/**
	 * Method to set mode of payment
	 * @param modeOfPayment: mode of payment
	 */
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	
	
	
}
