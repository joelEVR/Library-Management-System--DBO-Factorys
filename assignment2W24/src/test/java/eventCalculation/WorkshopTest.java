package eventCalculation;

import com.algonquin.cst8288.assignment2.constants.Constants;
import com.algonquin.cst8288.assignment2.event.Workshop;
import org.junit.Assert;
import org.junit.Test;

public class WorkshopTest {

    @Test
    public void testCalculateAdmissionFee() {
        // Create an instance of Workshop
        Workshop workshop = new Workshop();
        
        // Manually calculate the expected admission fee
        double expectedFee = Constants.WORKSHOP_RATE * Constants.WORKSHOP_DURATION;
        
        // Call the method under test
        workshop.calculateAdmissionFee();
        
        // Retrieve the calculated fee
        double actualFee = workshop.getAdmissionFees(); // Assuming getAdmissionFees() method exists to access admissionFees
        
        // Assert that the calculated fee is as expected
        Assert.assertEquals("The admission fee calculated for Workshop is incorrect.", expectedFee, actualFee, 0.0);
    }
}
