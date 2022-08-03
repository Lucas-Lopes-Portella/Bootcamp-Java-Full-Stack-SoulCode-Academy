public class ConversorTemperatura {
    public double celsiusToFahrenheit(double tempC){
        return(tempC * (9.0/5.0) + 32);
    }
    public double fahrenheitToCelcius(double tempF){
        return( (tempF - 32) * (5.0 / 9.0) );
    }
}
