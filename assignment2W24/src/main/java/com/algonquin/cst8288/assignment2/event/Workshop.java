package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.logger.LogLevel;

public class Workshop extends Event {

    @Override
    public void calculateAdmissionFee() {
        // Antes de calcular la tarifa de admisión, registra el inicio del cálculo.
        LMSLogger.getInstance().log(LogLevel.INFO, "Calculating admission fee for Workshop");

        this.admissionFees = Constants.WORKSHOP_RATE * Constants.WORKSHOP_DURATION;

        // Después de calcular la tarifa de admisión, registra el valor calculado.
        LMSLogger.getInstance().log(LogLevel.INFO, "Admission fee calculated for Workshop: " + this.admissionFees);
    }
}
