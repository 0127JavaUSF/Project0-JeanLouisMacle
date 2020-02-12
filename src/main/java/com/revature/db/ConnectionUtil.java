package com.revature.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public static Connection getConnection() {
		/*
		 * Values stored in System environment variables.  Note: Spring tools suite
		 * will not have access to new environment variables until you restart it.
		 */
		String url = System.getenv("PROJECT0_URL") ;
		String user = System.getenv("PROJECT0_USER");
		String password = System.getenv("PROJECT0_PASSWORD");
		// jdbc:postgresql://host:port/postgres
		
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("Exception thrown while trying to connect to the database");
			e.printStackTrace();
		}
		
		return null;
	}

}
