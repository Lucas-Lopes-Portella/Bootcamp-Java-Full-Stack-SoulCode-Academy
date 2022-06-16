package ExJava;

public class ClassMain {
    public static void main(String[]args){
        Funcionario f1 = new Funcionario("Lucas",23,"Estudante Soulcode","Ativo");
        Funcionario f2 = new Funcionario("Clebermir",67,"Estagiário Javascript Front-End","Ativo");
        Funcionario f3 = new Funcionario("Fe",23,"Analista de negócios JR","Ativo");
        Funcionario f4 = new Funcionario("Uilsom",44,"Analista de testes PL","Ativo");

        System.out.println(f1.getNome()+", você não faz mais parte dessa empresa");
        System.out.println("Status anterior: "+f1.getSituacao()); //teste
        f1.demitirFuncionario();
        System.out.println("Status atual: "+f1.getSituacao()); //teste

        System.out.println("");

        System.out.println("Parabéns " +f2.getNome()+", você foi promovido(a)");
        System.out.println("Status anterior: "+f2.getCargo()); //teste
        f2.trocarCargoFuncionario(f2.getCargo());
        System.out.println("Status atual: "+f2.getCargo()); //teste

        System.out.println("");

        System.out.println("Olá " +f3.getNome()+", feliz aniversário");
        System.out.println("Status anterior: "+f3.getIdade()); //teste
        f3.aniversario();
        System.out.println("Status atual: "+f3.getIdade()); //teste

        System.out.println("");

        System.out.println("Olá " +f4.getNome()+", "+f4.pagarSalario());

    }
}
