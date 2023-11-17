var input = require('fs').readFileSync('stdin', 'utf8');

var lines = input.split('\n').map(function (element) {
    return parseFloat(element);
});

function calcularSalarioMensal(valorA, valorB) {
    return valorA * valorB;
}
const resultadoCalculoSalarioMensal = calcularSalarioMensal(lines[1], lines[2])
console.log(`NUMBER = ${lines[0]}`);
console.log(`SALARY = U$ ${resultadoCalculoSalarioMensal.toFixed(2)}`);