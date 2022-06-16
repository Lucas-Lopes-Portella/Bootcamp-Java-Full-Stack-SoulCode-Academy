"use strict";
function mostrarMensagem() {
    console.log("Olá mundo!!");
}
mostrarMensagem();
function mostrarMensagem2(msg) {
    console.log(msg);
}
mostrarMensagem2("Olá, Typescript");
function mostrarMensagem3(msg) {
    console.log(msg);
}
function somar(a, b) {
    return a + b;
}
let total = somar(5, 6);
console.log(total);
function somarRestOperator(...nums /* Ou number[] */) {
    return nums.reduce((x, y) => x + y, 0);
}
console.log(somarRestOperator());
function forEach(array, fn) {
    for (let i of array) {
        fn(i);
    }
}
let arr = [1, 2, 3, 4, 5, 6];
forEach(arr, (x) => {
    console.log(x + 5);
});

arr.forEach((x) => {
    console.log(x + 5);
});

/* 
1. Array
2. Pega cada valor do array e transforma em algo diferente
3. Gera um novo array com os valores modificados
4. Retorna o novo array
*/

function mapear(array, funcao) {
    const novoArray = []
  
    for (let i = 0; i < array.length; i++) {
      const valor = funcao(array[i]) // 5
      novoArray.push(valor) // 5
    }
  
    return novoArray // [4, 5, 5]
  }

  let nomes = ['Amanda','Lucas','João','Maria']
  let novo = mapear(nomes, (y)=>{
      return y.length *3;
  })

  console.log('mapear '+novo);

  novo = nomes.map((y)=>{
    return y.length *3;
})
console.log('map '+novo);