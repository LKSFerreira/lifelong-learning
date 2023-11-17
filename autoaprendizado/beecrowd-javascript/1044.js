var input = require('fs').readFileSync('stdin', 'utf8');

var lines = input.split(' ').map(function(element){
    return parseInt(element);
});

function testarMultiplicidade(valorA, valorB){
    if (valorB % valorA == 0 || valorA % valorB == 0)
    {
        return console.log('Sao Multiplos');
    } else {
        return console.log('Nao sao Multiplos');
    }
}

testarMultiplicidade(lines[0], lines[1]);