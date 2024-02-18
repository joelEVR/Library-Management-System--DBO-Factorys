package eventCalculation;

import com.algonquin.cst8288.assignment2.constants.Constants;
import com.algonquin.cst8288.assignment2.event.KidsStoryTime;
import org.junit.Assert;
import org.junit.Test;

public class KidsStoryTimeTest {

    @Test
    public void testCalculateAdmissionFee() {
        // Crear una instancia de KidsStoryTime
        KidsStoryTime kidsStoryTime = new KidsStoryTime();
        
        // Calcular manualmente la tarifa de admisión esperada
        double expectedFee = Constants.KIDS_STORYTIME_RATE * Constants.KIDS_STORYTIME_DURATION;
        
        // Llamar al método bajo prueba
        kidsStoryTime.calculateAdmissionFee();
        
        // Obtener la tarifa de admisión calculada
        double actualFee = kidsStoryTime.getAdmissionFees(); // Asumiendo que existe el método getAdmissionFees()
        
        // Afirmar que la tarifa calculada es la esperada
        Assert.assertEquals("La tarifa de admisión calculada para Kids Story Time es incorrecta.", expectedFee, actualFee, 0.0);
    }
}
