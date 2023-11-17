var input = require('fs').readFileSync('stdin', 'utf8');

var lines = input.split('\n').map(function (element) {
    return parseFloat(element);
});

function calcularMediaPonderadaDoisFloat(valorA, valorB, valorC) {
    return (valorA * 2 + valorB * 3 + valorC * 5) / (2 + 3 + 5);
}

const resultadoMediaDoisFloat = calcularMediaPonderadaDoisFloat(lines[0], lines[1], lines[2]);
console.log(`MEDIA = ${resultadoMediaDoisFloat.toFixed(1)}`);