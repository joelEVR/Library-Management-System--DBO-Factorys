package com.algonquin.cst8288.assignment2.event;
import com.algonquin.cst8288.assignment2.constants.Constants;

public class BookLaunch extends Event {

	public BookLaunch() {
		super();
	}
	
	@Override
	public void calculateAdmissionFee() {
		this.admissionFees = Constants.BOOK_LAUNCH_RATE * Constants.BOOK_LAUNCH_DURATION;
	}

}
