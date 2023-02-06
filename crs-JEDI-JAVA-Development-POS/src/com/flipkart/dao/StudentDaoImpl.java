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
public class StudentDaoImpl {
	
	
	DBUtils DBUtils;
  
    public StudentDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		DBUtils = new DBUtils();
	}


    
    public void addCourseBucket(Student student, ArrayList<Course> courses) {
    	
    	Connection conn = DBUtils.getConnection();
    	
    	
//    	String sql = "insert into RegisteredCourse values(?,?,?,?)";
//        stmt = conn.prepareStatement(sql);
//        stmt.setInt(1,studentId);
//        stmt.setString(2, courseId);
//        stmt.setString(3, null);
//        stmt.setInt(4, 0);
//        int rows = stmt.executeUpdate();
//        if(rows==1)
//            return true;
//        else
//            return false;
    	
    	try {
    		
    		int cnt = 1;
    		
    		for(Course ct : courses) {
    			if(getCourseAvailabilityStatus(ct.getCourseId())) {
    				PreparedStatement statement = conn.prepareStatement(SQLQueriesConstants.ADD_COURSE_IN_BUCKET);
    	    		
    	    		statement.setString(1, student.getUserId());
    	    		statement.setString(2, ct.getCourseId());
    				
    	    		if(cnt<=4) {
    	    			statement.setInt(3, 0);
    	    		}
    	    		else {
    	    			statement.setInt(3, 1);
    	    		}
    				statement.executeQuery();
    				
    				//ResultSet rs = statement.executeQuery();
    				
    			}
    			
    			cnt++;
    		}
			
//			PreparedStatement get_last_id = conn.prepareStatement(SQLQueriesConstants.LAST_ID);
//			
//			ResultSet rs = get_last_id.executeQuery();
			
			
//			int last_id = 0;
////			
//			if(rs.next()) {
//				last_id = rs.getInt(1);   // last student id + 1
//			}
//			
//			PreparedStatement statement2 = conn.prepareStatement(SQLQueriesConstants.ADD_STUDENT_ID);
//			statement2.setInt(1, last_id+1);
//			statement2.setString(2, student.getUserId());
//			statement2.setString(3, student.getBranch());
//			statement2.setInt(4, semester);	
			
	    	}catch(SQLException err) {
	    		System.out.println(err.getMessage());
	    	}
    }
    
    
    
    
    public ArrayList<Course> courseList(Student student, int sem) {
    	
    	ArrayList<Course> courses = null;
    	
    	Connection connection=DBUtils.getConnection();
    	
    	int uid = getStudentId(student.getUserId());
    	
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
				
				Course temp = null;
				
				temp.setCourseId(course_id);
				temp.setCourseName(course_name);
				temp.setInstructorId(professor_id);
				temp.setCourseAvailable(getCourseAvailabilityStatus(course_id));
				temp.setCourseFee(course_fee);
				//temp.setSemester(semester)
				courses.add(temp);
 			}
				
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
    	return courses;
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
    
    
    public ArrayList<String> getRegisteredCourseList(Student student) {
		// get the list of all the courses and return it.
    	
    	ArrayList<String> course = null;
    	
    	Connection connection = DBUtils.getConnection();
    	
    	
		try {
				PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_COURSE_ID);
				
				int id = getStudentId(student.getUserId());
				
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
