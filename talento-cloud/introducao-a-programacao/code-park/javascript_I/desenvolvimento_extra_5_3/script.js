document.addEventListener('DOMContentLoaded', (event) => {
    // Utilizando o método simples para adicionar um título
    const titulo = document.createElement('h1');
    titulo.setAttribute('id', 'titulo');
    titulo.textContent = 'Bem-vindo à Nossa Loja Virtual';
    document.body.appendChild(titulo);

    // Utilizando o método complexo para criar e adicionar um produto
    const produto = document.createElement('div');
    produto.innerHTML = `
        <h2>Xbox Game Pass Ultimate Cloud Gaming</h2>
        <pJogue centenas de jogos de alta qualidade sozinho ou com amigos no console, PC ou nuvem. Há sempre algo novo para jogar com o Ultimate.</p>
        <p>Preço: R$<span>49,99</span></p>
        <img src="https://th.bing.com/th/id/OIP.fAsH_W3aWfPdy6KABFvFhwAAAA?rs=1&pid=ImgDetMain" alt="Imagem logo do cartão de compra do xbox game pass">
    `;
    document.body.appendChild(produto);
});