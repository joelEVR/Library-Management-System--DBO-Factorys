package eventCalculation;

import com.algonquin.cst8288.assignment2.constants.Constants;
import com.algonquin.cst8288.assignment2.event.Workshop;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the functionality of the Workshop class, specifically focusing on the calculation of admission fees.
 */
public class WorkshopTest {

    /**
     * Tests the calculateAdmissionFee method of the Workshop class.
     * Verifies that the calculated admission fee is as expected, based on the constants defined for rate and duration.
     */
    @Test
    public void testCalculateAdmissionFee() {
        Workshop workshop = new Workshop();
        double expectedFee = Constants.WORKSHOP_RATE * Constants.WORKSHOP_DURATION;
        workshop.calculateAdmissionFee();
        double actualFee = workshop.getAdmissionFees(); 
        Assert.assertEquals("The admission fee calculated for Workshop is incorrect.", expectedFee, actualFee, 0.0);
    }
}
