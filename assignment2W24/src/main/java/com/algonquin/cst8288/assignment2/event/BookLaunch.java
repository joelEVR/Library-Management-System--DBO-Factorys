package com.algonquin.cst8288.assignment2.event;
import com.algonquin.cst8288.assignment2.constants.Constants;

/**
 * Represents a book launch event.
 * This class extends the {@link Event} class and calculates the admission fee for a book launch.
 */
public class BookLaunch extends Event {

	/**
	 * Constructs a new BookLaunch instance with default settings.
	 */
	public BookLaunch() {
		super();
	}
	
	/**
	 * Calculates the admission fee for a book launch event.
	 * The fee is calculated based on predefined rates and duration constants.
	 */
	@Override
	public void calculateAdmissionFee() {
		this.admissionFees = Constants.BOOK_LAUNCH_RATE * Constants.BOOK_LAUNCH_DURATION;
	}

}