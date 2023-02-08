package com.flipkart.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * helper class for Dao
 */
public class DaoHelper {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/crs_db";

	   //  Database credentials
	static final String USER = "root";

	static final String PASS = "root@123";
	
	private static Connection connection = null;

	//Singleton Class

	/**
	 * Singleton Class
	 */
	private DaoHelper() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL,USER,PASS);
		}catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }
	}
	
	public static Connection getConnection() {
		if(connection==null) {
			new DaoHelper();
		}
		return connection;
	}
	

}
