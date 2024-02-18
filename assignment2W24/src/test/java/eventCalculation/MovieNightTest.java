package eventCalculation;

import com.algonquin.cst8288.assignment2.constants.Constants;
import com.algonquin.cst8288.assignment2.event.MovieNight;
import org.junit.Assert;
import org.junit.Test;

public class MovieNightTest {

    @Test
    public void testCalculateAdmissionFee() {
        // Crear una instancia de MovieNight
        MovieNight movieNight = new MovieNight();
        
        // Calcular manualmente la tarifa de admisión esperada
        double expectedFee = Constants.MOVIE_NIGHT_RATE * Constants.MOVIE_NIGHT_DURATION;
        
        // Llamar al método bajo prueba
        movieNight.calculateAdmissionFee();
        
        // Obtener la tarifa de admisión calculada
        double actualFee = movieNight.getAdmissionFees(); // Asumiendo que existe el método getAdmissionFees()
        
        // Afirmar que la tarifa calculada es la esperada
        Assert.assertEquals("La tarifa de admisión calculada para Movie Night es incorrecta.", expectedFee, actualFee, 0.0);
    }
}
