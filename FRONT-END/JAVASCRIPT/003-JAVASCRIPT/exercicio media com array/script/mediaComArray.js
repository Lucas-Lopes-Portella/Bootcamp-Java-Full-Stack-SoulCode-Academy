
function mediaVetor() {

    const qtdNotas = parseInt(prompt("Quantas notas devem ser recebidas?"));


    let somaArray = [];
    let somatorio = 0
    for (let i = 0; i < qtdNotas; i++) {
        somaArray.push(parseFloat(prompt(`Digite sua ${i + 1}ª nota aqui:`)))
        somatorio += somaArray[i]

    }


    let media = somatorio / (somaArray.length)
    alert(`Sua média é: ${media.toFixed(2)}`);


    //teste de verificação
    if (somaArray.length == qtdNotas) {
        console.log("Verdadeiro");
    }
}

