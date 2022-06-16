
//JUNÇÃO COM HTML

criarParagrafo('document.write converte a string em um elemento HTML', 'h1');
criarParagrafo('document.write converte a string em um elemento HTML', 'h2');
criarParagrafo('document.write converte a string em um elemento HTML', 'h3');
criarParagrafo('Este é meu footer', 'footer');

function criarParagrafo(txt, elemento = 'p') {
    document.write(`<${elemento}><strong>${txt}</strong></${elemento}>`);
}



//FUNCOES COM RETORNO 


/* function somar(a,b){
        a+b; 
}
let total = somar(5,6);
console.log(total) // retorna undefined
 */



function somar(a, b) {

    return a + b; // o return serve para retornar o valor e nao deixar os valores se perderem dentro da funcao
}
let total = somar(5, 6);
console.log(total)  // RETORNA 11


function imc(peso, altura){
    return parseFloat((peso/(Math.pow(altura,2))).toFixed(1))
}

console.log(imc(75,1.66));
