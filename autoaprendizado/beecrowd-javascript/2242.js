var input = require('fs').readFileSync('stdin', 'utf8');

const inputInvertido = inverterPalavra(input);
const sequenciaVogais = removerConsoantes(input);
const vogaisInvertidas = removerConsoantes(inputInvertido);

if (sequenciaVogais == vogaisInvertidas) {
    console.log('S');
} else {
    console.log('N');
}

function inverterPalavra(sequenciaVogais) {
    let vogaisInvertidas = '';
    for (let i = sequenciaVogais.length - 1; i >= 0; i--) {
        vogaisInvertidas += sequenciaVogais[i];
    }
    return vogaisInvertidas;
}

function removerConsoantes(palavraComConsoante) {
    let vogais = ["a", "e", "i", "o", "u"];
    let caracteres = palavraComConsoante.split("");
    let novosCaracteres = caracteres.filter(function (caractere) {
        return vogais.includes(caractere.toLowerCase());
    });
    return novosCaracteres.join("");
}