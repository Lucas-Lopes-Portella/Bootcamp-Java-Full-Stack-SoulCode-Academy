class Pessoa{
    constructor(nome,idade) { // construtor utilizado para criar o objeto NomeDaClasse
		this.nome = nome // faz referencia a propria classe
		this.idade = idade
	}
}
let objetoDaClasse = new Pessoa('Lucas', 23); // criação do objeto


console.log(objetoDaClasse)
objetoDaClasse.nome = 'Amanda'
objetoDaClasse.idade = 22
console.log(objetoDaClasse)



