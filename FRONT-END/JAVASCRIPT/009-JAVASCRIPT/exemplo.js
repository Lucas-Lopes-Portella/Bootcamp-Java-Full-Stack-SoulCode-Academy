let valoresAPI = ['Amanda', 'André', 'Andrew', 'Antonio', 'Aurelio', 'Manuela'];
const div = document.getElementById('lista');
const btn = document.querySelector('button');


/* para cada elemento do array inserir em uma li dentro da ul */
btn.addEventListener('click' , () => {
    const ul = document.createElement('ul'); // cria um novo elemento html
    
    div.appendChild(ul); // adiciona um novo elemento filho ao elemento

    valoresAPI.forEach((valor)=>{
        const li = document.createElement('li');
        li.textContent = valor;

        ul.appendChild(li);
    })
    console.log(div);
})