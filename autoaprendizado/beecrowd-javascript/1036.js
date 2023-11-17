var input = require('fs').readFileSync('stdin', 'utf8');

var entradaValores = input.split(' ').map(function (element) {
    return parseFloat(element);
});

const valorA = entradaValores[0];
const valorB = entradaValores[1];
const valorC = entradaValores[2];

const valorDelta = (valorB ** 2) - (4 * valorA * valorC);
const valorR1 = (-(valorB) + Math.sqrt(valorDelta)) / (2 * valorA);
const valorR2 = (-(valorB) - Math.sqrt(valorDelta)) / (2 * valorA);

if (valorA == 0 || valorDelta < 0) {
    console.log('Impossivel calcular');
} else {
    console.log(`R1 = ${valorR1.toFixed(5)}\nR2 = ${valorR2.toFixed(5)}`);
}