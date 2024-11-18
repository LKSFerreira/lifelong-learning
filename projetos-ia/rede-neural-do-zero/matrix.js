class Matrix {
    constructor(linhas, colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        // this.data = Array(this.linhas).fill().map(() => Array(this.colunas).fill(0));
        this.data = [];
        for (let i = 0; i < this.linhas; i++) {
            let arr = [];
            for (let j = 0; j < this.colunas; j++) {
                arr.push(0);
            }
            this.data.push(arr);
        }
    }

    print() {
        console.table(this.data);
    }

    randomiza() {
        this.map(() => Math.floor(Math.random() * 10)); //Math.random() * 2 - 1);
    }

    map(func) {
        this.data = this.data.map((linha, i) => {
            return linha.map((valor, j) => {
                return func(valor, i, j);
            });
        });
        return this;
    }

    static transposta(matrix_A) {
        let matrix = new Matrix(matrix_A.colunas, matrix_A.linhas);

        matrix.map((valor, i, j) => {
            return matrix_A.data[j][i];
        });

        return matrix;
    }

    
    // Métodos estáticos de Matriz x Escalar
    static escalar_multiplica(matrix_A, escalar) {
        let matrix = new Matrix(matrix_A.linhas, matrix_A.colunas);

        matrix.map((valor, i, j) => {
            return matrix_A.data[i][j] * escalar;
        });
        
        return matrix;
    }

    static arrayParaMatrix(array) {
        return new Matrix(array.length, 1).map((elem, i, j) => array[i]);
    }

    static matrixParaArray(objeto) {
        let array = [];
        objeto.map((valor, i, j) => {
            array.push(valor);
        });
        return array;
    }

    // Métodos estáticos de Matriz x Matriz
    static hadamard(matrix_A, matrix_B) {
        let matrix = new Matrix(matrix_A.linhas, matrix_A.colunas);

        matrix.map((valor, i, j) => {
            return matrix_A.data[i][j] * matrix_B.data[i][j];
        });

        return matrix;
    }

    static subtrai(matrix_A, matrix_B) {
        let matrix = new Matrix(matrix_A.linhas, matrix_A.colunas);

        matrix.map((valor, i, j) => {
            return matrix_A.data[i][j] - matrix_B.data[i][j];
        });

        return matrix;
    }

    static adiciona(matrix_A, matrix_B) {
        let matrix = new Matrix(matrix_A.linhas, matrix_A.colunas);

        matrix.map((valor, i, j) => {
            return matrix_A.data[i][j] + matrix_B.data[i][j];
        });

        return matrix;
    }

    static map(matrix_A, func) {
        let matrix = new Matrix(matrix_A.linhas, matrix_A.colunas);

        matrix.data = matrix_A.data.map((linha, i) => {
            return linha.map((valor, j) => {
                return func(valor, i, j);
            });
        });
        return matrix;
    }

    static multiplica(matrix_A, matrix_B) {
        let matrix = new Matrix(matrix_A.linhas, matrix_B.colunas);

        matrix.map((valor, i, j) => {
            let sum = 0;
            for (let k = 0; k < matrix_A.colunas; k++) {
                sum += matrix_A.data[i][k] * matrix_B.data[k][j];
            }
            return sum;
        });
        return matrix;
    }
}