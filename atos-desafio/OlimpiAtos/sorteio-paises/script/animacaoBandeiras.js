import { getData } from "../service/service.js";
import { ordemDeApresentacao } from "./sorteioPaises.js";

const ENDPOINT_PAISES = "./api/v1/paises.json";

getData(ENDPOINT_PAISES)
  .then((paises) => {
    console.log("Paises:", paises);
    animacaoBandeiras(paises);
  })
  .catch((error) => {
    console.error("Erro ao carregar imagens dos países:", error);
  });

const container = document.getElementById("bandeiras-container");
container.innerHTML = ""; // Limpa o contêiner

async function animacaoBandeiras(paises) {
  const grupos = await ordemDeApresentacao;

  for (let i = 0; i < grupos.length; i++) {
    const grupo = grupos[i];
    console.log(`Grupo ${i + 1}:`, grupo);

    for (let j = 0; j < grupo.length; j++) {
      const pais = grupo[j];

      console.log(`País ${j + 1}:`, pais);

      const bandeirasAnimadas = Object.values(paises).filter((nomeDoPais) =>
        pais.includes(nomeDoPais.pais)
      );

      console.log("Bandeiras animadas:", bandeirasAnimadas);

      const grupoContainer = document.createElement("div");
      grupoContainer.classList.add("grupo-bandeiras");
      grupoContainer.style.top = `${i * 100}px`; // Ajuste conforme necessário

      const img = document.createElement("img");
      img.src = bandeirasAnimadas[0].img;
      img.classList.add("bandeira");
      img.style.animationDelay = `${j * 0.5}s`; // Ajuste o delay conforme necessário
      grupoContainer.appendChild(img);

      container.appendChild(grupoContainer);
    }
  }

}
