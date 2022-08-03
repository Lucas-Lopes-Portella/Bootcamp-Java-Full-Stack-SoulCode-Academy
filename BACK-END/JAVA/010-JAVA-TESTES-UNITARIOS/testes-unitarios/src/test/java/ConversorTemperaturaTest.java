import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConversorTemperaturaTest {

    ConversorTemperatura conversor = new ConversorTemperatura();

    @Test
    public void testConverterCParaF(){
        double resultado = conversor.celsiusToFahrenheit(80.0);
         assertTrue(resultado==176.0); // se o resultado da condição for true o teste deu certo
    }


    @Test
    public void testConverterFparaC(){
        double resultado = conversor.fahrenheitToCelcius(176.0);
        assertTrue(resultado==80.0); // se o resultado da condição for true o teste deu certo
    }
}
