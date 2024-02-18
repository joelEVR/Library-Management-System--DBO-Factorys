package com.algonquin.cst8288.assignment2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.logger.LogLevel;

public class DBConnection {
	
    private static DBConnection instance; // Singleton instance of DBConnection
   
    private static Connection connection; // Non-static connection field

    private String serverUrl = "jdbc:mysql://localhost:3306/bookvault";
    private String userString = "root";
    private String passwordString = "orbeaMX30.,";
    private String driverString = "com.mysql.cj.jdbc.Driver";

    // Private constructor
    private DBConnection() {
        try {
            Class.forName(driverString);
            connection = DriverManager.getConnection(serverUrl, userString, passwordString);
            LMSLogger.getInstance().log(LogLevel.INFO, "Database connection established");
        } catch (ClassNotFoundException e) {
            LMSLogger.getInstance().log(LogLevel.ERROR, "Database driver not found: " + e.getMessage());
        } catch (SQLException e) {
            LMSLogger.getInstance().log(LogLevel.ERROR, "Failed to establish database connection: " + e.getMessage());
        }
    }

    // Method to get the singleton instance of DBConnection
    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    // Public method to get the connection
    public Connection getConnection() {
        return connection;
    }

    // Method to close the database connection
    public synchronized void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                LMSLogger.getInstance().log(LogLevel.INFO, "Database connection closed successfully");
            } catch (SQLException e) {
                LMSLogger.getInstance().log(LogLevel.ERROR, "Failed to close database connection: " + e.getMessage());
            }
        }
    }
}