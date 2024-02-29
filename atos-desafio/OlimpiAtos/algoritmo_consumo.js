import { buscarCorredores } from "./script.js";

fetch("http://127.0.0.1:5500/pages/api/v1/race-track-paris.json")
  .then((response) => response.json()) // Convertemos a resposta em JSON
  .then((data) => calcular_consumo_de_agua(data));

function calcular_consumo_de_agua(data) {
  data.forEach((element) => {
    console.log(element);
  });
}

buscarCorredores().then((data) => {
  console.log(data); // Imprime os dados
});
