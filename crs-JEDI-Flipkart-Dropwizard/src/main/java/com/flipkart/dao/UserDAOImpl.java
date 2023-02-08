package com.flipkart.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.lang.Exception;

import com.flipkart.bean.Student;
import com.flipkart.constant.Color;
import com.flipkart.exception.UserAlreadyExistsException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.exception.WrongPasswordException;
import com.flipkart.helper.DaoHelper;

/**
 * Class to implement user Dao
 */
public class UserDAOImpl implements UserDAOInterface {

	public boolean registerAccount(Student std) throws UserAlreadyExistsException {

		Connection conn = DaoHelper.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;

		try {

			//System.out.println("Creating statement...");
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
			//System.out.println("Rows impacted : " + rows);


			sql = "INSERT INTO Student values(?,?,?,?,?)";
			stmt1 = conn.prepareStatement(sql);
			stmt1.setInt(1, stdid);
			stmt1.setString(2, email);
			stmt1.setInt(3, approvalStatus ? 1 : 0);
			stmt1.setString(4, branch);
			stmt1.setInt(5, sem);

			rows = stmt1.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException sicve) {
			throw new UserAlreadyExistsException(std.getUserId());
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
		}
		return true;
	}

	public void editAccount() {

	}

	public boolean checkAccount(String userId, String password, String role) throws UserNotFoundException, WrongPasswordException {

		ArrayList<String> arr = new ArrayList<String>();
		arr.add("professor");
		arr.add("student");
		arr.add("admin");

		if (!arr.contains(role)) {
			System.out.println(Color.ANSI_YELLOW + "Invalid role!!" + Color.ANSI_RESET);
			return false;
		}


		Connection conn = DaoHelper.getConnection();
		PreparedStatement stmt = null;

		String sql = "SELECT * FROM user WHERE email ='" + userId + "' AND role = '" + role + "'";
		try {

			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			if (!rs.isBeforeFirst()) {
				System.out.println("Account with mentioned role not found! Please try again.");
				throw new UserNotFoundException(userId);
			}

			while (rs.next()) {
				String pwd = rs.getString("password");
				if (pwd.compareTo(password) != 0) {
					throw new WrongPasswordException(userId);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return true;

	}

	public boolean loginAccount(String userName, String Password, String role) throws UserNotFoundException, WrongPasswordException {


		try {
			if (!checkAccount(userName, Password, role)) {
				return false;
			}else{
				return true;
			}

		} catch (UserNotFoundException | WrongPasswordException e) {
			throw e;
		}
	}

}
