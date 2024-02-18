package com.algonquin.cst8288.assignment2.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * A singleton logger class for logging messages with various log levels.
 * It supports logging messages to the console and a log file named "server.log".
 */
public class LMSLogger {

    private static LMSLogger instance; // Singleton instance of the logger
    private List<String> logs; // List to store log messages
    private LogLevel logLevel; // Current log level
    private PrintWriter fileWriter; // Writer for log file

    /**
     * Private constructor to prevent external instantiation.
     * Initializes the logger with default settings.
     */
    private LMSLogger() {
        logLevel = LogLevel.TRACE; // Default log level
        logs = new ArrayList<>(); // Initialize list to store log messages
        try {
            // Initialize file writer for logging to a file
            fileWriter = new PrintWriter(new FileWriter("server.log", true));
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace if an IOException occurs
        }
    }

    /**
     * Returns the singleton instance of the LMSLogger.
     * 
     * @return The single instance of LMSLogger.
     */
    public static synchronized LMSLogger getInstance() {
        if (instance == null) {
            instance = new LMSLogger();
        }
        return instance;
    }

    /**
     * Sets the log level for the logger.
     * 
     * @param level The log level to set.
     */
    public void setLogLevel(LogLevel level) {
        this.logLevel = level;
    }

    /**
     * Logs a message with the specified log level.
     * The message is logged to the console and written to the log file if its level is
     * equal to or higher than the logger's current level.
     * 
     * @param level   The log level of the message.
     * @param message The message to log.
     */
    public void log(LogLevel level, String message) {
        if (level.ordinal() >= this.logLevel.ordinal()) {
            String logMessage = String.format("%s: [%s] %s", level, LocalDateTime.now(), message);
            System.out.println(logMessage); // Print log message to console
            fileWriter.println(logMessage); // Write log message to file
            fileWriter.flush(); // Flush the writer to ensure the message is written
        }
        logs.add(String.format("%s: [%s] %s", level, LocalDateTime.now(), message)); // Add log message to the list
    }

    /**
     * Displays all logged messages in the console.
     * This method is useful for debugging or reviewing all log messages generated.
     */
    public void displayLogs() {
        logs.forEach(System.out::println);
    }

    /**
     * Closes the logger and the associated file writer.
     * This method ensures that all resources are properly released.
     */
    public void close() {
        log(LogLevel.TRACE, "Closing the logger...");
        if (fileWriter != null) {
            fileWriter.close(); // Close the file writer
        }
    }
}
