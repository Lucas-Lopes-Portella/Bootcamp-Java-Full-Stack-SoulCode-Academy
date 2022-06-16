const divQuadrado = document.querySelector('div.quadrado');
divQuadrado.style.transition = 'background 1s'

const btnAddRemover = document.querySelector('#adicionar-remover');

btnAddRemover.addEventListener('click', () => {
divQuadrado.classList.toogle('vermelho')
})

/* 
btnAddRemover.addEventListener('click', () => {
    if (divQuadrado.classList.contains('vermelho')) {

        divQuadrado.classList.remove

    } else {
        divQuadrado.classList.add('vermelho')
    }
})

divQuadrado.addEventListener('mouseenter', () => {
    divQuadrado.style.animationName = 'rotacionar';
    divQuadrado.style.animationDuration = '3s';
    divQuadrado.style.animationIterationCount = 'infinite';

})
divQuadrado.addEventListener('mouseout', () => {
    divQuadrado.style.animationName = 'rotacionar';
    divQuadrado.style.animationDuration = '';
    divQuadrado.style.animationIterationCount = '';
  
})  
 */