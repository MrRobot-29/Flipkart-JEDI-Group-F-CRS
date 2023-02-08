package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.helper.DaoHelper;

public class PaymentDaoImpl implements PaymentDaoInterface {

	Connection conn = null;
	PreparedStatement stmt = null;
	@Override
	public double calculateBillDue(int studentId,double bill) {
		// TODO Auto-generated method stub
		try {
			conn = DaoHelper.getConnection();
			String sql = SQLQueriesConstants.GET_PAYMENT_COUNT;
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,studentId);
			ResultSet rs = stmt.executeQuery();
			int size = 0;
			while(rs.next()) {
				size = Integer.parseInt(rs.getString("COUNT(*)"));
			}
			if(size>0) bill = 0;
			
		}catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
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
		return bill;
	}

}
