public class Retangulo extends Figura{

    private double lado1;
    private double lado2;

    public Retangulo(String cor, String nome, double lado1, double lado2) {
        super(cor, nome);
        if(lado1 <= 0 || lado2 <= 0){
            throw new RuntimeException("As medidas dos lados não podem ser menores ou iguais a zero");
        }

        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    @Override
    public double calcularArea() throws FiguraException {
        if((lado1%2 !=0) || (lado2%2 !=0)){
            throw new FiguraException("Os lados do retângulo devem ser números pares");
        }
        return lado1*lado2;
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }
}
