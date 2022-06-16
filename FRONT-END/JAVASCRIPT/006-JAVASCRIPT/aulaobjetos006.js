/* 
i) Propriedades/Atributos - caracteristicas dos elementos
ii) Métodos/Funções - rotinas que um objeto pode realizar a partir de algoritmos 
*/

// forma de declarar objeto;
//formato chave:valor
let pessoa = {
     nome:"Cremilda", // Propriedade
     idade: 65,
     endereco : {
         cidade: 'Rio de Janeiro',
         estado: 'Rio de Janeiro',
         cep: '18151-505'
     },
     cumprimentar() {
        console.log('Olá pessoa');
     }
    }
    console.log(pessoa['nome'])
    pessoa['cumprimentar']()
   /*  //alterar campo
    console.log(pessoa.idade)
    pessoa.idade=62;
    console.log(pessoa.idade)
    console.log(pessoa.endereco.estado) */

  