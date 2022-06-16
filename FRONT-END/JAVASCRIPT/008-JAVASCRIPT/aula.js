function somar(...numeros){ // passar mais de um parametro de maneira implicita, sem especificar 10 parametros.

    let somaTotal = 0;

    for(let numero of numeros){
        somaTotal +=numero
    }

    return somaTotal;

}

let total = somar(1,2,3,4,5,6,7,8,9,10);
console.log(total)

//objetos são guardados. Se mudar um item do objeto em algum lugar, muda em tudo. 


//rest operator
let p = {
    nome: 'Amanda',
    idade: 25
}

let p2 = {... p}

p2.nome = 'Lucas'

console.log(p)
console.log(p2)


//Arrays

const numeros = [1,2,3,4,5,6,7,8,9,10]
numeros.forEach(   // consome os dados sem modificá-los e retorna um novo array
    (x)=> {
        console.log(x);
    }
)

//map pega os dados, modifica e retorna novos valores

// filter filtra os valores de um array

// find retorna o valor ou a condição encontrada

// findIndex retorna o valor  do elemento ou condicao encontrada 

//