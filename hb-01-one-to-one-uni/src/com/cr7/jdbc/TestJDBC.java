package com.cr7.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		try {
			System.out.println("Connecting to the database");
			Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection successfull");
		} catch (Exception ex) {
			System.out.println("Nooooooooooooo");
		}
	}

}
