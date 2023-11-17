var input = require('fs').readFileSync('stdin', 'utf8');
var lines = input.split('\n');

function somarDoisInteiros(valorA, valorB){
    return parseInt(valorA) + parseInt(valorB);
}
const resultadoSoma = somarDoisInteiros(lines[0], lines[1]);

console.log(`X = ${resultadoSoma}`);