/**
 * 
 */
package com.flipkart.utils;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author ashwin.kumar2
 *	Database utility class
 */
public class DBUtils {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/crs_db";

    //  Database credentials
    static final String USER = "root";

    static final String PASS = "root186828";

	
	public Connection getConnection() {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 
		    // Step 4 make/open  a connection 
		   
	        System.out.println("Connecting to database...");
	        
	        conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        
	        return conn;
		      
		}catch(SQLException se){
		      //Handle errors for JDBC
			
			System.out.println(se.getMessage());
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
//		      try{
//		         if(stmt!=null)
//		            stmt.close();
//		      }catch(SQLException se2){
//		      }// nothing we can do
//		      try{
//		         if(conn!=null)
//		            conn.close();
//		      }catch(SQLException se){
//		         se.printStackTrace();
//		      }//end finally try
		   }//end try
		
		   System.out.println("Goodbye!");
		   
		return conn;
	}

}
