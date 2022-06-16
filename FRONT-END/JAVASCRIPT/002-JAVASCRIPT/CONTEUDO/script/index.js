const qtdNotas = parseInt(prompt("Quantas notas devem ser recebidas?"));


// let i = 0; //contador
let soma = 0;


/* while (i< qtdNotas){ //condição booleana { 
    const nota = parseFloat(prompt("Digite sua "+(i+1)+"ª nota aqui:"))
    soma += nota;
    i++; //incremento
} */


for (let i = 0; i < qtdNotas; i++) {
    const nota = parseFloat(prompt(`Digite sua ${i + 1}ª nota aqui:`))
    soma += nota
}



let media = soma / qtdNotas;

if (media >= 7) {
    alert(`Aprovado com média: ${media}`);

} else {
    alert(`reprovado, pois sua média foi ${7 - media} pontos abaixo do necessário para a aprovação`);
    alert("Média: " + media);
}

document.write('<h1>Olá Mundo</h1>');




