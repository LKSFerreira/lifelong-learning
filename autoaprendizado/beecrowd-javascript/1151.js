var input = require('fs').readFileSync('stdin', 'utf8');

const valorEntrada = parseInt(input);

function calcularSequenciaDeFibonnaci(quantidadeDaSequencia) {
    if (quantidadeDaSequencia === 1) {
        console.log("0");
        return;
    }

    let sequenciaFabonnaci = "0 1";
    let penultimo = 0;
    let ultimo = 1;

    for (let index = 2; index < quantidadeDaSequencia; index++) {
        let valorAtual = penultimo + ultimo;
        sequenciaFabonnaci += " " + valorAtual;
        penultimo = ultimo;
        ultimo = valorAtual;
    }
    console.log(sequenciaFabonnaci)
}

calcularSequenciaDeFibonnaci(valorEntrada);