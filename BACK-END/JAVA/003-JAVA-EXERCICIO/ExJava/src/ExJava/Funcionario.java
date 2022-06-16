package ExJava;

public class Funcionario {

    private String nome;
    private int idade;
    private String cargo;
    private String situacao;
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public int getIdade() {
        return idade;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getCargo() {
        return cargo;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    public String getSituacao() {
        return situacao;
    }
    public Funcionario(String nome, int idade, String cargo, String situacao) {
        this.setNome(nome);
        this.setIdade(idade);
        this.setCargo(cargo);
        this.setSituacao(situacao);
    }
    public void demitirFuncionario(){
        setSituacao("Inativo");
    }
    public void trocarCargoFuncionario(String cargo){
        if(cargo == "Estudante Soulcode"){
             setCargo("Desenvolvedor FullStack Java JR");
        } else if (cargo == "Estagiário Javascript Front-End"){
             setCargo("Desenvolvedor Javascript Front-End JR");
        } else if (cargo == "Analista de negócios JR" ){
             setCargo("Analista de negócios PL");
        } else {
             setCargo("Analista de testes SR");
        }
    }
    public void aniversario(){
        setIdade(++idade);
    }
    public String pagarSalario(){
       return "O salário foi pago" ;
    }

}
