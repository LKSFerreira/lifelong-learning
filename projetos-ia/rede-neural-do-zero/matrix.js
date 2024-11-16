class Matrix {
    constructor(linhas, colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        // this.data = Array(this.linhas).fill().map(() => Array(this.colunas).fill(0));
        this.data = [];
        for (let i = 0; i < this.linhas; i++) {
            let arr = [];
            for (let j = 0; j < this.colunas; j++) {
                arr.push(Math.floor(Math.random() * 10));
            }
            this.data.push(arr);
        }
    }
    
    map() {
    }

    static adiciona(matrix_A, matrix_B) {
    }
}