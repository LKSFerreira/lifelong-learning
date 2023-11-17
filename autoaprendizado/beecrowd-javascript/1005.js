var input = require('fs').readFileSync('stdin', 'utf8');

var lines = input.split('\n').map(function (element) {
    return parseFloat(element);
});

function calcularMediaPonderadaDoisFloat(valorA, valorB) {
    return (valorA * 3.5 + valorB * 7.5) / (3.5 + 7.5);
}

const resultadoMediaDoisFloat = calcularMediaPonderadaDoisFloat(lines[0], lines[1]);
console.log(`MEDIA = ${resultadoMediaDoisFloat.toFixed(5)}`);