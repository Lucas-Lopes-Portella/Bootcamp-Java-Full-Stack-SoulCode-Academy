public class CalculadoraPorcentagem {


    public String calcular(double percentual, double valor) {
        if(percentual >= 0 && percentual <= 100) {
            double resultado = (percentual / 100) * valor;
            return String.format("%.0f", percentual) + "% de " + String.format("%.1f", valor) + " = " + String.format("%.1f", resultado);
        }
        return null;
    }
}