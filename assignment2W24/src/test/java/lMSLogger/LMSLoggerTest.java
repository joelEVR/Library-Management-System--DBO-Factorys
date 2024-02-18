package lMSLogger;

import org.junit.Assert;
import org.junit.Test;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;

/**
 * Tests the LMSLogger class to verify its Singleton pattern implementation.
 */
public class LMSLoggerTest {

    /**
     * Tests the getInstance method of LMSLogger to confirm it always returns the same instance.
     * This ensures the Singleton pattern is correctly applied.
     */
    @Test
    public void testSingletonInstance() {
        LMSLogger firstInstance = LMSLogger.getInstance();
        LMSLogger secondInstance = LMSLogger.getInstance();
        Assert.assertSame("Expected the same instance of LMSLogger to be returned", firstInstance, secondInstance);
    }
}
