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

	public static void createEvent(Event event) {
        try {
            LMSLogger.getInstance().log(LogLevel.TRACE, "Attempting to create event: " + event.getEventName());
            String sql = "INSERT INTO events (event_name, event_description, event_activities, admission_fees) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);

            statement.setString(1, event.getEventName());
            statement.setString(2, event.getEventDescription());
            statement.setString(3, event.getEventActivities());
            statement.setDouble(4, event.getAdmissionFees());
            statement.executeUpdate();

            LMSLogger.getInstance().log(LogLevel.INFO, "Event created successfully: " + event.getEventName());
        } catch (SQLException e) {
            LMSLogger.getInstance().log(LogLevel.ERROR, "Failed to create event: " + e.getMessage());
        }
    }

	public static Event retrieveEvent(int eventId) {
	    Event event = null;
	    try {
	        LMSLogger.getInstance().log(LogLevel.TRACE, "Attempting to retrieve event with ID: " + eventId);
	        String sql = "SELECT * FROM events WHERE event_id = ?";
	        statement = connection.prepareStatement(sql);
	        statement.setInt(1, eventId);
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            String eventName = resultSet.getString("event_name");
	            // Determinar el tipo de evento basado en algún criterio. Esto es solo un ejemplo.
	            switch (eventName) {
	                case "Workshop":
	                    event = new Workshop();
	                    break;
	                case "Book launch":
	                    event = new BookLaunch();
	                    break;
	                case "Movie night":
	                    event = new MovieNight();
	                    break;
	                case "Kids story time":
	                    event = new KidsStoryTime();
	                    break;
	            }
	            // Suponiendo que existen estos métodos para establecer los valores.
	            event.setEventName(resultSet.getString("event_name"));
	            event.setEventDescription(resultSet.getString("event_description"));
	            event.setEventActivities(resultSet.getString("event_activities"));
	            event.setAdmissionFees(resultSet.getDouble("admission_fees"));
	            event.setEventId(resultSet.getInt("event_id"));
	            LMSLogger.getInstance().log(LogLevel.INFO, "Event retrieved successfully: " + event.getEventName());
	        } else {
	            // Solo lograr que no se encontró el evento si resultSet.next() es falso.
	            LMSLogger.getInstance().log(LogLevel.WARN, "No event found with ID: " + eventId);
	        }
	    } catch (SQLException e) {
	        LMSLogger.getInstance().log(LogLevel.ERROR, "Failed to retrieve event with ID " + eventId + ": " + e.getMessage());
	    }
	    return event;
	}


	public static void updateEvent(Event event) {
		try {
            LMSLogger.getInstance().log(LogLevel.TRACE, "Attempting to update event: " + event.getEventName());
			String sql = "UPDATE events SET event_name = ?, event_description = ?, event_activities = ?, admission_fees = ? WHERE event_id = ?";
			statement = connection.prepareStatement(sql);

			statement.setString(1, event.getEventName());
			statement.setString(2, event.getEventDescription());
			statement.setString(3, event.getEventActivities());
			statement.setDouble(4, event.getAdmissionFees());
			statement.setInt(5, event.getEventId()); // Usa el ID del evento aquí

			statement.executeUpdate();

            LMSLogger.getInstance().log(LogLevel.INFO, "Event updated successfully: " + event.getEventName());
		} catch (SQLException e) {
            LMSLogger.getInstance().log(LogLevel.ERROR, "Failed to update event: " + e.getMessage());
		}
	}

	public static void deleteEvent(int eventId) {
		try {
            LMSLogger.getInstance().log(LogLevel.TRACE, "Attempting to delete event with ID: " + eventId);
			String sql = "DELETE FROM events WHERE event_id = ?";
			statement = connection.prepareStatement(sql);

			statement.setInt(1, eventId);
			statement.executeUpdate();

            LMSLogger.getInstance().log(LogLevel.INFO, "Event deleted successfully: ID - " + eventId);
		} catch (SQLException e) {
            LMSLogger.getInstance().log(LogLevel.ERROR, "Failed to delete event: " + e.getMessage());
		}
	}
}
