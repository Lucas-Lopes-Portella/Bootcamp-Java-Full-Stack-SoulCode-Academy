
const img1 = document.querySelector('img.lamp');

const btnLampL = document.querySelector('#ligar');
const btnLampD = document.querySelector('#desligar');

btnLampD.addEventListener('click', () => {
            img1.src = "img/apagada.png";
           
}) 

btnLampL.addEventListener('click',()=>{
    img1.src = "img/ligada.png"
})
   
