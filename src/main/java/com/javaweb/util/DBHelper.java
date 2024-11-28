package com.javaweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

	public static Connection getConnection() throws SQLException {
		
		String DB_URL = "jdbc:mysql://localhost:3306/real_estate";
		String USER = "root";
		String PASS = "";
		
		return DriverManager.getConnection(DB_URL, USER, PASS);
	}
}