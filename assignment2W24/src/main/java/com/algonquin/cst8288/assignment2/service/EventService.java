package com.algonquin.cst8288.assignment2.service;

import com.algonquin.cst8288.assignment2.database.DBOperations;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import factory.AcademicLibrary;
import factory.PublicLibrary;
import factory.Library;

public class EventService {

    public void createEvent(Event event) {
        DBOperations.createEvent(event);
    }

    public Event getEvent(int eventId) {
        return DBOperations.retrieveEvent(eventId);
    }

    public void updateEvent(Event event) {
        DBOperations.updateEvent(event);
    }

    public void deleteEvent(int eventId) {
        DBOperations.deleteEvent(eventId);
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
