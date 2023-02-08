package com.flipkart.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.bean.PaymentNotification;
import com.flipkart.bean.Student;
import com.flipkart.helper.DaoHelper;

public class PaymentNotificationDaoImpl implements PaymentNotificationDaoInterface {
	
	Connection conn = null;
	PreparedStatement stmt = null;
	
	@Override
	public PaymentNotification sendFeePaymentNotification(Student s, double billAmount) {
		PaymentNotification pn = null;
		try {
			Connection conn = DaoHelper.getConnection();
			String sql = "SELECT * FROM PAYMENT WHERE STUDENT_ID=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,s.getStudentID());
			ResultSet rs = stmt.executeQuery();
			String modeOfPayment = "";
			String paymentId = "";
			String paymentDesc = "";
			while(rs.next()) {
				modeOfPayment = rs.getString("payment_method");
				paymentId = rs.getString("payment_id");
				paymentDesc = rs.getString("payment_details");
				
			}
			
			pn = new PaymentNotification(s.getStudentID(),s.getName(),billAmount,modeOfPayment,paymentDesc,paymentId);
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
		} 
		
		return pn;
	}

}