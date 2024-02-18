package com.algonquin.cst8288.assignment2.factory;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;

/**
 * Abstract class representing a library that can create events.
 * This serves as a base class for specific types of libraries to implement their event creation logic.
 */
public abstract class Library {

	/**
	 * Abstract method to create an event of a specified type.
	 *
	 * @param type The type of event to create, as defined in {@link EventType}.
	 * @return A new {@link Event} object corresponding to the specified type.
	 */
	public abstract Event createEvent(EventType type);

}
