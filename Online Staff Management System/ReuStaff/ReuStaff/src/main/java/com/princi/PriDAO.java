package com.princi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;


public class PriDAO {
	
	// Method to establish a connection to the MySQL database
	public Connection dbConnection() {
	    Connection con = null;
	    String url = "jdbc:mysql://localhost:3306/reutest";
	    String un = "root";
	    String pw = "Janith@12345";
	    try {
	    	// Load the MySQL JDBC driver
	        Class.forName("com.mysql.cj.jdbc.Driver");
	     // Establish the connection
	        con = DriverManager.getConnection(url, un, pw);
	        System.out.println("Database connection successful");
	    } catch (Exception e) {
	        // Print the exception message
	        e.printStackTrace();
	    }
	    return con;
	}

	// Method to retrieve all events from the database
	public List<event> getallevent() {
		List<event> us = new ArrayList<>();
		Connection con = dbConnection();

		String query = "SELECT * FROM eventde";

		try {

			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String eventid = rs.getString("eventid");
				String eventName= rs.getString("eventName");
				String eventInCharge=rs.getString("eventInCharge");
				String EventDate=rs.getString("EventDate");

				us.add(new event(eventid, eventName, eventInCharge, EventDate));
			}
			System.out.println(" connection succes");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Users retrieved: " + us.size());
		return us;
	}


	public void deleteUser(String eid) {
		Connection con = dbConnection();
		String sql = "DELETE FROM eventde WHERE eventid = '" + eid + "'"; // Note: This is vulnerable to SQL
																				// injection!
		System.out.println("Executing SQL: " + sql);

		try {
			Statement st = con.createStatement();
			int rowsAffected = st.executeUpdate(sql); // Execute the update and get affected rows
			if (rowsAffected > 0) {
				System.out.println("Delete successful for eventid: " + eid);
			} else {
				System.out.println("No user found with eventid: " + eid);
			}

			st.close(); // Close the Statement
			con.close(); // Close the Connection
		} catch (SQLException e) {
			e.printStackTrace(); // Log the exception
		}
		
	}


	public void addNewuser(event pt) {
		
		try {
			Connection con = dbConnection();
			String sql = "INSERT INTO eventde (eventid,eventName,eventInCharge,EventDate) VALUES(?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pt.getEventid()); // Set the mid (member ID)
			ps.setString(2, pt.getEventName()); // Set the name
			ps.setString(3, pt.getEventInCharge()); // Set the mail
			ps.setString(4, pt.getEventDate()); // Set the type

			System.out.println(ps);

			// Execute query
			ps.executeUpdate();

			System.out.println("User inserted successfully");
		} catch (Exception e) {
			e.printStackTrace(); // Print the stack trace to help with debugging
		}
	}

	// Method to select an existing event by its event ID
	public event selectOldevent(String eid) {
		
		Connection con = dbConnection();
		event oldevent = null;

		try {
			String sql = "SELECT * FROM eventde WHERE eventid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, eid);

			System.out.println(ps);

			ResultSet rs = ps.executeQuery();

			// If a matching event is found, populate the event object
			while (rs.next()) {
				String eventid = rs.getString("eventid");
				String eventName= rs.getString("eventName");
				String eventInCharge=rs.getString("eventInCharge");
				String EventDate=rs.getString("EventDate");
				
				oldevent = new event(eventid, eventName, eventInCharge, EventDate);
				System.out.println(oldevent);
			}

			System.out.println(oldevent);
		} catch (Exception e) {

		}
		return oldevent;
	}


	// Method to update an existing event in the database
	public boolean updateOlduser(event updatevent) {
		Connection con = dbConnection();
		boolean update = false;
		try {
			String sql = "UPDATE eventde SET eventName=?,eventInCharge=?,EventDate=? WHERE eventid=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, updatevent.getEventName());
			ps.setString(2, updatevent.getEventInCharge());
			ps.setString(3, updatevent.getEventDate());
			ps.setString(4, updatevent.getEventid());

			System.out.println(ps);
			update = ps.executeUpdate() > 0;

		} catch (Exception e) {

		}

		return update;
	}
	

}
