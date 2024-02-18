package com.algonquin.cst8288.assignment2.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.service.EventService;

import factory.AcademicLibrary;
import factory.Library;

public class Client {

	public static void main(String[] args) {
		
		        // Crear una instancia de EventService
		        EventService eventService = new EventService();

		        // Definir los detalles del evento
		        EventType type = EventType.WORKSHOP; // Tipo de evento
		        // Suponiendo que existe un constructor en tus clases concretas de Event que acepte estos parámetros
		        String eventName = "Java Design Patterns";
		        String eventDescription = "A workshop on Java design patterns";
		        String eventActivities = "Lectures, hands-on sessions";
		        double admissionFees = 50.00;

		        // Crear el evento usando la fábrica correspondiente basada en el tipo
		        Event event = eventService.createEventFromType(type);
		        event.setEventName(eventName);
		        event.setEventDescription(eventDescription);
		        event.setEventActivities(eventActivities);
		        event.setAdmissionFees(admissionFees);

		        // Guardar el evento en la base de datos
		        eventService.createEvent(event);

		        System.out.println("Evento creado y guardado en la base de datos con éxito.");
		    }
	}
		/*// Create a new EventFactory object
		Library eventFactory = new AcademicLibrary();
		
		

		

		// Print the event name, event activities, and event description
		System.out.println("Event Name: " + event.getEventName());
		System.out.println("Event Activities: " + event.getEventActivities());
		System.out.println("Event Description: " + event.getEventDescription());

		// Calculate the admission fee for the event
		event.calculateAdmissionFee();

		// Print the admission fee for the event
		System.out.println("Admission Fee: " + event.getAdmissionFees());
	}*/


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