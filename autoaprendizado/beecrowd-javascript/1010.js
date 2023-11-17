var input = require('fs').readFileSync('stdin', 'utf8');

var entradaPecas = input.split('\n');

let primeiraPeca = entradaPecas[0].split(' ').map(function (element) {
    return parseFloat(element);
});

let segundaPeca = entradaPecas[1].split(' ').map(function (element) {
    return parseFloat(element);
});

function calcularTotalFatura(quantidadePrimeiraPeca, valorPrimeiraPeca, quantidadeSegundaPeca, valorSegundaPeca) {
    return (quantidadePrimeiraPeca * valorPrimeiraPeca) + (quantidadeSegundaPeca*valorSegundaPeca);
}

const totalFatura = calcularTotalFatura(primeiraPeca[1], primeiraPeca[2], segundaPeca[1], segundaPeca[2]);
console.log(`VALOR A PAGAR: R$ ${totalFatura.toFixed(2)}`);