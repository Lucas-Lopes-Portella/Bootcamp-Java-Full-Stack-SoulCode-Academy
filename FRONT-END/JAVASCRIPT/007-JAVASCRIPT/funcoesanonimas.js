let subtrair = function(a,b) {
    if (b>a){
        return b-a
    } else {
        return a-b
    }
}

console.log(subtrair(5,2))


//arrow functions

let sub = (a,b) => {
    if (b>a){
        return b-a
    } else {
        return a-b
    }
    
}
console.log(sub(5,2))

let sub2 = (a,b) => a+b
console.log(sub2(3,2))

let sub3 = () => 5
console.log(sub3())

let sub4 = umParametro => umParametro * 2
console.log(sub4(2))