package com.algonquin.cst8288.assignment2.service;

import com.algonquin.cst8288.assignment2.database.DBOperations;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.logger.LogLevel;
import factory.AcademicLibrary;
import factory.Library;
import factory.PublicLibrary;

public class EventService {

    public void createEvent(Event event) {
        try {
        	
            DBOperations.createEvent(event);
            LMSLogger.getInstance().log(LogLevel.INFO, "Event created successfully: " + event.getEventName());
        } catch (Exception e) {
            LMSLogger.getInstance().log(LogLevel.ERROR, "Failed to create event: " + e.getMessage());
            throw e; // O re-lanzar como una nueva excepción si es necesario.
        }
    }

    public Event getEvent(int eventId) {
        try {
            Event event = DBOperations.retrieveEvent(eventId);
            if (event != null) {
                LMSLogger.getInstance().log(LogLevel.INFO, "Event retrieved successfully: " + eventId);
                return event;
            } else {
                LMSLogger.getInstance().log(LogLevel.WARN, "No event found with ID: " + eventId);
                return null;
            }
        } catch (Exception e) {
            LMSLogger.getInstance().log(LogLevel.ERROR, "Failed to retrieve event: " + e.getMessage());
            throw e; // O manejar de otra manera si es apropiado.
        }
    }

    public void updateEvent(Event event) {
        try {
            DBOperations.updateEvent(event);
            LMSLogger.getInstance().log(LogLevel.INFO, "Event updated successfully: " + event.getEventName());
        } catch (Exception e) {
            LMSLogger.getInstance().log(LogLevel.ERROR, "Failed to update event: " + e.getMessage());
            throw e;
        }
    }

    public void deleteEvent(int eventId) {
        try {
            DBOperations.deleteEvent(eventId);
            LMSLogger.getInstance().log(LogLevel.INFO, "Event deleted successfully: " + eventId);
        } catch (Exception e) {
            LMSLogger.getInstance().log(LogLevel.ERROR, "Failed to delete event: " + e.getMessage());
            throw e;
        }
    }

    public Event createEventFromType(EventType type) {
        Library library;
        switch (type) {
            case WORKSHOP:
            case BOOK_LAUNCH:
                library = new AcademicLibrary();
                break;
            case KIDS_STORY:
            case MOVIE_NIGHT:
                library = new PublicLibrary();
                break;
            default:
                throw new IllegalArgumentException("Event type not recognized");
        }
        return library.createEvent(type);
    }

}
