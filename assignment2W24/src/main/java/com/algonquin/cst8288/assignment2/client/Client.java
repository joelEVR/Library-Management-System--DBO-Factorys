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
		Event retrievedEvent = eventService.getEvent(4);
		System.out.println(retrievedEvent.toString());

		// Eliminar un evento específico.
		eventService.deleteEvent(2);

		
		 // ID del evento a actualizar y los nuevos valores
        int eventIdToUpdate = 4; // Asume que tienes un evento con este ID
        String newName = "New Name of the Event`";
        String newDescription = "New Description of the Event`";
        String newActivities = "New Activities of the Event`";
        double newAdmissionFees = 25.0;

        // Actualizar el evento
        eventService.updateEventById(eventIdToUpdate, newName, newDescription, newActivities, newAdmissionFees);
    }
	}
/*
*/
/*
 * // Create a new EventFactory object Library eventFactory = new
 * AcademicLibrary();
 * 
 * 
 * 
 * 
 * 
 * // Print the event name, event activities, and event description
 * System.out.println("Event Name: " + event.getEventName());
 * System.out.println("Event Activities: " + event.getEventActivities());
 * System.out.println("Event Description: " + event.getEventDescription());
 * 
 * // Calculate the admission fee for the event event.calculateAdmissionFee();
 * 
 * // Print the admission fee for the event System.out.println("Admission Fee: "
 * + event.getAdmissionFees()); }
 */

/*
 * // Create a new EventFactory object Library eventFactory = new
 * AcademicLibrary();
 * 
 * // Create a new Event object using the EventFactory object Event event =
 * eventFactory.createEvent("Movie Night");
 * 
 * // Print the event name, event activities, and event description
 * System.out.println("Event Name: " + event.getEventName());
 * System.out.println("Event Activities: " + event.getEventActivities());
 * System.out.println("Event Description: " + event.getEventDescription());
 * 
 * // Calculate the admission fee for the event event.calculateAdmissionFee();
 * 
 * // Print the admission fee for the event System.out.println("Admission Fee: "
 * + event.getAdmissionFees());
 */

/*
 * Connection con = null;
 * 
 * try { String url = "jdbc:mysql://localhost:3306/mysql"; String username =
 * "root"; String password = "orbeaMX30.,";
 * 
 * // Class.forName("com.mysql.jdbc.Driver"); con =
 * DriverManager.getConnection(url, username, password);
 * 
 * if (con != null) {
 * System.out.println("Successfully connected to MySQL database test"); }
 * 
 * } catch (SQLException ex) {
 * System.out.println("An error occurred while connecting MySQL databse");
 * ex.printStackTrace(); } }
 */