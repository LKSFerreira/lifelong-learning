const ancorButton = document.querySelectorAll(".ancor-button");

ancorButton.forEach((elemento, index) => {
  elemento.addEventListener("click", () => {
    const modal = document.createElement("div");
    modal.id = `open-modal${index}`;
    modal.classList.add("modal-window");
    modal.innerHTML = `
      <div>
        <a href="#" title="Close" class="modal-close">Fechar</a>
        <div id="bandeiras-container"></div>
      </div>
    `;
    document.body.appendChild(modal);
  });
});