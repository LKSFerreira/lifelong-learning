var input = require('fs').readFileSync('stdin', 'utf8');

var lines = input.split('\n').map(function (element) {
    return parseFloat(element);
});

function calcularSalarioComBonus(salario, totalVendas) {
    return (salario) + (totalVendas * 0.150);
}

const salarioTotal = calcularSalarioComBonus(lines[1], lines[2]);

console.log(`TOTAL = R$ ${salarioTotal.toFixed(2)}`);