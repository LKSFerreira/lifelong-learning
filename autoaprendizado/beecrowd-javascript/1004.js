var input = require('fs').readFileSync('stdin', 'utf8');

var lines = input.split('\n').map(function(element){
    return parseInt(element);
});

function multiplicarDoisInteiros(valorA, valorB){
    return valorA*valorB;
}

const resultadoDaMultiplicacao = multiplicarDoisInteiros(lines[0], lines[1]);
console.log(`PROD = ${resultadoDaMultiplicacao}`);