package com.flipkart.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoHelper {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/crs_db";

	   //  Database credentials
	static final String USER = "root";
	static final String PASS = "Gd@21051971";
	
	private static Connection connection = null;
	
	
	public static Connection getConnection() {
		connection = connectToDB();
		return connection;
	}
	
	static Connection connectToDB() {
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
		return connection;
		
		
		   
	}

}
