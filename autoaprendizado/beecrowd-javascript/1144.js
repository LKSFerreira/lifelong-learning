const input = require('fs').readFileSync('stdin', 'utf8');

for (let index = 1; index <= input; index++) {
    let valorA = index * index;
    let valorB = valorA * index;
    console.log(`${index} ${valorA} ${valorB}`);
    console.log(`${index} ${valorA + 1} ${valorB + 1}`);
}