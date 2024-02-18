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


 
    
    public Event createEvent(EventType type, String name, String description, String activities) {
        LMSLogger.getInstance().log(LogLevel.TRACE, "Entering createEvent method...");
        Library library = determineLibrary(type); // Determinar la biblioteca basada en el tipo de evento

        try {
            Event event = library.createEvent(type); // Crear el evento usando la fábrica adecuada
            event.setEventName(name);
            event.setEventDescription(description);
            event.setEventActivities(activities);
            event.calculateAdmissionFee(); // Calcular el fee específico del evento
            DBOperations.createEvent(event); // Persistir el evento en la base de datos
            LMSLogger.getInstance().log(LogLevel.INFO, "Event created successfully: " + name);
            return event;
        } catch (Exception e) {
            LMSLogger.getInstance().log(LogLevel.ERROR, "Failed to create event: " + e.getMessage());
            throw new RuntimeException("Failed to create event.", e);
        }
    }

    private Library determineLibrary(EventType type) {
        // Esta lógica asume que tienes un método o una manera de decidir qué Library usar
        switch (type) {
            case WORKSHOP:
            case BOOK_LAUNCH:
                return new AcademicLibrary();
            case KIDS_STORY:
            case MOVIE_NIGHT:
                return new PublicLibrary();
            default:
                throw new IllegalArgumentException("Event type not recognized");
        }
    }

	public Event getEvent(int eventId) {
		try {
			Event event = DBOperations.retrieveEvent(eventId);
				LMSLogger.getInstance().log(LogLevel.INFO, "Event retrieved successfully: " + eventId);
				return event;
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
}
