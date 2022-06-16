const str = 'O homem é o próprio lobo do homem';

console.log(str.length); 
 // retorna o tamanho

console.log(str[2]); 
// retorna um caractere específico

console.log(str[str.length-1]); 
// retorna o ultimo elemento
 
 console.log(str.indexOf('om')); 
 // procura no texto o indice em que a palavra inicia. 

 console.log(str.charAt('10')); 
 //Descobrir o CARACTERE que está em determinada posição.  
 

 console.log(str.charCodeAt()); 
 //Descobrir o CODE que está em determinada posição.
 

 console.log(str.split(" ")); // recorta padrão que contido nos parenteses () e remove da string, armazenando a nova string em um novo array. 
 
 

 console.log(str.concat('. ','Sim',',' , ' ', 'exatamente'));// Juntar caracteres com os já existentes na string


 console.log(str.toUpperCase()) // transforma a cadeia de caracteres em letras MAIúSCULAS

console.log(str.toLowerCase()) // transforma a cadeia de caracteres em letras minúsculas

console.log(str.replace('lobo','monstro')) // altera parte da string

console.log(str.replaceAll('homem','pessoa')) // altera todas as ocorrencias da string

console.log(str.replace(/homem/g,'pessoa'))
// utilizando expressão regular


console.log(str.startsWith('O hom')); 
// valor booleano para verificar se começa com o caractere (ou cadeia de caracteres) específicado(s)


console.log(str.endsWith('O hom')); 
// valor booleano para verificar se termina com o caractere (ou cadeia de caracteres) específicado(s)


console.log(str.slice(2,10)); 
// método para recortar parte da string
console.log(str.slice(2,10)); 
// método para recortar parte da string



console.log(str.slice(-5)); 
// método para recortar parte da string

