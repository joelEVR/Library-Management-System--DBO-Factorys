package com.algonquin.cst8288.assignment2.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.algonquin.cst8288.assignment2.event.BookLaunch;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.KidsStoryTime;
import com.algonquin.cst8288.assignment2.event.MovieNight;
import com.algonquin.cst8288.assignment2.event.Workshop;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.logger.LogLevel;

public class DBOperations {

	// Database connection object
    private static Connection connection = DBConnection.getInstance().getConnection();
    private static PreparedStatement statement;
    private static ResultSet resultSet;
	
    public static void createEvent(Event event) {
        try {
            String sql = "INSERT INTO events (event_name, event_description, event_activities, admission_fees) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, event.getEventName());
            statement.setString(2, event.getEventDescription());
            statement.setString(3, event.getEventActivities());
            statement.setDouble(4, event.getAdmissionFees());
            statement.executeUpdate();
            
            LMSLogger.getInstance().log(LogLevel.INFO, "Event created: " + event.getEventName());
        } catch (SQLException e) {
            LMSLogger.getInstance().log(LogLevel.ERROR, "Failed to create event: " + e.getMessage());
        }
    }

    public static Event retrieveEvent(int eventId) {
        Event event = null;
        try {
            LMSLogger.getInstance().log(LogLevel.TRACE, "Retrieving event...");
            String sql = "SELECT * FROM events WHERE event_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, eventId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String eventName = resultSet.getString("event_name");
                    if (eventName.equals("Workshop")) {
                        event = new Workshop();
                    } else if (eventName.equals("Book launch")) {
                        event = new BookLaunch();
                    } else if (eventName.equals("Movie night")) {
                        event = new MovieNight();
                    } else if (eventName.equals("Kids story time")) {
                        event = new KidsStoryTime();
                    }
                        event.setEventName(resultSet.getString("event_name"));
                        event.setEventDescription(resultSet.getString("event_description"));
                        event.setEventActivities(resultSet.getString("event_activities"));
                        event.setAdmissionFees(resultSet.getDouble("admission_fees"));
                }
            }
            LMSLogger.getInstance().log(LogLevel.INFO, "Event retrieved: " + (event != null ? event.getEventName() : "Not found"));
        } catch (SQLException e) {
            LMSLogger.getInstance().log(LogLevel.ERROR, "Failed to retrieve event: " + e.getMessage());
        }
        return event;
    }


    public static void updateEvent(Event event) {
        String sql = "UPDATE events SET event_name = ?, event_description = ?, event_activities = ?, admission_fees = ? WHERE event_id = ?";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setString(1, event.getEventName());
            statement.setString(2, event.getEventDescription());
            statement.setString(3, event.getEventActivities());
            statement.setDouble(4, event.getAdmissionFees());
            
            statement.executeUpdate();
            
            LMSLogger.getInstance().log(LogLevel.INFO, "Event updated: " + event.getEventName());
        } catch (SQLException e) {
            LMSLogger.getInstance().log(LogLevel.ERROR, "Failed to update event: " + e.getMessage());
        }
    }

    public static void deleteEvent(int eventId) {
        String sql = "DELETE FROM events WHERE event_id = ?";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setInt(1, eventId);
            statement.executeUpdate();
            
            LMSLogger.getInstance().log(LogLevel.INFO, "Event deleted: ID - " + eventId);
        } catch (SQLException e) {
            LMSLogger.getInstance().log(LogLevel.ERROR, "Failed to delete event: " + e.getMessage());
        }
    }
}
