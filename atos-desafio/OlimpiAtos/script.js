export async function buscarCorredores() {
  const response = await fetch(
    "http://127.0.0.1:5500/pages/api/v1/runner.json"
  );
  const data = await response.json();
  criarCorredores(data);
  return data;
}

async function criarCorredores(corredores) {
  const container = document.querySelector(".interior");
  container.innerHTML = "";

  corredores.forEach((corredor, index) => {
    const a = document.createElement("a");
    a.id = `corredor${index + 1}`;
    a.className = "btn";
    a.href = `#open-modal${index + 1}`;
    a.textContent = `🏃 ${corredor.nome}`;

    // Criamos um modal para cada corredor
    const modal = document.createElement("div");
    modal.id = `open-modal${index + 1}`;
    modal.className = "modal-window";
    modal.innerHTML = `
        <div>
            <a href="#" title="Close" class="modal-close">Fechar</a>
            <h1>${corredor.nome}</h1>
            <div>${corredor.descrição}</div>
            <br />
            <div><small>Consumo de água 👇🚰</small></div>
            X garrafas
        </div>
      `;

    // Adicionamos o modal ao corpo do documento
    document.body.appendChild(modal);

    a.addEventListener("mouseover", function () {
      document.querySelector(".imagem-corredor").src = `pages/assets/corredor${
        index + 1
      }.png`;
    });

    container.appendChild(a);
  });
}

buscarCorredores();
