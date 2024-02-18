package com.algonquin.cst8288.assignment2.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.service.EventService;

import factory.Library;

public class DBOperations {

    public static void createEvent(Event event) {
        String sql = "INSERT INTO events (event_name, event_description, event_activities, admission_fees) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, event.getEventName());
            pstmt.setString(2, event.getEventDescription());
            pstmt.setString(3, event.getEventActivities());
            pstmt.setDouble(4, event.getAdmissionFees());
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                // Event was created successfully
            }
            
        } catch (SQLException e) {
            e.printStackTrace(); // Consider proper logging
        }
    }

    public static Event retrieveEvent(int event_id) {
        String sql = "SELECT, event_name, event_description, event_activities, admission_fees FROM events WHERE event_id = ?";
        Event event = null;
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, event_id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                EventType type = EventType.valueOf(rs.getString("event_type"));
                EventService eventService = new EventService();
                event = eventService.createEventFromType(type);
                event.setEventName(rs.getString("event_name"));
                event.setEventDescription(rs.getString("event_description"));
                event.setEventActivities(rs.getString("event_activities"));
                event.setAdmissionFees(rs.getDouble("admission_fees"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace(); // Consider proper logging
        }
        
        return event;
    }

    public static void updateEvent(Event event) {
        String sql = "UPDATE events SET event_name = ?, event_description = ?, event_activities = ?, admission_fees = ? WHERE id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, event.getEventName());
            pstmt.setString(2, event.getEventDescription());
            pstmt.setString(3, event.getEventActivities());
            pstmt.setDouble(4, event.getAdmissionFees());
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                // Event was updated successfully
            }
            
        } catch (SQLException e) {
            e.printStackTrace(); // Consider proper logging
        }
    }

    public static void deleteEvent(int event_id) {
        String sql = "DELETE FROM events WHERE id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, event_id);
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                // Event was deleted successfully
            }
            
        } catch (SQLException e) {
            e.printStackTrace(); // Consider proper logging
        }
    }
}

