var input = require('fs').readFileSync('stdin', 'utf8');

var lines = input.split('\n').map(function (element) {
    return parseInt(element);
});

function calcularDiferencaEntreProdutos(valorA, valorB, valorC, valorD) {
    return (valorA * valorB) - (valorC * valorD);
}
const resultadoDiferencaEntreProdutos = calcularDiferencaEntreProdutos(lines[0],lines[1], lines[2], lines[3]);
console.log(`DIFERENCA = ${resultadoDiferencaEntreProdutos}`);