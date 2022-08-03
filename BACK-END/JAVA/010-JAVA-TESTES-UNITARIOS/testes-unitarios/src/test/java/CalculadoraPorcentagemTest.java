public class CalculadoraPorcentagemTest {

    public static void main(String[] args) {
        testeCalculadoraPorcentagemValida();
        testeCalculadoraPorcentagemInvalida();
    }

    public static void testeCalculadoraPorcentagemValida(){
        var calc = new CalculadoraPorcentagem();
        String resultado = calc.calcular(50, 1000.0); // parâmetro ditos logo abaixo nos comentários
        String resultadoEsperado = "50% de 1000,0 = 500,0";
        if (resultado.equals(resultadoEsperado)) {
            System.out.println("Sucesso");
        }
        else{
            System.out.println("Erro");
            System.out.println(resultado);
        }
    }

    public static void testeCalculadoraPorcentagemInvalida() {
        var calc = new CalculadoraPorcentagem();
        String resultado = calc.calcular(-40, 1000.0);

        if(resultado == null) {
            System.out.println("Tarda mais não falha");
        }
        else{
            System.out.println("Erro");
            System.out.println(resultado);
        }
    }

}




// CalculadoraPorcentagem
// Serão passados dois parâmetros
// 1º Percentual -> 0 a 100
// 2º Total -> tipo double
// Resultado esperado -> 50% de 1000 = 500