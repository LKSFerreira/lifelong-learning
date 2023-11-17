const areaEntrada = document.querySelector(".text_content");
const areaSaida = document.querySelector(".texto-saida");
const btnCripto = document.querySelector("#cripto");

const espaco = " ";
const chavesCripto = ["ai", "enter", "imes", "ober", "ufat"];
const chavesVogais = ["a", "e", "i", "o", "u"];

/* Chave
`A letra "a" é convertida para "ai"`
`A letra "e" é convertida para "enter"`
`A letra "i" é convertida para "imes"`
`A letra "o" é convertida para "ober"`
`A letra "u" é convertida para "ufat"`
*/

const mapaCaracteres = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", espaco];

let textoCriptografado = [];
let textoEntrada = [];

btnCripto.addEventListener("click", cripto);

// Transfere o texto do Area de texto para o lado em que deverá ser criptogrado
function cripto() {
    verificaEntrada();
    criptografa();
    mostraSaida(textoCriptografado);
    textoCriptografado = [];
}
// Final da transferencia

// Cripotagra o texto contido na Area de Texto de Entrada iterando e substituindo pelos index das arrays
function criptografa() {
    textoEntrada = areaEntrada.value;

    for (let i = 0; i < textoEntrada.length; i++) {
        //console.log(`Texto Entrada: ${textoEntrada}, letra iterada: ${textoEntrada[i]}`);
        if (chavesVogais.indexOf(textoEntrada[i]) == -1) {
            textoCriptografado += textoEntrada[i];
        }
        for (let j = 0; j < chavesVogais.length; j++) {
            if (textoEntrada[i] == chavesVogais[j]) {
                letra = textoEntrada[i].replace(chavesVogais[j], chavesCripto[j])
                //console.log(true);
                //console.log(letra);
                textoCriptografado += letra
            }
        }
    }//console.log(`Texto de saída: ${textoCriptografado}`);
}//Fim da Criptografia

const btnDescripto = document.querySelector("#descriptografa_01");
const btnDescripto_02 = document.querySelector("#descriptografa_02")

btnDescripto.addEventListener("click", deskryto);
btnDescripto_02.addEventListener("click", deskryto);

// Tranfere o texto criptografado para a Texto de Saida
function deskryto() {
    verificaEntrada();
    descriptografa();

    if (testeCriptografado) {
        mostraSaida(textoCriptografado);
        areaEntrada.value = "";
    }
    mostraSaida(textoCriptografado);
    textoCriptografado = [];
}

// Diferente da criptografia, não é possivel iterar cada index, dessa froma aplica-se o método replace(), trantando todo o valor de entradada como uma única string.
function descriptografa() {
    textoEntrada = areaEntrada.value
    arrText = textoEntrada.split(" ");
    //console.log(arrText);

    for (let i = 0; i < arrText.length; i++) {
        //console.log("iterado: " + arrText[i]);
        for (let j = 0; j < chavesCripto.length; j++) {
            //console.log(chavesCripto[j]);
            arrText[i] = arrText[i].replaceAll(chavesCripto[j], chavesVogais[j]);
            textoCriptografado = arrText.toString();
            textoCriptografado = textoCriptografado.replaceAll(",", " ")
        }
    }
    testeCriptografado = true;
    //console.log(textoCriptografado);
} //Fim da Função


const copia = document.querySelector("#copia");
copia.addEventListener("click", copiaTexto);

//Realiza a cópia do conteúdo criptografado, valor contido no Texto de Saida
function copiaTexto() {

    if (textoEntrada == "" || areaSaida.textContent == " ") {
        verificaEntrada();
    } else {
        navigator.clipboard.writeText(areaSaida.textContent);
        areaSaida.textContent = "Copiado com sucesso!";
        areaEntrada.value = "";
    }
}//Fim da função

const cola = document.querySelector("#cola");
cola.addEventListener("click", colaTexto);

//Cola o conteúdo da area de transferência para a Área de Texto de Entrada
function colaTexto() {
    navigator.clipboard.readText().then(
        clipTexto => areaEntrada.value = clipTexto);
    areaSaida.textContent = " ";
}// Fim da função



// Verifica se o usuario tentou criptografar um espaço em branco ou algum caracter não autorizado.
function verificaEntrada() {
    textoEntrada = areaEntrada.value;

    textoEmBranco();

    for (let i = 0; i < textoEntrada.length; i++) {
        if (mapaCaracteres.indexOf(textoEntrada[i]) === -1) {
            //console.log("NÃO PASSOU NO FILTRO");
            alert("Por gentileza utilize apenas caracteres minúsculos e sem assentos.");
            areaEntrada.value = "";
            return
        }
    }
} // Fim da função

function mostraSaida(frase) {
    areaSaida.textContent = frase;
}

function textoEmBranco() {
    if (textoEntrada == " " || textoEntrada == undefined || textoEntrada == "") {
        alert("Por gentileza digite algo para criptografar.");
        areaEntrada.value = "";
    }
}