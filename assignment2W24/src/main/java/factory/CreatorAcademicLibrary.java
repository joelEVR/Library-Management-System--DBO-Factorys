package factory;

import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.event.KidsStoryEvent;
import com.algonquin.cst8288.assignment2.event.MovieNightEvent;
import com.algonquin.cst8288.assignment2.event.Event;

public class CreatorAcademicLibrary extends CreatorLibrary {

	CreatorAcademicLibrary creatorAcademicLibrary;
	
	
	@Override
	public Event createEvent(String eventName, String eventActivities, String eventDescription) {
		switch (EventType.KIDS_STORY) {
		case KIDS_STORY:
			return new KidsStoryEvent(eventDescription, eventDescription, eventDescription);
		case MOVIE_NIGHT:
			return new MovieNightEvent(eventDescription, eventDescription, eventDescription);
		default:
			throw new IllegalArgumentException("Unexpected value: " + EventType.KIDS_STORY);
		}
	}
}
