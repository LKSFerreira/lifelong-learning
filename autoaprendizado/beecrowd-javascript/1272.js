var input = require('fs').readFileSync('stdin', 'utf8');

var lines = input.split('\n');

const aUnicode = 97;
const zUnicode = 122;

for (let i = 1; i <= parseInt(lines[0]); i++) {
    let fraseCriptografada = lines[i].split(' ');

    let fraseDescriptograda = '';

    for (let j = 0; j < fraseCriptografada.length; j++) {
        if (fraseCriptografada[j].valueOf(0).charCodeAt() >= aUnicode && fraseCriptografada[j].valueOf(0).charCodeAt() <= zUnicode) {
            fraseDescriptograda += fraseCriptografada[j].charAt(0);
        }
    }
    console.log(fraseDescriptograda);
}