package com.algonquin.cst8288.assignment2.event;
import com.algonquin.cst8288.assignment2.constants.Constants;

public class Workshop extends Event {

	@Override
	public void calculateAdmissionFee() {
        this.admissionFees = Constants.WORKSHOP_RATE * Constants.WORKSHOP_DURATION;
	}

}
