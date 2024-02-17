package factory;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.event.KidsStoryTime;
import com.algonquin.cst8288.assignment2.event.MovieNight;

public class PublicLibrary extends Library {
    
	
	@Override
    public Event createEvent(EventType type) {
        switch(type) {
            case KIDS_STORY:
                return new KidsStoryTime();
            case MOVIE_NIGHT:
                return new MovieNight();
            default:
                throw new IllegalArgumentException("Event type not recognized");
        }
    }
}
