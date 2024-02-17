package com.algonquin.cst8288.assignment2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection connection = null;

	private String serverUrl = "jdbc:mysql://localhost:3306/bookvault";
	private String userString = "***";
	private String passwordString = "***";
	private String driverString = "com.mysql.cj.jdbc.Driver";

	// Private constructor
	private DBConnection() {
		// Load the JDBC driver
		try {
			Class.forName(driverString);
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // Consider proper logging
		}

		// Establish database connection
		try {
			connection = DriverManager.getConnection(serverUrl, userString, passwordString);
		} catch (SQLException e) {
			e.printStackTrace(); // Consider proper logging
		}
	}

	// Public method to return the single instance of Connection
    public static Connection getConnection() {
        if (connection == null) { // First check (no locking)
            synchronized (DBConnection.class) {
                if (connection == null) { // Second check (with locking)
                    new DBConnection();
                }
            }
        }
        return connection;
    }

	// Optional: Method to close the connection
	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				connection = null; // Help garbage collector
			} catch (SQLException e) {
				e.printStackTrace(); // Consider proper logging
			}
		}
	}
}
