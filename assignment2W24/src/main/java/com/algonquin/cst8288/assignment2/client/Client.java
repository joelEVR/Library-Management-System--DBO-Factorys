package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.service.EventService;

public class Client {

	public static void main(String[] args) {

		// No es necesario instanciar una Library específica aquí, EventService manejará
		// esto internamente
		EventService eventService = new EventService();

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

		// Retrieving an event from the academic library
		int eventIdToRetrieve = 2; // Asume que tienes un evento con este ID
		Event retrievedEvent = eventService.getEvent(eventIdToRetrieve);
		System.out.println(retrievedEvent.toString());

		// Eliminar un evento específico.
		eventService.deleteEvent(3);

		// ID del evento a actualizar y los nuevos valores
		int eventIdToUpdate = 4; // Asume que tienes un evento con este ID
		String newName = "Workshop";
		String newDescription = "New Description of the Event";
		String newActivities = "New Activities of the Event";
		double newAdmissionFees = 25.0;

		// Actualizar el evento
		eventService.updateEvent(eventIdToUpdate, newName, newDescription, newActivities, newAdmissionFees);
	}
}