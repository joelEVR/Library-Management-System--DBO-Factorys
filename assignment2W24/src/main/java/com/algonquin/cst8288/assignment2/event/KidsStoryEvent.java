package com.algonquin.cst8288.assignment2.event;
import com.algonquin.cst8288.assignment2.constants.Constants;

public class KidsStoryEvent extends Event{
	
	public KidsStoryEvent(String eventName, String eventActivities, String description) {
		this.eventName = eventName;
		this.eventActivities = eventActivities;
		this.eventDescription = description;
	}
	

	@Override
	public void calculateAdmissionFee() {
		double duration = Constants.KIDS_STORYTIME_DURATION;
		int rate = (int) Constants.KIDS_STORYTIME_RATE;
		this.admissionFees = duration * rate;
	}
}
