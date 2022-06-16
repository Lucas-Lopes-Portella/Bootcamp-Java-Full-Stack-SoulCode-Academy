public class PrincipalFinanciamento {
    public static void main(String[] args) {
        try{
            Financiamento f1 = new Financiamento(25000,5000,6);
            System.out.printf("%s%.2f","O seu financiamento é de: ", f1.getValorTotal());
        } catch (FinanciamentoException e){
            System.out.println("Erro na proposta. "+ e.getMessage());
        } finally {
            System.out.println("\nAgradecemos a sua confiança!");
        }


    }
}
