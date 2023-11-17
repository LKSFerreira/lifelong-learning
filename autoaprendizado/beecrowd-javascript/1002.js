var input = require('fs').readFileSync('stdin', 'utf8');

var lines = input.split('\n').map(function(element){
    return parseFloat(element);
});

const valorPi = 3.14159;
const areaCirculo = valorPi*(lines[0]**2);

console.log(`A=${areaCirculo.toFixed(4)}`);