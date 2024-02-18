package com.algonquin.cst8288.assignment2.service;

import com.algonquin.cst8288.assignment2.database.DBOperations;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.logger.LogLevel;
import factory.AcademicLibrary;
import factory.Library;
import factory.PublicLibrary;

/**
 * Provides services related to event management including creation, retrieval, update, and deletion of events.
 */
public class EventService {

    /**
     * Determines the appropriate Library instance based on the event type.
     *
     * @param type The type of the event.
     * @return A Library instance that corresponds to the given event type.
     * @throws IllegalArgumentException If the event type is not recognized.
     */
    private Library determineLibrary(EventType type) {
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
    
    /**
     * Creates an event based on the provided parameters.
     *
     * @param type The type of the event.
     * @param name The name of the event.
     * @param description The description of the event.
     * @param activities The activities involved in the event.
     * @return The created event.
     */
    public Event createEvent(EventType type, String name, String description, String activities) {
        Library library = determineLibrary(type);
        Event event = library.createEvent(type); // Create the event using the appropriate factory
        event.setEventName(name);
        event.setEventDescription(description);
        event.setEventActivities(activities);
        event.calculateAdmissionFee(); // Calculate the specific admission fee for the event
        DBOperations.createEvent(event); // Creation logic and relevant logs are handled by DBOperations

        return event;
    }

    /**
     * Retrieves an event by its ID.
     *
     * @param eventId The ID of the event to retrieve.
     * @return The event if found, otherwise null.
     */
    public Event getEvent(int eventId) {
        Event event = DBOperations.retrieveEvent(eventId); // Retrieval logic and relevant logs are handled by DBOperations
        if (event == null) {
            LMSLogger.getInstance().log(LogLevel.WARN, "No event found with ID: " + eventId);
        }
        return event;
    }

    /**
     * Updates an existing event with new details.
     *
     * @param eventId The ID of the event to update.
     * @param newName The new name of the event.
     * @param newDescription The new description of the event.
     * @param newActivities The new activities of the event.
     * @param newAdmissionFees The new admission fees for the event.
     */
    public void updateEvent(int eventId, String newName, String newDescription, String newActivities, double newAdmissionFees) {
        Event eventToUpdate = this.getEvent(eventId);
        if (eventToUpdate != null) {
            eventToUpdate.setEventName(newName);
            eventToUpdate.setEventDescription(newDescription);
            eventToUpdate.setEventActivities(newActivities);
            eventToUpdate.setAdmissionFees(newAdmissionFees);
            DBOperations.updateEvent(eventToUpdate); // Update logic and relevant logs are handled by DBOperations
        } else {
            LMSLogger.getInstance().log(LogLevel.WARN, "The event with ID " + eventId + " was not found.");
        }
    }

    /**
     * Deletes an event by its ID.
     *
     * @param eventId The ID of the event to delete.
     */
    public void deleteEvent(int eventId) {
        DBOperations.deleteEvent(eventId); // Deletion logic and relevant logs are handled by DBOperations
    }
}
