let nome = 'joão'; // tipagem implícita
console.log(`O nome é: ${nome}`)


//tipagem explícita


var idade: number = 18;

let msg: string = 'Hello World'  // tipagem explícita
var idade: number = 18
const estudando: boolean = true


const nomes: Array<string> = ['Amanda', 'André', 'Andrew', 'Antonio', 'Barbara', 'Bruno']
const idades: number[] = [5, 6, 7, 8, 200, 359.32]

nomes.forEach((nome, i) => {
    console.log(`${nome}, ${idades[i]} anos`)
})

//objeto de maneira implicita
/* const pessoa = {
    nome: 'Amanda',
    idd: 5
} */

//objeto de maneira explicita com tipagem
interface Pessoa {
    nome: string
    idade: number
    cpf: number | string | Array<string> | number[]
}
const p: Pessoa = {
    nome:'Lucas',
    idade:23,
    cpf: 12345678900
}

const p2: Pessoa ={
    nome:'Amanda',
    idade:23,
    cpf: '12345678900'
}

const p3: Pessoa ={
    nome:'Raquel',
    idade:25,
    cpf: [1,2,3,4,5,6,7,8,9,0,0]
}
const p4: Pessoa ={
    nome:'Leo',
    idade:25,
    cpf: ['1','2','3','4','5','6','7','8','9','0','0']
}


