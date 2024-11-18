class RedeNeural {
    constructor(quantidade_nodes_entrada, quantidade_nodes_ocultos, quantidade_nodes_saida) {
        this.quantidade_nodes_entrada = quantidade_nodes_entrada;
        this.quantidade_nodes_ocultos = quantidade_nodes_ocultos;
        this.quantidade_nodes_saida = quantidade_nodes_saida;

        this.bias_entrada_oculto = new Matrix(this.quantidade_nodes_ocultos, 1);
        this.bias_entrada_oculto.randomiza();
        this.bias_oculto_saida = new Matrix(this.quantidade_nodes_saida, 1);
        this.bias_oculto_saida.randomiza();

        this.pesos_entrada_oculto = new Matrix(this.quantidade_nodes_ocultos, this.quantidade_nodes_entrada);
        this.pesos_entrada_oculto.randomiza();

        this.pesos_oculto_saida = new Matrix(this.quantidade_nodes_saida, this.quantidade_nodes_ocultos);
        this.pesos_oculto_saida.randomiza();

        this.learning_rate = 2;
    }

    treino(array_entrada, array_saida) {
        // ENTRADA -> OCULTO
        // Feedforward
        let entrada = Matrix.arrayParaMatrix(array_entrada);
        let oculto = Matrix.multiplica(this.pesos_entrada_oculto, entrada);
        oculto = Matrix.adiciona(oculto, this.bias_entrada_oculto);
        oculto.map(sigmoid);
        
        // OCUlTO -> SAIDA
        // d(Signmoid) = Output * (1 - Output)
        let saida = Matrix.multiplica(this.pesos_oculto_saida, oculto);
        saida = Matrix.adiciona(saida, this.bias_oculto_saida);
        saida.map(sigmoid);

        // Backpropagation

        // SAIDA -> OCULTO
        let esperado = Matrix.arrayParaMatrix(array_saida);
        let erro_saida = Matrix.subtrai(esperado, saida);
        let derivada_saida = Matrix.map(saida, dsigmoid);

        let oculto_transposta = Matrix.transposta(oculto);

    
        let gradiente_saida = Matrix.hadamard(erro_saida, derivada_saida);
        gradiente_saida  = Matrix.escalar_multiplica(gradiente_saida, this.learning_rate);

        // Ajuste dos BIAS da camada SAIDA -> OCULTO
        this.bias_oculto_saida = Matrix.adiciona(this.bias_oculto_saida, gradiente_saida);

        // Ajuste dos PESOS da camada SAIDA -> OCULTO
        let delta_dos_pesos_oculto_da_saida = Matrix.multiplica(gradiente_saida, oculto_transposta);
        this.pesos_oculto_saida = Matrix.adiciona(this.pesos_oculto_saida, delta_dos_pesos_oculto_da_saida);

        // OCULTO -> ENTRADA
        let pesos_oculto_saida_transposta = Matrix.transposta(this.pesos_oculto_saida);
        let erro_oculto = Matrix.multiplica(pesos_oculto_saida_transposta, erro_saida);
        let derivada_oculto = Matrix.map(oculto, dsigmoid);
        let entrada_transposta = Matrix.transposta(entrada);

        let gradiente_oculto = Matrix.hadamard(erro_oculto, derivada_oculto);
        gradiente_oculto = Matrix.escalar_multiplica(gradiente_oculto, this.learning_rate);

        // Ajuste dos BIAS da camada OCULTO -> ENTRADA
        this.bias_entrada_oculto = Matrix.adiciona(this.bias_entrada_oculto, gradiente_oculto);
        
        // Ajuste dos PESOS da camada OCULTO -> ENTRADA
        let delta_dos_pesos_entrada_do_oculto = Matrix.multiplica(gradiente_oculto, entrada_transposta);
        this.pesos_entrada_oculto = Matrix.adiciona(this.pesos_entrada_oculto, delta_dos_pesos_entrada_do_oculto);
    }

    predict(array_entrada) {
        // ENTRADA -> OCULTO
        // Feedforward
        let entrada = Matrix.arrayParaMatrix(array_entrada);
        let oculto = Matrix.multiplica(this.pesos_entrada_oculto, entrada);
        oculto = Matrix.adiciona(oculto, this.bias_entrada_oculto);
        oculto.map(sigmoid);
        
        // OCUlTO -> SAIDA
        // d(Signmoid) = Output * (1 - Output)
        let saida = Matrix.multiplica(this.pesos_oculto_saida, oculto);
        saida = Matrix.adiciona(saida, this.bias_oculto_saida);
        saida.map(sigmoid);
        saida = Matrix.matrixParaArray(saida);
        return saida;
    }
}

function sigmoid(x) {
    return 1 / (1 + Math.exp(-x));
}

function dsigmoid(x) {
    return x * (1 - x);
}