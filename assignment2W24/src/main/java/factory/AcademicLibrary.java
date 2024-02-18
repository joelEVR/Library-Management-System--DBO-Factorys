package factory;

import com.algonquin.cst8288.assignment2.event.BookLaunch;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.event.Workshop;

/**
 * Represents an academic library that can create specific types of events.
 * This class extends {@link Library} and implements the method to create events specific to an academic context.
 */
public class AcademicLibrary extends Library {

	/**
	 * Creates an event based on the specified type for an academic library.
	 *
	 * @param type The type of event to create, as defined in {@link EventType}.
	 * @return A new instance of an {@link Event} subclass corresponding to the specified type.
	 * @throws IllegalArgumentException If the event type is not recognized for an academic library.
	 */
	@Override
	public Event createEvent(EventType type) {
		switch (type) {
		case WORKSHOP:
			return new Workshop();
		case BOOK_LAUNCH:
			return new BookLaunch();
		default:
			throw new IllegalArgumentException("Event type not recognized");
		}
	}
}