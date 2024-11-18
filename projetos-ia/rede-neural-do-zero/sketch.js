var inicia_treinamento = true;

function setup() {
    createCanvas(500, 500);
    background(0);

    rede_neural = new RedeNeural(2, 3, 1);

    // XOR Problem
    dataset = {
        entradas: [
            [1, 1],
            [1, 0],
            [0, 1],
            [0, 0]
        ],
        saidas: [
            [0],
            [1],
            [1],
            [0]
        ]
    }
    console.log("Treinamento Iniciado");
    tempo_incial = millis();

}

function mostra_resultado() {
    console.log(rede_neural.predict([1, 1]));
    console.log(rede_neural.predict([1, 0]));
    console.log(rede_neural.predict([0, 1]));
    console.log(rede_neural.predict([0, 0]));
}

let proximo_de_zero = 0.0002;
let proximo_de_um = 0.9998;

function draw() {
    if (inicia_treinamento) {
        console.log("Treinando...");
        for (let i = 0; i < 100000; i++) {
            let index = floor(random() * 4);
            rede_neural.treino(dataset.entradas[index], dataset.saidas[index]);
        }

        const valores_proximo_do_esperado =
            rede_neural.predict([1, 1])[0] < proximo_de_zero &&
            rede_neural.predict([1, 0])[0] > proximo_de_um &&
            rede_neural.predict([0, 1])[0] > proximo_de_um &&
            rede_neural.predict([0, 0])[0] < proximo_de_zero;

        if (valores_proximo_do_esperado) {
            inicia_treinamento = false;

            console.log('Treinamento finalizado');
            console.log("Tempo de treinamento: " + (millis() - tempo_incial) / 1000 + " segundos");
        }
    }
}
