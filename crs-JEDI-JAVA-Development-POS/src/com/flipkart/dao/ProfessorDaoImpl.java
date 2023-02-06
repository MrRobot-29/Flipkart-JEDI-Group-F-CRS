package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.helper.DaoHelper;

public class ProfessorDaoImpl implements ProfessorDaoInterface{
	Connection conn = null;
	PreparedStatement stmt = null;
	
	@Override
	public List<String> viewCourseList(int instructorId) {
		// TODO Auto-generated method stub
		List<String> takenCourses = new ArrayList<String>();
		try { 
			conn = DaoHelper.getConnection();
			String sql = "SELECT COURSE_NAME FROM COURSE WHERE PROF_ID=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,instructorId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				takenCourses.add(rs.getString("course_name"));
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException se) {
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
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return takenCourses;
	}

	@Override
	public boolean selectCourseToTeach(String courseId, int instructorId) {
		// TODO Auto-generated method stub
		try { 
			conn = DaoHelper.getConnection();
			String sql = "UPDATE COURSE SET PROF_ID=? WHERE COURSE_ID=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,instructorId);
			stmt.setString(2, courseId);
			stmt.executeUpdate();
			
			int rows = stmt.executeUpdate();
			if (rows > 0) {
				System.out.println("Professor Successfully Opted the course to teach!");
			}
				
			stmt.close();
			conn.close();
			
		} catch (SQLException se) {
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
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} 
		return false;
	}

	@Override
	public List<String> viewEnrolledStudents(int instructorId,String courseId) {
		// TODO Auto-generated method stub
		List<String> enrolledStudents = new ArrayList<String>();
		try { 
			conn = DaoHelper.getConnection();
			String sql = "SELECT DISTINCT NAME FROM USER U, STUDENT S, REGISTEREDCOURSE RC, COURSE C"
					+ " WHERE U.EMAIL=S.EMAIL AND S.STUDENT_ID=RC.STUDENT_ID AND RC.COURSE_ID=C.COURSE_ID "
					+ "AND C.PROF_ID=? AND C.COURSE_ID=?";
			stmt = conn.prepareStatement(sql);
			System.out.println(instructorId+" "+courseId);
			stmt.setInt(1,instructorId);
			stmt.setString(2,courseId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				enrolledStudents.add(rs.getString("name"));
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException se) {
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
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return enrolledStudents;
	}

	@Override
	public boolean addGrade(String courseId, int studentId, String grade) {
		// TODO Auto-generated method stub
		try { 
			conn = DaoHelper.getConnection();
			String sql = "UPDATE RegisteredCourse SET Grade=? WHERE COURSE_ID=? AND STUDENT_ID=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,grade);
			stmt.setString(2, courseId);
			stmt.setInt(3,studentId);
			stmt.executeUpdate();
			
			int rows = stmt.executeUpdate();
			if (rows > 0)
				System.out.println("Grade added Successfully");
			stmt.close();
			conn.close();
			
		} catch (SQLException se) {
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
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} 
		return false;
	}

}
