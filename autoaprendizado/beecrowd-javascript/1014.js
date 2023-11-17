var input = require('fs').readFileSync('stdin', 'utf8');

var entradaValores = input.split('\n').map(function (element) {
    return parseFloat(element);
});

const valorEmKm = entradaValores[0];
const consumoGasolinaAutomovel = entradaValores[1];

const consumoMedioAutomovel = valorEmKm / consumoGasolinaAutomovel;
console.log(`${consumoMedioAutomovel.toFixed(3)} km/l`);