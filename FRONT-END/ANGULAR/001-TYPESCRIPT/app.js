"use strict";
let nome = 'joão'; // tipagem implícita
console.log(`O nome é: ${nome}`);
//tipagem explícita
var idade = 18;
let msg = 'Hello World'; // tipagem explícita
var idade = 18;
const estudando = true;
const nomes = ['Amanda', 'André', 'Andrew', 'Antonio', 'Barbara', 'Bruno'];
const idades = [5, 6, 7, 8, 200, 359.32];
nomes.forEach((nome, i) => {
    console.log(`${nome}, ${idades[i]} anos`);
});
const p = {
    nome: 'Lucas',
    idade: 23,
    cpf: 12345678900
};
const p2 = {
    nome: 'Amanda',
    idade: 23,
    cpf: '12345678900'
};
const p3 = {
    nome: 'Raquel',
    idade: 25,
    cpf: [1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0]
};
const p4 = {
    nome: 'Leo',
    idade: 25,
    cpf: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '0']
};
