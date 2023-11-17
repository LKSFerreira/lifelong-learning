var input = require('fs').readFileSync('stdin', 'utf8');

const lines = input.split('\n');

// Criação das variaveis necessárias
let quantidadeMinimaDeMovimentos = 0;
let ehVerticesEArestas = false;
let matriz = 0;
const segmentos = [];

// Realizando tratamento dos dados
// O primeiro valor de entrada sempre será a quantidade de casos para teste, por isso a iteração começa no 1, pois o lines[0] é a quantidade de casos
// O valor unitário desacompanhado de outro valor é nódolu inicial
// O primero valor acompanhar indica a quantidade de vertice e quantidade de arestas V - A, para saber o tamanho da matriz basta fazer raiz quadrada dos vertices

for (let i = 1; i < lines.length; i++) {

    if (lines[i].length <= 2) {
        // Se entrar aqui é porque o numero esta desacomnhado, e a proxima iteração e o V-A
        //const nodoInicalEFinal = parseInt(lines[i]);
        ehVerticesEArestas = true;
    } else {
        if (ehVerticesEArestas) {

            // Se entrar aqui é a iteração V-A, quero extrar o tamanho da matriz, pois será util no algoritmo
            const arestas = lines[i].split(' ').map(function (element) {
                return parseInt(element);
            });

            matriz = Math.sqrt(parseInt(arestas[0]));
            ehVerticesEArestas = false;
            continue;
        }

        // Extraio dos vestices de passagem para um vetor chamado segmentos
        const arestas = lines[i].split(' ').map(function (element) {
            return parseInt(element);
        });

        segmentos.push(...arestas);
    }
}

function subtrairVestices(verticeB, verticeA) {
    return verticeB - verticeA;
}

function movimentoHorizontal(valorEntreVertices) {
    if (valorEntreVertices === 1 || valorEntreVertices === -1) {
        quantidadeMinimaDeMovimentos++;
    }
}

function movimentoVertical(valorEntreVertices) {
    if (valorEntreVertices === matriz) {
        quantidadeMinimaDeMovimentos++;
    }
}

function verificarMovimentosPossiveis(vetor) {
    for (let i = 0; i < vetor.length; i++) {

        const verticeA = vetor[i];
        const verticeB = vetor[i + 1];
        //Elemento seguinte da iteração
        let valorEntreVertices = subtrairVestices(verticeB, verticeA);

        if (valorEntreVertices === 0) continue;

        //Caso valor seja 1 ou -1 signfica que o desenhou para direita ou esquerda
        movimentoHorizontal(valorEntreVertices);

        // Caso o valor seja igual ao valor da matriz significa que o desenho foi para cima ou para baixo
        movimentoVertical(valorEntreVertices);


        // movimento irregular
        if (valorEntreVertices != 1 && valorEntreVertices != matriz && valorEntreVertices != -1){
            quantidadeMinimaDeMovimentos++;
            movimentoVertical(valorEntreVertices);
        }
    }
    const ultimoValor = vetor[vetor.length - 1];
}

verificarMovimentosPossiveis(segmentos);