package eventCalculation;

import com.algonquin.cst8288.assignment2.constants.Constants;
import com.algonquin.cst8288.assignment2.event.MovieNight;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the functionality of the MovieNight class, specifically focusing on the calculation of admission fees.
 */
public class MovieNightTest {

    /**
     * Tests the calculateAdmissionFee method of the MovieNight class.
     * Ensures that the calculated admission fee matches the expected fee based on predefined rates and duration.
     */
    @Test
    public void testCalculateAdmissionFee() {
        MovieNight movieNight = new MovieNight();
        double expectedFee = Constants.MOVIE_NIGHT_RATE * Constants.MOVIE_NIGHT_DURATION;
        movieNight.calculateAdmissionFee();
        double actualFee = movieNight.getAdmissionFees(); 
        Assert.assertEquals("The admission fee calculated for Movie Night is incorrect.", expectedFee, actualFee, 0.0);
    }
}
