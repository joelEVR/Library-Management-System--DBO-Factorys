package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;

/**
 * Represents a movie night event.
 * This class extends the {@link Event} class and calculates the admission fee for a movie night.
 */
public class MovieNight extends Event {

	/**
	 * Calculates the admission fee for a movie night event.
	 * The fee is calculated based on predefined rates and duration constants.
	 */
	@Override
	public void calculateAdmissionFee() {
		this.admissionFees = Constants.MOVIE_NIGHT_RATE * Constants.MOVIE_NIGHT_DURATION;
	}

}