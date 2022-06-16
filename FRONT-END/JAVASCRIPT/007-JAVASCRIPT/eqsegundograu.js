function equacaoDoSegundoGrau(a, b, c) {

    let delta, x1, x2;
    delta = ((b ** 2) - (4 * a * c));
    console.log(delta)
    if (delta > 0) {

        x1 = ((-b + (delta) ** (1 / 2)) / (2 * a)).toFixed(2)
        x2 = ((-b - (delta) ** (1 / 2)) / (2 * a)).toFixed(2)
        return (document.write(`<h1 style="text-align:center ; color:blue" ; font-size: 40px> A equação possui dois resultados diferentes.<br />
         X1 = <strong>${x1}</strong> <br />
         e<br /> 
         X2 = <strong>${x2}</strong></h1>`))


    } else if (delta == 0) {
        x1 = -b + ((delta) ** (1 / 2)) / (2 * a).toFixed(2)
        return (document.write(`<h1 style="text-align:center ; color:blue ; font-size: 40px "> O resultado da equação é: ${x1}</h1>`))
    } else {
        return document.write(`<h1 style="text-align:center ; color:red ; font-size: 40px "> Não possui raízes reais</h1>`)
    }



}
// formato x^2 + bx + c
// DELTA = b^2 - 4*a*c
// BHASKARA = -b +- ((DELTA)**(1/2)) / (2*a)

// exemplo com delta positivo 
//equacaoDoSegundoGrau(1, -1, -12);

// exemplo com delta = 0
// equacaoDoSegundoGrau(2, 4, 2);

// exemplo com delta negativo
//equacaoDoSegundoGrau(1,-14,50);