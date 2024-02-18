package factory;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;

public abstract class Library {

	public abstract Event createEvent(EventType type);

}
