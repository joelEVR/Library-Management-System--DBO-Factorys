package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.logger.LogLevel;

/**
 * Represents a workshop event.
 * This class extends the {@link Event} class and calculates the admission fee for a workshop.
 */
public class Workshop extends Event {

    /**
     * Calculates the admission fee for a workshop event.
     * Before and after calculating the fee, logs are generated to indicate the calculation process.
     */
    @Override
    public void calculateAdmissionFee() {
        // Before calculating the admission fee, log the start of the calculation.
        LMSLogger.getInstance().log(LogLevel.INFO, "Calculating admission fee for Workshop");

        this.admissionFees = Constants.WORKSHOP_RATE * Constants.WORKSHOP_DURATION;

        // After calculating the admission fee, log the calculated value.
        LMSLogger.getInstance().log(LogLevel.INFO, "Admission fee calculated for Workshop: " + this.admissionFees);
    }
}