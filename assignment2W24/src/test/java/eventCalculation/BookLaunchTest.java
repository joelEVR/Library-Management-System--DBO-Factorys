package eventCalculation;

import com.algonquin.cst8288.assignment2.constants.Constants;
import com.algonquin.cst8288.assignment2.event.BookLaunch;
import org.junit.Assert;
import org.junit.Test;

public class BookLaunchTest {

    @Test
    public void testCalculateAdmissionFee() {
        // Create an instance of book launch
        BookLaunch booklaunch = new BookLaunch();
        
        // Manually calculate the expected admission fee
        double expectedFee = Constants.BOOK_LAUNCH_RATE * Constants.BOOK_LAUNCH_DURATION;
        
        // Call the method under test
        booklaunch.calculateAdmissionFee();
        
        // Retrieve the calculated fee
        double actualFee = booklaunch.getAdmissionFees(); // Assuming getAdmissionFees() method exists to access admissionFees
        
        // Assert that the calculated fee is as expected
        Assert.assertEquals("The admission fee calculated for Book Launch is incorrect.", expectedFee, actualFee, 0.0);
    }
}
