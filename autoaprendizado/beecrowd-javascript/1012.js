var input = require('fs').readFileSync('stdin', 'utf8');

var entradaValores = input.split(' ').map(function (element) {
    return parseFloat(element);
});

const PI = 3.14159;

const valorA = entradaValores[0];
const valorB = entradaValores[1];
const valorC = entradaValores[2];

const areaTriangulo = (valorA * valorC) / 2;
const areaCirculo = (PI * (valorC ** 2));
const areaTrapesio = ((valorA + valorB) * valorC) / 2;
const areaQuadrado = (valorB ** 2);
const areaRetangulo = (valorA * valorB);

console.log(`TRIANGULO: ${areaTriangulo.toFixed(3)}
CIRCULO: ${areaCirculo.toFixed(3)}
TRAPEZIO: ${areaTrapesio.toFixed(3)}
QUADRADO: ${areaQuadrado.toFixed(3)}
RETANGULO: ${areaRetangulo.toFixed(3)}`);