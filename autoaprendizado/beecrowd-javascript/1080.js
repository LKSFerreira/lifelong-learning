var input = require('fs').readFileSync('stdin', 'utf8');

var lines = input.split('\n').map(function (element) {
    return parseInt(element);
});

let maiorValor = 0;

lines.forEach(function (element) {
    if (element > maiorValor) {
        maiorValor = element;
    }
})
const index = lines.indexOf(maiorValor) + 1;

console.log(maiorValor);
console.log(index);