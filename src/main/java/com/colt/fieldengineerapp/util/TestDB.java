package com.colt.fieldengineerapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://localhost:3306/qadb";

		try {
			Connection conn = DriverManager.getConnection(url, "root", "root");
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("Select * from credentials where scenario='zerobalcard'");

			while (rs.next()) {
				System.out.println(rs.getString("username"));
				System.out.println(rs.getString("password"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
