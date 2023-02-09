package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.exception.StudentNotFoundException;
import com.flipkart.helper.DaoHelper;

/**
 * Class to implement Professor Dao
 */
public class ProfessorDaoImpl implements ProfessorDaoInterface{
	Connection conn = null;
	PreparedStatement stmt = null;
	
	@Override
	public List<Course> viewCourseList(int instructorId) {
		// TODO Auto-generated method stub
		List<Course> takenCourses = new ArrayList<Course>();
		try { 
			conn = DaoHelper.getConnection();
			String sql = "SELECT * FROM COURSE WHERE PROF_ID=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,instructorId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String courseName = rs.getString("COURSE_NAME");
				String courseId = rs.getString("COURSE_ID");
				boolean isCourseAvailable = true;
				double fee = rs.getDouble("COURSE_FEE");
				int semester = rs.getInt("SEMESTER");
				Course c = new Course(courseName,courseId,instructorId,isCourseAvailable,fee,semester);
				takenCourses.add(c);
			}
			
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
		} // end try
		return takenCourses;
	}

	@Override
	public boolean selectCourseToTeach(String courseId, int instructorId) {
		// TODO Auto-generated method stub
		boolean status = false;
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
				status = true;
			}
				
			
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
			
		} 
		return status;
	}

	@Override
	public List<Student> viewEnrolledStudents(int instructorId, String courseId) {
		// TODO Auto-generated method stub
		List<Student> enrolledStudents = new ArrayList<Student>();
		try { 
			conn = DaoHelper.getConnection();
			String sql = "SELECT S.EMAIL,U.NAME,U.PASSWORD,S.BRANCH,S.STUDENT_ID,S.SEMESTER,S.APPROVAL_STATUS FROM USER U, STUDENT S, REGISTEREDCOURSE RC, COURSE C"
					+ " WHERE U.EMAIL=S.EMAIL AND S.STUDENT_ID=RC.STUDENT_ID AND RC.COURSE_ID=C.COURSE_ID "
					+ "AND C.PROF_ID=? AND C.COURSE_ID=?";
			stmt = conn.prepareStatement(sql);
			System.out.println(instructorId+" "+courseId);
			stmt.setInt(1,instructorId);
			stmt.setString(2,courseId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String userId = rs.getString("S.EMAIL");
				String name = rs.getString("U.NAME");
				Role role = Role.STUDENT;
				String password = rs.getString("U.PASSWORD");
				Gender gender = Gender.MALE;
				String address = "Blr";
				String country = "India";
				String branchName = rs.getString("S.BRANCH");
				int studentId = rs.getInt("S.STUDENT_ID");
				int semester = rs.getInt("S.SEMESTER");
				Boolean isApproved = rs.getInt("S.APPROVAL_STATUS")==1;

				Student s = new Student(userId,name,role,password,gender,address,country,branchName,studentId,semester,isApproved);
				enrolledStudents.add(s);
			}
			//rs.close();
			
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
		} 
		return false;
	}

}
