var input = require('fs').readFileSync('stdin', 'utf8');

const entradaValores = input.split(' ').map(function (element) {
    return parseInt(element);
});

const ordemCrescente = [...entradaValores].sort(function (valorA, valorB) {
    return valorA - valorB;
});

ordemCrescente.forEach(function (element) {
    console.log(element);
});

console.log();

entradaValores.forEach(function (element) {
    console.log(element);
});