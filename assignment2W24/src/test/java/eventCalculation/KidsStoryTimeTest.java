package eventCalculation;

import com.algonquin.cst8288.assignment2.constants.Constants;
import com.algonquin.cst8288.assignment2.event.KidsStoryTime;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the functionality of the KidsStoryTime class for calculating admission fees.
 */
public class KidsStoryTimeTest {

    /**
     * Tests the calculateAdmissionFee method for KidsStoryTime.
     * Confirms the admission fee is correctly calculated based on the constants for rate and duration.
     */
    @Test
    public void testCalculateAdmissionFee() {
        KidsStoryTime kidsStoryTime = new KidsStoryTime();
        double expectedFee = Constants.KIDS_STORYTIME_RATE * Constants.KIDS_STORYTIME_DURATION;
        kidsStoryTime.calculateAdmissionFee();
        double actualFee = kidsStoryTime.getAdmissionFees(); 
        Assert.assertEquals("The admission fee calculated for Kids Story Time is incorrect.", expectedFee, actualFee, 0.0);
    }
}
