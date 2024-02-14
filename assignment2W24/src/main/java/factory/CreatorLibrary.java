package factory;

import com.algonquin.cst8288.assignment2.event.Event;

public  abstract class CreatorLibrary{
			
	public abstract Event createEvent(String eventName, String eventActivities, String eventDescription);

}
