var input = require('fs').readFileSync('stdin', 'utf8');

var lines = input.split('\n').map(function (element) {
    return parseFloat(element);
});

function calcularVolumeEsfera(raio) {
    const pi = 3.14159;
    return (4 / 3) * pi * (raio ** 3);
}

const resultadoVolumeEsfera = calcularVolumeEsfera(lines[0]);
console.log(`VOLUME = ${resultadoVolumeEsfera.toFixed(3)}`);