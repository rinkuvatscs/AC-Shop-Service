package com.ac.main.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import com.ac.pojo.UserDetail;
import com.ac.pojo.UserDetails;

public class SqlConnections {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Alert alert;

	// @Value("{all.employee.show}
	boolean isAllEmployeeShow = true; // AS of now from hard code

	public boolean connections(String username, String password, String role) {

		boolean response = false;
		try {
			if (con == null) {
				con = connection();
			}
			ps = con.prepareStatement("SELECT * FROM LOGIN WHERE USERNAME =? and PASSWORD = ? and ROLE = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, role);
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

	public String addUser(List<UserDetail> userDetailsList) {

		if (con == null) {
			con = connection();
		}

		return "";
	}

	public List<UserDetails> getUser(List<UserDetail> userDetailsList) {

		if (con == null) {
			con = connection();
		}

		// StringBuffer stringBuffer = new
		// StringBuffer("SELECT * FROM userdetail ");

		boolean isRecordExist = false;
		// boolean isName = false, isMobile = false, isEmail = false;
		UserDetails userDetails = null;
		List<UserDetails> detailsList = new ArrayList<UserDetails>();
		try {
			String sql = "SELECT * FROM userdetail WHERE name = ? OR mobile = ? OR email = ? or username = ? ";
			ps = con.prepareStatement(sql);
			if (userDetailsList != null && userDetailsList.size() > 0) {
				/*
				 * if (!StringUtils.isEmpty(userDetailsList.get(0).getValue()))
				 * { stringBuffer.append(" WHERE name = ? "); ps.setString(1,
				 * userDetailsList.get(0).getValue()); isName = true; } if
				 * (isName) { if
				 * (!StringUtils.isEmpty(userDetailsList.get(1).getValue())) {
				 * stringBuffer.append(" && mobile ? "); ps.setString(2,
				 * userDetailsList.get(1).getValue()); isMobile = true; } else {
				 * 
				 * } } else { stringBuffer.append(" WHERE mobile ? ");
				 * ps.setString(1, userDetailsList.get(1).getValue()); } if
				 * (isMobile) { if
				 * (!StringUtils.isEmpty(userDetailsList.get(2).getValue())) {
				 * stringBuffer.append(" && email ? "); ps.setString(3,
				 * userDetailsList.get(2).getValue()); isMobile = true; } else {
				 * 
				 * } } else { stringBuffer.append(" WHERE email ? ");
				 * ps.setString(1, userDetailsList.get(2).getValue()); } if
				 * (isEmail) { if
				 * (!StringUtils.isEmpty(userDetailsList.get(2).getValue())) {
				 * stringBuffer.append(" && username ? "); ps.setString(4,
				 * userDetailsList.get(3).getValue()); isMobile = true; } else {
				 * 
				 * } } else { stringBuffer.append(" WHERE username ? ");
				 * ps.setString(1, userDetailsList.get(3).getValue()); }
				 * 
				 * System.out.println(stringBuffer);
				 */

				ps.setString(1, userDetailsList.get(0).getValue());
				ps.setString(2, userDetailsList.get(1).getValue());
				ps.setString(3, userDetailsList.get(2).getValue());
				ps.setString(4, userDetailsList.get(3).getValue());
				rs = ps.executeQuery();
				if (rs.next()) {
					userDetails = new UserDetails(rs.getString("username"),
							rs.getString("name"), rs.getString("email"),
							rs.getString("mobile"));
					detailsList.add(userDetails);
					isRecordExist = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (isAllEmployeeShow) {
			if (!isRecordExist) {
				String sql = "SELECT * FROM userdetail ";
				try {
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();
					while (rs.next()) {
						userDetails = new UserDetails(rs.getString("username"),
								rs.getString("name"), rs.getString("email"),
								rs.getString("mobile"));
						detailsList.add(userDetails);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
		return detailsList;
	}

	private Connection connection() {

		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://10.1.249.41:3306/ac_service", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
