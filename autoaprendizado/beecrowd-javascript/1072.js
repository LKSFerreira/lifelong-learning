var input = require('fs').readFileSync('stdin', 'utf8');

var lines = input.split('\n').map(function (element) {
    return parseInt(element);
});

const quantidadeDeCasos = lines[0];

let quantidadeDentroDoIntervalo = 0;
let quantidadeForaDoIntervalo = 0;

for (let i = 1; i <= lines[0]; i++) {

    if (lines[i] >= 10 && lines[i] <= 20) {
        quantidadeDentroDoIntervalo++;
    } else {
        quantidadeForaDoIntervalo++;
    }
}

console.log(`${quantidadeDentroDoIntervalo} in`);
console.log(`${quantidadeForaDoIntervalo} out`);