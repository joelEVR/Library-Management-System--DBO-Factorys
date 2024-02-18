package com.algonquin.cst8288.assignment2.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LMSLogger {

    private static LMSLogger instance; // Singleton instance of the logger
    private List<String> logs; // List to store log messages
    private LogLevel logLevel; // Current log level
    private PrintWriter fileWriter; // Writer for log file

    // Private constructor to prevent external instantiation
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

    // Returns the singleton instance of the LMSLogger
    public static synchronized LMSLogger getInstance() {
        if (instance == null) {
            instance = new LMSLogger();
        }
        return instance;
    }

    // Sets the log level for the logger
    public void setLogLevel(LogLevel level) {
        this.logLevel = level;
    }

    // Logs a message with the specified log level
    public void log(LogLevel level, String message) {
        if (level.ordinal() >= this.logLevel.ordinal()) {
            String logMessage = String.format("%s: [%s] %s", level, LocalDateTime.now(), message);
            System.out.println(logMessage); // Print log message to console
            fileWriter.println(logMessage); // Write log message to file
            fileWriter.flush(); // Flush the writer to ensure the message is written
        }
        logs.add(String.format("%s: [%s] %s", level, LocalDateTime.now(), message)); // Add log message to the list
    }

    // Displays all logged messages in the console
    public void displayLogs() {
        logs.forEach(System.out::println);
    }

    // Closes the logger and the associated file writer
    public void close() {
        log(LogLevel.TRACE, "Closing the logger...");
        if (fileWriter != null) {
            fileWriter.close(); // Close the file writer
        }
    }
}
