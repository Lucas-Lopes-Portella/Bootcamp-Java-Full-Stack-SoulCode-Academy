import java.util.ArrayList;
import java.util.List;

public class Contribuicao {
    public static void main(String[] args) {
        PessoaFisica pf1 = new PessoaFisica("Amanda",45000,3000);
        PessoaFisica pf2 = new PessoaFisica("Tati",60000,5000);
//        System.out.printf("%s%s%.2f%n",pf1.getNome()," vai pagar o valor de: R$",pf1.calcularImposto(), " de imposto");
        pf1.calcularImposto();
        System.out.println("- - - - - - - - - ");
        PessoaJuridica pj1 = new PessoaJuridica("Lucas",25000,4);
        PessoaJuridica pj2 = new PessoaJuridica("Will",75000,2);
//        System.out.printf("%s%s%.2f%n%n",pj1.getNome()," vai pagar o valor de: R$",pj1.calcularImposto()," de imposto");

        List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
        listaPessoas.add(new PessoaJuridica("Renato",25000,2));
        listaPessoas.add(pj1);
        listaPessoas.add(pj2);
        listaPessoas.add(new PessoaFisica("Sergio",300000,12000));
        listaPessoas.add(pf1);
        listaPessoas.add(pf2);

        double soma = 0;

        for(Pessoa p:listaPessoas){
            System.out.printf("%s%s%.2f%n",p.getNome(), ", o valor do imposto é: ", p.calcularImposto());
            soma += p.calcularImposto();
        }
        System.out.printf("%s%.2f","A soma dos impostos é: ",soma);
    }
}
