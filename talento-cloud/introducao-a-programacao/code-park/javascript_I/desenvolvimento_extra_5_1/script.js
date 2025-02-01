// script.js
window.onload = function() {
    // Capturando os elementos
    var titulo = document.getElementById('titulo');
    var listaNaoOrdenada = document.getElementById('lista-nao-ordenada');
    var meuLink = document.getElementById('meu-link');
    var listaOrdenada = document.getElementById('lista-ordenada');

    // Adicionando conteúdo textual
    titulo.innerText = 'Educação é a chave!';
    meuLink.innerText = 'Proze Educação';

    // Adicionando itens à lista não ordenada
    listaNaoOrdenada.innerHTML = '<li>Educação Infantil</li><li>Educação Fundamental</li><li>Educação Superior</li>';

    // Adicionando itens com links à lista ordenada
    listaOrdenada.innerHTML = '<li><a href="https://www.coursera.org">Coursera</a></li><li><a href="https://www.edx.org">edX</a></li><li><a href="https://www.khanacademy.org">Khan Academy</a></li>';
}
