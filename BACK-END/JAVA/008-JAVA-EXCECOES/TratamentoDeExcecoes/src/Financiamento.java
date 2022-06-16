public class Financiamento {

    // regras:
    // 1) valor-entrada >= 20% valor-total
    // 2) parcelas >= 6
    private double valorTotal;
    private double valorEntrada;
    private int parcelas;

    public Financiamento(double valorTotal, double valorEntrada, int parcelas) throws FinanciamentoException{
       if(valorEntrada< valorTotal*0.2 && parcelas<6){
               throw new  FinanciamentoException(" Valor de entrada inferior a 20% e parcela inferior a 6 ");
       } else if(valorEntrada< valorTotal*0.2){
            throw new  FinanciamentoException(" Valor de entrada inferior a 20%");
       } else if (parcelas<6){
            throw new  FinanciamentoException(" Parcela inferior a 6");
        }

        this.valorTotal = valorTotal;
        this.valorEntrada = valorEntrada;
        this.parcelas = parcelas;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }
}
