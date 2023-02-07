/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.ResultSet;

import com.flipkart.bean.*;

import com.flipkart.utils.DBUtils;


import java.util.*;
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
			while(rs.next())
				cnt = rs.getInt("count");
			
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
			while(rs.next())
				cnt = rs.getInt("count");
			
    	}catch(SQLException err) {
    		System.out.println(err.getMessage());
    	}
    	return cnt;
    }
    
    public boolean checkCourse(int studentId, String courseId) {
    	
    	Connection conn = DBUtils.getConnection();
    	
    	PreparedStatement stmt = null;
    	
    	String sql = "SELECT COUNT(*) as count FROM RegisteredCourse WHERE student_id = " + studentId + " AND course_id = '"+ courseId +"'";
    	try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int count = 0;
			
			while(rs.next()) {
				count = rs.getInt("count");
			}
			
			if(count > 0) return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return true;
    }

    
    public boolean addCourseBucket(int student_id, String course_id, int course_type) {
    	
    	Connection conn = DBUtils.getConnection();
    	

    	
    	try {
    		    if(!checkCourse(student_id, course_id)) {
    		    	System.out.println("Course already added!");
    		    	return false;
    		    }
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
	    		statement.executeUpdate();
	    		return true;
			
	    	}catch(SQLException err) {
	    		System.out.println(err.getMessage());
	    	}
    	return false;
    }
    
    
    public boolean drop_course(int studentId, String courseId) {
    	
    	Connection connection=DBUtils.getConnection();
    	
		try {
			
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.DROP_COURSE);
			
			statement.setString(1, courseId);
			
			statement.setInt(2, studentId);
			
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
    
    
    public double calculate_total_fee(int student_id) {
    	
    	double fees = 0.0;
    	
    	//ArrayList<String> registered_course_list = getRegisteredCourseList(student_id);
    	
		Connection connection = DBUtils.getConnection();
		
		try {
				PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.CALCULATE_FEE);
				
				// @test  karna hai isse
				statement.setInt(1, student_id);
				System.out.println(statement);
				//statement.setArray(1, registered_course_list);
				
				ResultSet rs = statement.executeQuery();
				
				if(rs.next()){
					fees = rs.getDouble("fee");
				}
			}
		catch(SQLException e){
			System.out.checkError();
		}
    	return fees;
    }
    
    
    public String isGradeReleased(int semester) {
    	
    	Connection connection = DBUtils.getConnection();
		try {
				PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_GRADE_STATUS);
				
				statement.setInt(1, semester);
				
				ResultSet rs = statement.executeQuery();
				
				if(rs.next()){
					return rs.getString("grade_status");
				}
			}
		
		catch(SQLException e){
			System.out.checkError();
		}
    	
    	return "awaited";
    }
    
    
    public HashMap<String,String> viewGrade(int student_id, int semester) {

    	HashMap<String,String> subject_grade=new HashMap<String,String>();//Creating HashMap
    	
    	Connection connection = DBUtils.getConnection();
    	

    	if(isGradeReleased(semester).equalsIgnoreCase("awaited")) {
    		return null;
    	}
    	
		try {
				PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_COURSE_GRADE);
				
				statement.setInt(1, student_id);
				
				ResultSet rs = statement.executeQuery();
				
				while(rs.next()){
					subject_grade.put(rs.getString("course_id"), rs.getString("grade"));
				}
			}
		
		catch(SQLException e){
			System.out.checkError();
		}
		
    	return subject_grade;
    }
    
    public boolean payFee(int student_id, String payment_id, String payment_method, String payment_details) {
    	
    	Connection connection = DBUtils.getConnection();
    	
		try {
				PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.PAY_FEE);
								
				statement.setInt(1, student_id);
				statement.setString(2, payment_id);
				statement.setString(3, payment_method);
				statement.setString(4, payment_details);
				
				int row = statement.executeUpdate();
				
				if(row == 1)
					return true;
			}
		
		catch(SQLException e){
			System.out.checkError();
		}

    	return false;	
    }
    
    
    public ArrayList<String> getRegisteredCourseList(int student_id) {
		// get the list of all the courses and return it.
    	
    	ArrayList<String> course = new ArrayList<String>();
    	
    	Connection connection = DBUtils.getConnection();
    	
    	
		try {
				PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_COURSE_ID);
								
				statement.setInt(1, student_id);
				ResultSet rs = statement.executeQuery();
				
				while(rs.next()){
					course.add(rs.getString("course_id"));
				}
			}
		
		catch(SQLException e){
			System.out.checkError();
		}

    	return course;
	}
    
}
