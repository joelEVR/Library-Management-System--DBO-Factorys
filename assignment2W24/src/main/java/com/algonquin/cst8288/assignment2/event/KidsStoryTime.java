package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;

/**
 * Represents a kids story time event.
 * This class extends the {@link Event} class and calculates the admission fee for a kids story time.
 */
public class KidsStoryTime extends Event {

	/**
	 * Calculates the admission fee for a kids story time event.
	 * The fee is calculated based on predefined rates and duration constants.
	 */
	@Override
	public void calculateAdmissionFee() {
		this.admissionFees = Constants.KIDS_STORYTIME_RATE * Constants.KIDS_STORYTIME_DURATION;
	}
}
