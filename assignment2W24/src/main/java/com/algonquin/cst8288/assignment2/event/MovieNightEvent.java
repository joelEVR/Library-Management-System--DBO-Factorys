package com.algonquin.cst8288.assignment2.event;
import com.algonquin.cst8288.assignment2.constants.Constants;

public class MovieNightEvent extends Event {

	private String eventName;
	private String eventActivities;
	private String eventDescription;
	private double admissionFees;
	
	
	
	public MovieNightEvent(String eventName, String eventActivities, String description) {
		this.eventName = eventName;
		this.eventActivities = eventActivities;
		this.eventDescription = description;
	}

	@Override
	public void calculateAdmissionFee() {
		double duration = Constants.MOVIE_NIGHT_DURATION;
		int rate = (int) Constants.MOVIE_NIGHT_RATE;
		this.admissionFees = duration * rate;
	}

}