function eqSegundoGrau(a,b,c){
   
    let delta;
    let x1;
    let x2; 

    delta = (b**2) - (4*a*c)
    x1 = ( (-b) + (delta)**(1/2) ) / (2*a)
    x2 = ( (-b) - (delta)**(1/2) ) / (2*a)

    /* return {
        x1,
        x2
    } */

    return console.log( [x1,x2] );
}
eqSegundoGrau(1,-1,-12);

 
