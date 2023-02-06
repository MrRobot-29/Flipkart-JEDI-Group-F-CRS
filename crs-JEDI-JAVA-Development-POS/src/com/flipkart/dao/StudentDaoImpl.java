/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

import java.sql.ResultSet;

import com.flipkart.bean.*;

import com.flipkart.utils.DBUtils;

import com.flipkart.constant.*;

/**
 * @author ashwin.kumar2
 *
 */
public class StudentDaoImpl implements StudentDaoInterface{
	
	
	DBUtils DBUtils;
  
    public StudentDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		DBUtils = new DBUtils();
	}
    
    
    
    
    public boolean freezeCourses(int student_id) {
    	
    	Connection conn = DBUtils.getConnection();
    	
    	int cnt_primary = primaryCourseFreq(student_id);
    	
    	if(cnt_primary!=4) {
    		return false;
    	}
    	
    	try {
    		PreparedStatement statement = conn.prepareStatement(SQLQueriesConstants.FREEZE_COURSES);
    		
    		statement.setInt(1, student_id);
    		
    		statement.executeUpdate();
    		
    		return true;
    		
    	}catch(SQLException err) {
    		System.out.println(err.getMessage());
    	}
    	
    	return false;
    }
    
    
    public int primaryCourseFreq(int student_id) {
    	
    	Connection conn = DBUtils.getConnection();

    	int cnt = 0;
    	
    	try {
	    	PreparedStatement statement = conn.prepareStatement(SQLQueriesConstants.PRIMARY_COURSE_FREQ);
			
			statement.setInt(1, student_id);
			
			ResultSet rs = statement.executeQuery();
			
			cnt = rs.getInt("COUNT(course_id)");
			
    	}catch(SQLException err) {
    		System.out.println(err.getMessage());
    	}
    	return cnt;
    }
    
    public int secondaryCourseFreq(int student_id) {
    	
    	Connection conn = DBUtils.getConnection();

    	int cnt = 0;
    	
    	try {
	    	PreparedStatement statement = conn.prepareStatement(SQLQueriesConstants.SECONDARY_COURSE_FREQ);
			
			statement.setInt(1, student_id);
			
			ResultSet rs = statement.executeQuery();
			
			cnt = rs.getInt("COUNT(course_id)");
			
			
			
    	}catch(SQLException err) {
    		System.out.println(err.getMessage());
    	}
    	return cnt;
    }


    
    public boolean addCourseBucket(int student_id, String course_id, int course_type) {
    	
    	Connection conn = DBUtils.getConnection();
    	

    	
    	try {
    			int cnt = 0;
    			if(course_type == 0) {
    				cnt = primaryCourseFreq(student_id);
    				
    				if(cnt>=4) {
    					return false;
    				}
    			}
    			else if(course_type == 1) {
    				cnt = secondaryCourseFreq(student_id);
    				
    				if(cnt>=2) {
    					return false;
    				}
    			}
    			else {
    				return false;
    			}
    			
    			PreparedStatement statement = conn.prepareStatement(SQLQueriesConstants.ADD_COURSE_IN_BUCKET);
	    		
	    		statement.setInt(1, student_id);
	    		statement.setString(2, course_id);
				
	    		if(course_type == 0) {
	    			statement.setInt(3, 0);
	    		}
	    		else if(course_type == 1) {
	    			statement.setInt(3, 1);
	    		}
	    		statement.executeQuery();
	    		return true;
			
	    	}catch(SQLException err) {
	    		System.out.println(err.getMessage());
	    	}
    	return false;
    }
    
    
    public boolean drop_course(Student student, Course course) {
    	
    	Connection connection=DBUtils.getConnection();
    	
		try {
			
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.DROP_COURSE);
			
			statement.setString(1, course.getCourseId());
			
			int uid = getStudentId(student.getUserId());
			
			statement.setInt(2, uid);
			
			int row = statement.executeUpdate();
			
			if(row==1)
			{
				return true;
			}
			return false;
				
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return false;    // Student does not exists
    	
    	
    }
    
    
    
    public ArrayList<Course> courseList(int sem) {
    	
    	ArrayList<Course> courses = new ArrayList<Course>();
    	
    	Connection connection=DBUtils.getConnection();
    	
//    	int uid = getStudentId(student.getUserId());
    	
		try {
			
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_COURSES);
			
			statement.setInt(1, sem);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next())
			{	
				String course_id = rs.getString("course_id");
				String course_name = rs.getString("course_name");
				int prof_id = rs.getInt("prof_id");
				double course_fee = rs.getDouble("course_fee");
				int semester = rs.getInt("semester");
				String professor_id = Integer.toString(prof_id);
				
				Course temp = new Course(course_name,course_id,prof_id,getCourseAvailabilityStatus(course_id),course_fee,semester);
				courses.add(temp);
 			}
			return courses;
				
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return null;
    	
    }
    
    
    public boolean getCourseAvailabilityStatus(String course_id) {
    	
    	Connection connection=DBUtils.getConnection();
    	
		try {
			
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.COUNT_CURRENT_COURSE_SEATS);
			
			statement.setString(1, course_id);
			
			ResultSet rs = statement.executeQuery();
			
			System.out.println(statement);
			
			if(rs.next())
			{
				int cnt = rs.getInt("COUNT(student_id)");
				if(cnt<10) {
					return true;
				}
			}
				
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return false;    // Student does not exists 

    	
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
    
    
    public int getCurrentSemester(int studentId) {
    	
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
    

    
    public void addStudent(Student student, int semester) {
    	
    	Connection conn = DBUtils.getConnection();
    	
    	try {
    		PreparedStatement statement = conn.prepareStatement(SQLQueriesConstants.ADD_STUDENT);
			statement.setString(1, student.getUserId());
			statement.setString(2, student.getName());
			statement.setString(3, student.getPassword());
			statement.executeQuery();
			
			PreparedStatement get_last_id = conn.prepareStatement(SQLQueriesConstants.LAST_ID);
			
			ResultSet rs = get_last_id.executeQuery();
			
			
			int last_id = 0;
			
			if(rs.next()) {
				last_id = rs.getInt(1);   // last student id + 1
			}
			
			PreparedStatement statement2 = conn.prepareStatement(SQLQueriesConstants.ADD_STUDENT_ID);
			statement2.setInt(1, last_id+1);
			statement2.setString(2, student.getUserId());
			statement2.setString(3, student.getBranch());
			statement2.setInt(4, semester);	
			
    	}catch(SQLException err) {
    		System.out.println(err.getMessage());
    	}
    }
    
    
    public double calculate_total_fee(String student_id) {
    	
    	double fees = 0.0;
    	
    	ArrayList<String> registered_course_list = getRegisteredCourseList(student_id);
    	
		Connection connection = DBUtils.getConnection();
		
		try {
				PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.CALCULATE_FEE);
				
				// @test  karna hai isse
				statement.setObject(1, registered_course_list);
				
				//statement.setArray(1, registered_course_list);
				
				ResultSet rs = statement.executeQuery();
				
				if(rs.next()){
					fees = fees + rs.getDouble("SUM(Course.course_fee)");
				}
			}
		catch(SQLException e){
			System.out.checkError();
		}
    	return fees;
    }
    
    
    public ArrayList<String> getRegisteredCourseList(String student_id) {
		// get the list of all the courses and return it.
    	
    	ArrayList<String> course = null;
    	
    	Connection connection = DBUtils.getConnection();
    	
    	
		try {
				PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_COURSE_ID);
				
				int id = getStudentId(student_id);
				
				statement.setInt(1, id);
				
				ResultSet rs = statement.executeQuery();
				
				if(rs.next()){
					course.add(rs.getString("course_id"));
				}
			}
		
		catch(SQLException e){
			System.out.checkError();
		}
    	return course;
	}
    
}
