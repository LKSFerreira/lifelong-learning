var input = require('fs').readFileSync('stdin', 'utf8');

var lines = input.split('\n').map(function (element) {
    return parseInt(element);
});

lines.sort(function (valorA, valorB) {
    return valorA - valorB;
});

let somatoriaNaoMultiplosDe13 = 0;

for (let index = lines[0]; index <= lines[1]; index++) {

    if (index % 13 === 0)
        continue;
    somatoriaNaoMultiplosDe13 += index;
}

console.log(somatoriaNaoMultiplosDe13);