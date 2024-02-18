package dBConnection;

import org.junit.Assert;
import org.junit.Test;
import com.algonquin.cst8288.assignment2.database.DBConnection;

/**
 * Tests the DBConnection class to ensure it correctly implements the Singleton pattern.
 */
public class DBConnectionTest {

    /**
     * Tests the getInstance method of the DBConnection class.
     * Ensures that it returns the same instance upon multiple calls, indicating a proper Singleton pattern implementation.
     */
    @Test
    public void testSingletonInstance() {
        DBConnection firstInstance = DBConnection.getInstance();
        DBConnection secondInstance = DBConnection.getInstance();
        Assert.assertSame("Expected the same instance of DBConnection to be returned", firstInstance, secondInstance);
    }
}
