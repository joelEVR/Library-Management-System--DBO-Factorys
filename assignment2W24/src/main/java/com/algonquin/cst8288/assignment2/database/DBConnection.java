package com.algonquin.cst8288.assignment2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.logger.LogLevel;

/**
 * Handles database connection using the singleton design pattern to ensure that only one instance of the database connection is used throughout the application.
 */
public class DBConnection {

    /**
     * The singleton instance of DBConnection.
     */
    private static DBConnection instance;

    /**
     * The database connection object.
     */
    private static Connection connection;

    /**
     * The URL of the database server.
     */
    private String serverUrl = "jdbc:mysql://localhost:3306/bookvault";

    /**
     * The username for the database server.
     */
    private String userString = "root";

    /**
     * The password for the database server.
     */
    private String passwordString = "orbeaMX30.,";

    /**
     * The JDBC driver string for the database connection.
     */
    private String driverString = "com.mysql.cj.jdbc.Driver";

    /**
     * Private constructor to prevent instantiation from outside this class.
     * Initializes the database connection.
     */
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

    /**
     * Returns the singleton instance of the DBConnection class, creating it if it does not already exist.
     * 
     * @return The singleton instance of the DBConnection class.
     */
    public static synchronized DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    /**
     * Returns the database connection.
     * 
     * @return The database connection object.
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Closes the database connection if it is not null.
     */
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
