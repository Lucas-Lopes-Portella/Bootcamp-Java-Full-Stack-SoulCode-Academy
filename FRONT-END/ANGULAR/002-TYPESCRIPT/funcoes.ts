function mostrarMensagem(){
    console.log("Olá mundo!!")
}
mostrarMensagem();

function mostrarMensagem2(msg: string){
    console.log(msg)
}
mostrarMensagem2("Olá, Typescript")

function mostrarMensagem3(msg: string):void{
    console.log(msg)
}

function somar(a:number, b:number):number{
    return a+b;
}
let total = somar(5,6);
console.log(total);

function somarRestOperator(...nums: Array<number> /* Ou number[] */):number{
    return nums.reduce((x,y) => x+y,0);
}
console.log(somarRestOperator());



function forEach(array: any[], fn: (x: any) => void){
    for (let i of array){
        fn(i);
    }
}

let arr = [1,2,3,4,5,6];
forEach(arr, (x)=> {
    console.log(x+5)
})

arr.forEach((x)=>{
    console.log(x+5)
})