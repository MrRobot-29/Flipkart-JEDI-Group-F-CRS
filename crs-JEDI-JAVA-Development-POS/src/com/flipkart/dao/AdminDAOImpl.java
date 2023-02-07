package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.helper.DaoHelper;

/**
 * class for Admin Dao Implementation
 */
public class AdminDAOImpl implements AdminDAOInterface {

	public void dropCourse(String courseId) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DaoHelper.getConnection();
			String sql = "DELETE FROM Course where course_id = '" + courseId + "'";
			stmt = conn.prepareStatement(sql);

			int rows = stmt.executeUpdate();
			if (rows > 0)
				System.out.println("Course Deleted Successfully!");
			else {
				System.out.println("Course not found");
			}
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
		} // end try
	}

	public boolean addCourse(Course c) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DaoHelper.getConnection();
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
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
		}
		return false;
	}

	public ArrayList<Course> viewCourses() {
		ArrayList<Course> arr = new ArrayList<Course>();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DaoHelper.getConnection();
			
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
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
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
		Connection conn = DaoHelper.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "SELECT * FROM Student AS st INNER JOIN User as us ON st.email = us.email WHERE st.approval_status = 0";
		ArrayList<Student> arr = new ArrayList<Student>();
		
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String email = rs.getString("email");
				String name = rs.getString("name");
				String branch = rs.getString("branch");
				int sem = rs.getInt("semester");
				int approvalStatus = rs.getInt("approval_status");
				int stdID = rs.getInt("student_id");
				String password = rs.getString("password");
				
				Student std = new Student(email, name, Role.STUDENT, password, Gender.MALE, "India", "India", branch, stdID, sem, approvalStatus == 1);
				arr.add(std);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}

		return arr;
	}

	public ArrayList<Student> viewAllStudents() {
		Connection conn = DaoHelper.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "SELECT * FROM Student AS st INNER JOIN User as us ON st.email = us.email WHERE st.approval_status = 1";
		ArrayList<Student> arr = new ArrayList<Student>();
		
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String email = rs.getString("email");
				String name = rs.getString("name");
				String branch = rs.getString("branch");
				int sem = rs.getInt("semester");
				int approvalStatus = rs.getInt("approval_status");
				int stdID = rs.getInt("student_id");
				String password = rs.getString("password");
				
				Student std = new Student(email, name, Role.STUDENT, password, Gender.MALE, "India", "India", branch, stdID, sem, approvalStatus == 1);
				arr.add(std);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}

		return arr;
	}

	public boolean validateStudent(int studentId) {
		
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DaoHelper.getConnection();
			String sql = "UPDATE Student SET approval_status = 1 WHERE student_id ="+ studentId;
			stmt = conn.prepareStatement(sql);

			int rows = stmt.executeUpdate();
			if (rows > 0) {
				System.out.println("Student approved to login !");
			}else {
				System.out.println("Student approval request does not exist");
			}
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
			
		} // end try
		return true;
	}	

	public void addProfessor(Professor prof) {
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;

		try {
			conn = DaoHelper.getConnection();
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

			

			sql = "INSERT INTO Professor values(?,?,?)";
			stmt1 = conn.prepareStatement(sql);
			stmt1.setInt(1, profId); // This would set age
			stmt1.setString(2, email);
			stmt1.setString(3, dept);
			rows = stmt1.executeUpdate();
			System.out.println("Rows impacted : " + rows);
			stmt.close();
			stmt1.close();
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

	}

	public void dropProfessor(int ProfId) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DaoHelper.getConnection();
			String sql = "SELECT * FROM Professor WHERE prof_id ='" + ProfId + "'";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String email = rs.getString("email");
				System.out.println(email + " is going to be deleted!");
				Statement stmt1 = conn.createStatement();
				String s3 = "UPDATE Course set prof_id = 0 WHERE prof_id = " + ProfId;
				String s1 = "Delete from Professor where email = '" + email +"'";
				String s2 = "Delete from user where email = '" + email + "'";
				stmt1.addBatch(s3);
				stmt1.addBatch(s1);
				stmt1.addBatch(s2);
				int[] rows = stmt1.executeBatch();

				if (rows[0] > 0) {
					System.out.println("Professor deleted successfully!");
				}
				stmt1.close();
			}
			rs.close();
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
	}

	public void viewProfessors() {

	}

	public void generateGradeCard(int semester) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DaoHelper.getConnection();
			String sql = "UPDATE GradeStatus SET grade_status = 1 WHERE semester ="+ semester;
			stmt = conn.prepareStatement(sql);

			int rows = stmt.executeUpdate();
			if (rows > 0) {
					System.out.println("Grade cards for semester " + semester + " released !");
				}
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
			
		} // end try
	}
}
