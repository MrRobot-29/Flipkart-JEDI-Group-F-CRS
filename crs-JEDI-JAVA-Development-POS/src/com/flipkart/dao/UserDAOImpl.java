package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.client.AdminCRSMenu;
import com.flipkart.client.ProfessorCRSMenu;
import com.flipkart.client.StudentCRSMenu;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.helper.DaoHelper;

/**
 * Class to implement user Dao
 */
public class UserDAOImpl implements UserDAOInterface{

	public boolean registerAccount(Student std) {
		
		 Connection conn = DaoHelper.getConnection();
		 PreparedStatement stmt = null;
		 PreparedStatement stmt1 = null;
		 
		 try {

				System.out.println("Creating statement...");
				String sql = "insert into user values(?,?,?,?)";
				stmt = conn.prepareStatement(sql);


				String email = std.getUserId();
				String name = std.getName();
				String role = "student";
				String pwd = std.getPassword();
				boolean approvalStatus = std.isApproved();
				String branch = std.getBranch();
				int stdid = std.getStudentID();
				int sem = std.getSemester();
				
				stmt.setString(1, email); 
				stmt.setString(2, name);
				stmt.setString(3, role);
				stmt.setString(4, pwd);

				int rows = stmt.executeUpdate();
				System.out.println("Rows impacted : " + rows);

				

				sql = "INSERT INTO Student values(?,?,?,?,?)";
				stmt1 = conn.prepareStatement(sql);
				stmt1.setInt(1, stdid);
				stmt1.setString(2, email);
				stmt1.setInt(3, approvalStatus ? 1: 0);
				stmt1.setString(4, branch);
				stmt1.setInt(5, sem);
				
				rows = stmt1.executeUpdate();
			} catch (SQLException se) {
				se.printStackTrace();
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} finally {
				try {
					if (stmt != null)
						stmt.close();
					stmt1.close();
				} catch (SQLException se2) {
				} 
			} 
		return true;
	}
	
	public void editAccount() {
		
	}
	
	public boolean checkAccount(String userId, String password, String role) {
		
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("professor");
		arr.add("student");
		arr.add("admin");
		
		if(!arr.contains(role)) {
			System.out.println("Invalid role!!");
			return false;
		}
		
		
		Connection conn = DaoHelper.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "SELECT * FROM user WHERE email ='"+ userId + "' AND role = '"+ role + "'";
		try {
			
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			if (!rs.isBeforeFirst() ) {    
				System.out.println("Account with mentioned role not found! Please try again.");
			    return false;
			}
			
			while(rs.next()) {
				String pwd = rs.getString("password");
				if(pwd.compareTo(password) != 0) {
					System.out.println("Wrong password for given account");
					return false;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally{
			try {
				if(stmt!=null)
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return true;
		
	}
	
	public void loginAccount(String userName, String Password, String role) {
		
		if(!checkAccount(userName, Password, role)) {
			return;
		}
		
		
		if(role.equals("professor")) {
			
			Connection conn = DaoHelper.getConnection();
			PreparedStatement stmt = null;
			
			String sql = "SELECT name from User WHERE email = '" + userName + "'";
			
			try {
				stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				Professor p = null;
				while(rs.next()) {
					String name = rs.getString("name");
					PreparedStatement stmt1 = conn.prepareStatement("SELECT * FROM Professor WHERE email = '" + userName + "'");
					ResultSet rs1 = stmt1.executeQuery();
					while(rs1.next()) {
						int profId = rs1.getInt("prof_id");
						String dept = rs1.getString("department");
						p = new Professor(userName, name, Role.PROFESSOR, Password, Gender.MALE, "India", "India", dept, "Asc. Prof", profId);				
					}
				}
				
				ProfessorCRSMenu professorMenu = new ProfessorCRSMenu();
				professorMenu.createMenu(p);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(stmt!=null)
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		else if(role.equals("student")) {
			
			Connection conn = DaoHelper.getConnection();
			PreparedStatement stmt = null;
			
			String sql = "SELECT name from User WHERE email = '" + userName + "'";
			
			
			try {
				stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				Student std = null;
				while(rs.next()) {
					String name = rs.getString("name");
					PreparedStatement stmt1 = conn.prepareStatement("SELECT * FROM Student WHERE email = '" + userName + "'");
					ResultSet rs1 = stmt1.executeQuery();
					while(rs1.next()) {
						int stdId = rs1.getInt("student_id");
						int approvalStatus = rs1.getInt("approval_status");
						int sem = rs1.getInt("semester");
						String branch = rs1.getString("branch");
						std = new Student(userName, name, Role.STUDENT, Password, Gender.MALE, "India", "India", branch, stdId, sem, approvalStatus == 1);				
					}
				}
				
				if(!std.isApproved()) {
					System.out.println("The Student account is not approved. Contact admin");
					return;
				}
				
				
				StudentCRSMenu stdMenu = new StudentCRSMenu();
				if(std != null)
					stdMenu.createMenu(std);
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				try {
					if(stmt!=null)
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		else if(role.equals("admin")) {
			Connection conn = DaoHelper.getConnection();
			PreparedStatement stmt = null;
			
			String sql = "SELECT name from User WHERE email = '" + userName + "'";
			
			
			try {
				stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				Admin ad = null;
				while(rs.next()) {
					String name = rs.getString("name");
					ad = new Admin(userName, name, Role.ADMIN, Password, Gender.MALE, "India","India");
				}
				AdminCRSMenu adminMenu = new AdminCRSMenu();
				if(ad != null)
					adminMenu.createMenu(ad);
				else {
					System.out.println("Error in opening Admin Menu. ");
				}
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				try {
					if(stmt!=null)
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
