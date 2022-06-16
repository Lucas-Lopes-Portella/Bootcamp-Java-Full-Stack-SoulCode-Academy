console.log("Olá Mundo!")

let numero = parseInt(prompt("Escolha um número para visualizar a sua tabuada do número 1 ao 1000: "));

document.write(`<h1>Tabuada do número ${numero}, até 1000</h1>`);


if (numero == 0) {
    document.write(`<p>O resultado de ${numero} * N é igual a 0</p>`)
} else {

    for (let i = 0; i <= 1000; i++) {
        document.write(`<p> <em> ${numero}*${i}=  ${numero * (i)} </em> </p>  `);
    }
}
 


/* let numero = NaN
while(isNaN(numero)){
    numero = parseFloat(prompt("Escolha um número para visualizar a sua tabuada do número 1 ao 1000: "))
}

for (let i = 0; i <= 1000; i++) {
    document.write(`<p> <em> ${numero}*${i}=  ${numero * (i)} </em> </p>  `);
} */




