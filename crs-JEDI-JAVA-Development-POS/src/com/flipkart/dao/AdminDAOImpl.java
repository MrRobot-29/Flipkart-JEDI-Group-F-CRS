package com.flipkart.dao;

import java.sql.*;

import java.util.ArrayList;



import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.exception.*;
import com.flipkart.helper.DaoHelper;
import com.flipkart.utils.DBUtils;

/**
 * class for Admin Dao Implementation
 */

public class AdminDAOImpl implements AdminDAOInterface {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/crs_db";

	static final String USER = "root";
	static final String PASS = "Gd@21051971";;


	DBUtils DBUtils;
  
    public AdminDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
		DBUtils = new DBUtils();
	}
    

	public void dropCourse(String courseId) throws CourseNotFoundException {
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
				throw new CourseNotFoundException(courseId);
			}
			stmt.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
		}
	}

	public boolean addCourse(Course c) throws CourseAlreadyExistsException{
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DaoHelper.getConnection();
			String sql = "insert into Course values(?,?,?,?, ?)";
			stmt = conn.prepareStatement(sql);

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
			stmt.close();
			if (rows > 0)
				return true;
		} catch (SQLIntegrityConstraintViolationException sicve){
			throw new CourseAlreadyExistsException(c.getCourseId());
		}
		catch (SQLException se) {
			se.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ArrayList<Course> viewCourses() throws NoCourseFoundException{
		ArrayList<Course> arr = new ArrayList<Course>();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DaoHelper.getConnection();
			
			String sql = "SELECT * FROM Course";
			stmt = conn.prepareStatement(sql);
			
		    ResultSet rs = stmt.executeQuery(sql);
			if(!rs.isBeforeFirst()){
				throw new NoCourseFoundException();
			}
		      while(rs.next()){
		         String cid  = rs.getString("course_id");
		         String cname = rs.getString("course_name");
		         int profId = rs.getInt("prof_id");
		         Double cfee = rs.getDouble("course_fee");
		         int sem = rs.getInt("semester");
		         Course c = new Course(cname, cid, profId, true, cfee, sem);
		         arr.add(c);
		      }
		 rs.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

	public ArrayList<Student> viewPendingStudents() throws NoStudentFoundException {
		Connection conn = DaoHelper.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "SELECT * FROM Student AS st INNER JOIN User as us ON st.email = us.email WHERE st.approval_status = 0";
		ArrayList<Student> arr = new ArrayList<Student>();
		
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				throw new NoStudentFoundException();
			}
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
			e.printStackTrace();
		}
		return arr;
	}

	public ArrayList<Student> viewAllStudents() throws  NoStudentFoundException{
		Connection conn = DaoHelper.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "SELECT * FROM Student AS st INNER JOIN User as us ON st.email = us.email WHERE st.approval_status = 1";
		ArrayList<Student> arr = new ArrayList<Student>();
		
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				throw new NoStudentFoundException();
			}
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
		} 

		return arr;
	}

	public boolean validateStudent(int studentId) throws StudentNotFoundException {
		
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
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			
		}
		return true;
	}	

	public void addProfessor(Professor prof) throws ProfessorIdAlreadyExistsException {
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;

		try {
			conn = DaoHelper.getConnection();
			String sql = "insert into user values(?,?,?,?)";
			stmt = conn.prepareStatement(sql);

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

			sql = "INSERT INTO Professor values(?,?,?)";
			stmt1 = conn.prepareStatement(sql);
			stmt1.setInt(1, profId); // This would set age
			stmt1.setString(2, email);
			stmt1.setString(3, dept);
			rows = stmt1.executeUpdate();
			stmt.close();
			stmt1.close();
		} catch (SQLIntegrityConstraintViolationException e){
			throw new ProfessorIdAlreadyExistsException(prof.getProfId());
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
		}

	}

	public void dropProfessor(int ProfId) throws ProfessorCannotBeDroppedException {
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
			throw new ProfessorCannotBeDroppedException(ProfId);
//			se.printStackTrace();
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
	
	
	// added new funcationality <tue 7 feb>
		public ArrayList<Professor> viewProfessors() throws NoProfessorFoundException{
			ArrayList<Professor> professors = new ArrayList<Professor>();
		
	    	
	    	Connection connection =  DaoHelper.getConnection();
	    	
			try {
					PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_PROFF_LIST);
									
					ResultSet rs = statement.executeQuery();
					if(!rs.isBeforeFirst()){
						throw new NoProfessorFoundException();
					}
					while(rs.next()){
						Professor temp = new Professor();
						temp.setName(rs.getString("name"));
						temp.setDepartment(rs.getString("department"));
						temp.setProfId(rs.getInt("prof_id"));
						professors.add(temp);
						
					}
				}
			catch(SQLException e){
				System.out.checkError();
			}
	    	return professors;
		}

	public void generateGradeCard(int semester) throws GradeCardNotGeneratedException {
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
