package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

public class AdminDAOImpl implements AdminDAOInterface {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/crs_db";

	static final String USER = "root";
	static final String PASS = "Gd@21051971";

	public void dropCourse(String courseId) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creating statement...");
			String sql = "DELETE FROM Course where course_id = '" + courseId + "'";
			stmt = conn.prepareStatement(sql);

			int rows = stmt.executeUpdate();
			if (rows > 0)
				System.out.println("Course Deleted Successfully!");
			else {
				System.out.println("Course not found");
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
		} // end try
	}

	public boolean addCourse(Course c) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 4 make/open a connection

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			String sql = "insert into Course values(?,?,?,?, ?)";
			// String sql = "UPDATE Employees set age=? WHERE id=?";
			// String sql1="delete from employee where id=?";
			// stmt.setInt(1, 101);
			stmt = conn.prepareStatement(sql);

			// Hard coded data

			String courseID = c.getCourseId();
			String courseName = c.getCourseName();
			int insID = c.getInstructorId();
			double fee = c.getCourseFee();
			int sem = c.getSemester();
			// Bind values into the parameters.
			stmt.setString(1, courseID); // This would set age
			stmt.setString(2, courseName);
			stmt.setInt(3, insID);
			stmt.setDouble(4, fee);
			stmt.setInt(5, sem);

			int rows = stmt.executeUpdate();
			if (rows > 0)
				System.out.println("Course Inserted Successfully!");
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
		return false;
	}

	public ArrayList<Course> viewCourses() {
		ArrayList<Course> arr = new ArrayList<Course>();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 4 make/open a connection

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			
			String sql = "SELECT * FROM Course";
			stmt = conn.prepareStatement(sql);
			
		    ResultSet rs = stmt.executeQuery(sql);

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         String cid  = rs.getString("course_id");
		         String cname = rs.getString("course_name");
		         int profId = rs.getInt("prof_id");
		         Double cfee = rs.getDouble("course_fee");
		         int sem = rs.getInt("semester");
		         Course c = new Course(cname, cid, profId, true, cfee, sem);
		         arr.add(c);
		      }
//		 STEP 6: Clean-up environment
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
		
		return arr;
	}

	public ArrayList<Student> viewPendingStudents() {
		ArrayList<Student> arr =  new ArrayList<Student>();
		return arr;
	}

	public ArrayList<Student> viewAllStudents() {
		ArrayList<Student> arr =  new ArrayList<Student>();
		return arr;
	}

	public boolean validateStudent(int studentId) {
		return false;
	}

	public void addProfessor(Professor prof) {
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 4 make/open a connection

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			String sql = "insert into user values(?,?,?,?)";
			// String sql = "UPDATE Employees set age=? WHERE id=?";
			// String sql1="delete from employee where id=?";
			// stmt.setInt(1, 101);
			stmt = conn.prepareStatement(sql);

			// Hard coded data

			String email = prof.getUserId();
			String name = prof.getName();
			String role = "professor";
			String pwd = prof.getPassword();
			String dept = prof.getDepartment();
			int profId = prof.getProfId();
			// Bind values into the parameters.
			stmt.setString(1, email); // This would set age
			stmt.setString(2, name);
			stmt.setString(3, role);
			stmt.setString(4, pwd);
//			      stmt.executeUpdate();

			// Let us update age of the record with ID = 102;
			int rows = stmt.executeUpdate();
			System.out.println("Rows impacted : " + rows);

			stmt.close();

			sql = "INSERT INTO Professor values(?,?,?)";
			stmt1 = conn.prepareStatement(sql);
			stmt1.setInt(1, profId); // This would set age
			stmt1.setString(2, email);
			stmt1.setString(3, dept);
			rows = stmt1.executeUpdate();
			System.out.println("Rows impacted : " + rows);
			// Let us select all the records and display them.
//			      sql = "SELECT id, name ,address FROM customer";
//			      ResultSet rs = stmt.executeQuery(sql);
//
//			      //STEP 5: Extract data from result set
//			      while(rs.next()){
//			         //Retrieve by column name
//			         int eid  = rs.getInt("id");
//			         String name1 = rs.getString("name");
//			         String address1 = rs.getString("address");
//
//			         //Display values
//			         System.out.print("ID: " + eid);
//			         System.out.print(", Age: " + name1);
//			         System.out.println(", First: " + address1);
//			      }
			// STEP 6: Clean-up environment
			// rs.close();
			stmt1.close();
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

	}

	public void dropProfessor(int ProfId) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 4 make/open a connection

			System.out.println("Connecting to database...");
			System.out.println(ProfId);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			String sql = "SELECT * FROM Professor WHERE prof_id ='" + ProfId + "'";
			stmt = conn.prepareStatement(sql);

			// Bind values into the parameters.
//			      stmt.setInt(1, ProfId);  // This would set age
//			      stmt.executeUpdate();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String email = rs.getString("email");
				System.out.println(email + " is going to be deleted!");
				PreparedStatement stmt1 = null;
				sql = "delete from user where email = '" + email + "'";
				stmt1 = conn.prepareStatement(sql);
				int rows = stmt1.executeUpdate();

				if (rows > 0) {
					System.out.println("Professor deleted successfully!");
				}
				stmt1.close();
			}
			rs.close();
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
	}

	public void viewProfessors() {

	}

	public void generateGradeCard(String studentId, String semester) {

	}
}
