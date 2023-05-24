package com.ai.persistant.dao;

import java.sql.*;

public class MyConnection {
	static Connection con=null;
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project2_db","root","admin");
			System.out.println("connection...");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver class not found...");
		} catch (SQLException e) {
			System.out.println("Database not found...");
		}
		return con;
	}

}
