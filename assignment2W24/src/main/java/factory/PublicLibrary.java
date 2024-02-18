package factory;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.event.KidsStoryTime;
import com.algonquin.cst8288.assignment2.event.MovieNight;

/**
 * Represents a public library that can create specific types of events.
 * This class extends {@link Library} and implements the method to create events specific to a public context.
 */
public class PublicLibrary extends Library {

	/**
	 * Creates an event based on the specified type for a public library.
	 *
	 * @param type The type of event to create, as defined in {@link EventType}.
	 * @return A new instance of an {@link Event} subclass corresponding to the specified type.
	 * @throws IllegalArgumentException If the event type is not recognized for a public library.
	 */
	@Override
	public Event createEvent(EventType type) {
		switch (type) {
		case KIDS_STORY:
			return new KidsStoryTime();
		case MOVIE_NIGHT:
			return new MovieNight();
		default:
			throw new IllegalArgumentException("Event type not recognized");
		}
	}
}