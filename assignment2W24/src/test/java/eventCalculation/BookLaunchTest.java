package eventCalculation;

import com.algonquin.cst8288.assignment2.constants.Constants;
import com.algonquin.cst8288.assignment2.event.BookLaunch;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the BookLaunch class's ability to accurately calculate admission fees.
 */
public class BookLaunchTest {

    /**
     * Tests the calculateAdmissionFee method in BookLaunch class.
     * Ensures the correct calculation of the admission fee using predefined rates and durations.
     */
    @Test
    public void testCalculateAdmissionFee() {
        BookLaunch booklaunch = new BookLaunch();
        double expectedFee = Constants.BOOK_LAUNCH_RATE * Constants.BOOK_LAUNCH_DURATION;
        booklaunch.calculateAdmissionFee();
        double actualFee = booklaunch.getAdmissionFees(); 
        Assert.assertEquals("The admission fee calculated for Book Launch is incorrect.", expectedFee, actualFee, 0.0);
    }
}
