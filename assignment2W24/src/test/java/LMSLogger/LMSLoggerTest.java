package LMSLogger;

import org.junit.Assert;
import org.junit.Test;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;

public class LMSLoggerTest {

    @Test
    public void testSingletonInstance() {
        LMSLogger firstInstance = LMSLogger.getInstance();
        LMSLogger secondInstance = LMSLogger.getInstance();
        
        Assert.assertSame("Expected the same instance of LMSLogger to be returned", firstInstance, secondInstance);
    }
}