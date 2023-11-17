var input = require('fs').readFileSync('stdin', 'utf8');
const line = parseInt(input);

for (let index = 2; index <= line; index += 2) {
    console.log(`${index}^2 = ${index**2}`)
}