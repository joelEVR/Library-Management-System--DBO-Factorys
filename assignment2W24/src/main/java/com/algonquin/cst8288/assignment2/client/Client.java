package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.event.Event;

import factory.CreatorAcademicLibrary;
import factory.Library;

public class Client {
	
	public static void main(String[] args) {
		
		// Create a new EventFactory object
		Library eventFactory = new AcademicLibrary();

		// Create a new Event object using the EventFactory object
		Event event = eventFactory.createEvent("Movie Night");

		// Print the event name, event activities, and event description
		System.out.println("Event Name: " + event.getEventName());
		System.out.println("Event Activities: " + event.getEventActivities());
		System.out.println("Event Description: " + event.getEventDescription());

		// Calculate the admission fee for the event
		event.calculateAdmissionFee();

		// Print the admission fee for the event
		System.out.println("Admission Fee: " + event.getAdmissionFees());
		
		
	}
}
