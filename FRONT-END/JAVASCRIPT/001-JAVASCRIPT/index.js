  alert("Olá mundo!") // Mostra uma mensagem na tela
       
  prompt('Olá mundo'); // insere mensagem na tela e há um campo para resposta

  confirm("Você quer brincar na neve?"); // mensagem com botão de confirmar e cancelar

    //VARIAVEIS
    //var nome = prompt("Guarde um valor nesta variável");
   // alert(nome);

    // let idade = prompt("Qual a sua idade?");
    // alert(idade);
// o let não permite sobrepor outra variavel com o mesmo nome por exemplo let nome = lucas e depois let nome = Amanda ... é possivel fazer let nome = Lucas e depois nome = Amanda ... variável única

//const id = prompt("Qual o seu id?");
//alert(id);
// o const não permite recriar a variável e nem alterar seu valor

//console.log("O console insere mensagem no console do navegador")

let string  = "3"
let string2  = "5"
var tipo   = string+string2
console.log(typeof(c)) 


//OPERADORES
alert("Informe três valores e confira o Console do navegador")
var n1 = parseFloat(prompt("Valor de N1"));
var n2 = parseFloat(prompt("Valor de N2"));
var n3 = parseFloat(prompt("Valor de N3"));
let soma = n1+n2+n3;
let sub = n1-n2-n3;
let mult = n1*n2*n3;
let divisao = n1/n2/n3;
let resto = n1%n2%n3;

console.log("Soma: " + soma);
console.log("Subtração: " + sub);
console.log("Multiplicação: " + mult);
console.log("Divisão: " + divisao);
console.log("Resto: " + resto); 


//OPERADORES II 

//Utilização de && e ||

// utilização de == ; === ; != ; !== ; > ; >= ; < ; <=

var a = 6;
var b = "6";
var c = 6.0;
console.log(a==b && b==c && a==c && b===c ) 

// Estruturas condicionais
//if

alert("Agora vamos calcular a média de três notas")
let nota1 = parseFloat(prompt('Informe a primeira nota'));
let nota2 = parseFloat(prompt('Informe a segunda nota'));
let nota3 = parseFloat(prompt('Informe a terceira nota'));

let media = (nota1+nota2+nota3)/3

console.log("A sua média é: " + media)

if(media>=9){
  alert("Parabéns, sua média foi TIER S. " + ("Nota: ") + media);
} else if ( media >=6){
    alert("Você está aprovado, pois sua media foi: " + media);
} else {
    alert("Você está reprovado, pois sua média foi: " + media);
}
