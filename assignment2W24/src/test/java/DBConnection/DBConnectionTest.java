package DBConnection;

import org.junit.Assert;
import org.junit.Test;

import com.algonquin.cst8288.assignment2.database.DBConnection;

public class DBConnectionTest {

    @Test
    public void testSingletonInstance() {
        DBConnection firstInstance = DBConnection.getInstance();
        DBConnection secondInstance = DBConnection.getInstance();
        
        Assert.assertSame("Expected the same instance of DBConnection to be returned", firstInstance, secondInstance);
    }
}
