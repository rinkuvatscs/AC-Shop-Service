package com.ac.main.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class SqlConnections {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Alert alert;

	public boolean connections(String username, String password, String role) {

		boolean response = false;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xav_db", "root", "root");
			ps = con.prepareStatement("SELECT * FROM LOGIN WHERE USERNAME = '" + username + "' && PASSWORD = '"
					+ password + "' && ROLE = '" + role + "'");
			rs = ps.executeQuery();
			if (rs.next()) {

				System.out.println("Welcome You Successfully Logged in.");
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Success");
				alert.setHeaderText(username + ", you had logged in");
				alert.showAndWait();
				response = true;

			} else {

				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Check your Credentials");
				alert.showAndWait();
				response = false;
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			response = false;
		}
		return response;
	}
}
