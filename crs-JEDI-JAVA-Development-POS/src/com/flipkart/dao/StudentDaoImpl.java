/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.*;

import java.sql.ResultSet;

import com.flipkart.bean.*;

import com.flipkart.utils.DBUtils;

import com.flipkart.constant.*;

/**
 * @author ashwin.kumar2
 *
 */
public class StudentDaoImpl {
	
	
	DBUtils DBUtils;
  
    public StudentDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		DBUtils = new DBUtils();
	}



	public int getStudentId(String email) {
    	
    	
    	Connection connection=DBUtils.getConnection();
    	
		try {
			
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_STUDENT_ID);
			
			statement.setString(1, email);
			
			ResultSet rs = statement.executeQuery();
			
			System.out.println(statement);
			
			if(rs.next())
			{
				return rs.getInt("student_id");
			}
				
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return -1;    // Student does not exists 
		
    }
    
	
	
    public boolean isApproved(int studentId) {
    	
    	
		Connection connection=DBUtils.getConnection();
		
		try {
			
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.IS_APPROVED);
			
			statement.setInt(1, studentId);
			
			ResultSet rs = statement.executeQuery();
			
			if(rs.next())
			{
				return rs.getBoolean("approval_status");
			}
				
		}
		catch(SQLException e)
		{
			System.out.checkError();
		}
		
		return false;
	}
    
    
    public int getSemester(int studentId) {
    	
		Connection connection=DBUtils.getConnection();
		
		try {
			
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_CURR_SEM);
			
			statement.setInt(1, studentId);
			
			ResultSet rs = statement.executeQuery();
			
			if(rs.next())
			{
				return rs.getInt("semester");
			}
				
		}
		catch(SQLException e)
		{
			System.out.checkError();
		}
		
		return -1;
    }
    

    
    public void addStudent(String email, String name, String branch, String semester, String password, Student student) {
    	
    	Connection conn = DBUtils.getConnection();
    	
    	try {
    		PreparedStatement statement = conn.prepareStatement(SQLQueriesConstants.ADD_STUDENT);
			statement.setString(1, student.getUserId());
			statement.setString(2, student.getName());
			statement.setString(3, student.getPassword());
			
			statement.executeQuery();
			
			
			PreparedStatement get_last_id = conn.prepareStatement(SQLQueriesConstants.ADD_STUDENT);
			
			int var = 1;   // last student id + 1
			
			
			PreparedStatement statement2 = conn.prepareStatement(SQLQueriesConstants.ADD_STUDENT_ID);
			statement2.setInt(1, var);
			statement2.setString(2, student.getUserId());
			statement2.setString(3, student.getBranch());
			statement2.setString(4, semester);	
    	}catch(SQLException err) {
    		System.out.println(err.getMessage());
    	}
    	
    	
    	
    }
    
}
