package com.log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class LoginDAO {

	private static final String memberid = null;

	public Connection dbConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/reutest";
		String un = "root";
		String pw = "Janith@12345";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// connect to db
			con = DriverManager.getConnection(url, un, pw);

			System.out.println("Database connection succes");
		} catch (Exception e) {

		}

		return con;

	}

	public String checkLogin(String uname, String pword) {
		String userType = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Connect to database
			Connection con = dbConnection();

			// SQL query with placeholders
			String sql = "SELECT type FROM userst WHERE username = ? AND password = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pword);

			// Execute query and check if a user exists with the credentials
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// Get the type of user (admin, teacher, principal, etc.)
				userType = rs.getString("type");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userType; // Return user type or null if credentials are incorrect
	}

	public List<user> getallusers() {

		List<user> us = new ArrayList<>();
		Connection con = dbConnection();

		String query = "SELECT * FROM staffmember";

		try {

			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String memberid = rs.getString("memberid");
				String sname = rs.getString("sname");
				String mail = rs.getString("mail");
				String stype = rs.getString("stype");

				us.add(new user(memberid, sname, mail, stype));
			}
			System.out.println(" connection succes");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Users retrieved: " + us.size());
		return us;
	}

	public void addNewuser(user pt) {
		try {
			Connection con = dbConnection();
			String sql = "INSERT INTO staffmember (memberid, sname, mail, stype) VALUES(?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pt.getMemberid()); // Set the mid (member ID)
			ps.setString(2, pt.getName()); // Set the name
			ps.setString(3, pt.getMail()); // Set the mail
			ps.setString(4, pt.getType()); // Set the type

			System.out.println(ps);

			// Execute query
			ps.executeUpdate();

			System.out.println("User inserted successfully");
		} catch (Exception e) {
			e.printStackTrace(); // Print the stack trace to help with debugging
		}
	}

	public void deleteUser(String mid) {
		Connection con = dbConnection();
		String sql = "DELETE FROM staffmember WHERE memberid = " + mid + ""; // Note: This is vulnerable to SQL
																				// injection!
		System.out.println("Executing SQL: " + sql);

		try {
			Statement st = con.createStatement();
			int rowsAffected = st.executeUpdate(sql); // Execute the update and get affected rows
			if (rowsAffected > 0) {
				System.out.println("Delete successful for member ID: " + mid);
			} else {
				System.out.println("No user found with member ID: " + mid);
			}

			st.close(); // Close the Statement
			con.close(); // Close the Connection
		} catch (SQLException e) {
			e.printStackTrace(); // Log the exception
		}
	}

	public user selectOlduser(String mid) {

		Connection con = dbConnection();

		user olduser = null;

		try {
			String sql = "SELECT * FROM staffmember WHERE memberid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, mid);

			System.out.println(ps);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String memberid = rs.getString("memberid");
				String sname = rs.getString("sname");
				String mail = rs.getString("mail");
				String stype = rs.getString("stype");

				olduser = new user(memberid, sname, mail, stype);
				System.out.println(olduser);
			}

			System.out.println(olduser);
		} catch (Exception e) {

		}
		return olduser;
	}

	public boolean updateOlduser(user updateuser) {

		Connection con = dbConnection();
		boolean update = false;
		try {
			String sql = "UPDATE staffmember SET sname=?,mail=?,stype=? WHERE memberid=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, updateuser.getName());
			ps.setString(2, updateuser.getMail());
			ps.setString(3, updateuser.getType());
			ps.setString(4, updateuser.getMemberid());

			System.out.println(ps);
			update = ps.executeUpdate() > 0;

		} catch (Exception e) {

		}

		return update;
	}

}
