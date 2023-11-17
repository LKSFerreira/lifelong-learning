var input = require('fs').readFileSync('stdin', 'utf8');

var entradaValores = input.split(' ').map(function (element) {
    return parseInt(element);
});

const maiorValor = entradaValores.sort(function (valorA, valorB) {
    return valorA - valorB;
});
console.log(`${maiorValor[2]} eh o maior`);