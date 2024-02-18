package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.database.DBConnection;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.service.EventService;

/**
 * A client class to demonstrate the functionality of the event management system.
 * This class uses the EventService to create, retrieve, update, and delete events.
 */
public class Client {

	public static void main(String[] args) {

		// Instantiate EventService to handle event operations internally
		EventService eventService = new EventService();

		// Creating various types of events
		eventService.createEvent(EventType.WORKSHOP, "Workshop", "A deep dive into advanced Java topics",
				"Presentations, coding sessions, and discussions");

		eventService.createEvent(EventType.BOOK_LAUNCH, "Book launch",
				"Introduction and discussion of the new edition of 'Effective Java'",
				"Book signing and meet the author");

		eventService.createEvent(EventType.KIDS_STORY, "Kids story time",
				"Stories to get kids interested in coding through fairy tales",
				"Reading sessions and interactive coding games");

		eventService.createEvent(EventType.MOVIE_NIGHT, "Movie night",
				"Screening of a popular sci-fi movie that inspires technology innovations",
				"Post-movie discussion on technology in sci-fi");

		// Retrieving an event from the database
		int eventIdToRetrieve = 2; // Assume you have an event with this ID
		Event retrievedEvent = eventService.getEvent(eventIdToRetrieve);
		System.out.println(retrievedEvent.toString());

		// Delete a specific event
		eventService.deleteEvent(3);

		// Event ID to update and the new values
		int eventIdToUpdate = 4; 
		String newName = "Workshop";
		String newDescription = "New Description of the Event";
		String newActivities = "New Activities of the Event";
		double newAdmissionFees = 25.0;

		// Update the event
		eventService.updateEvent(eventIdToUpdate, newName, newDescription, newActivities, newAdmissionFees);
		
		// Closing database connection and logger to release resources
		DBConnection.getInstance().closeConnection();
        LMSLogger.getInstance().close();
	}
}
