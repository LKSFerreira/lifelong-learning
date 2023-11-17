export class Conta {
    constructor(saldoInicial, cliente, agencia) {
        this._agencia = agencia;
        this._cliente = cliente;
        this._saldo = saldoInicial;
        if (this.constructor == Conta){
            throw new Error("Você não deveria instanciar um objeto tipo Conta Diretamente");
        }
    }

    set cliente(cliente) {
        if (cliente instanceof Cliente) {
            this._cliente = cliente;
        }
    }

    get cliente() {
        return this._cliente;
    }

    get saldo() {
        return this._saldo;
    }

    //Método abstrato
    sacar(valor) {
        throw new Error("O médodo sacar() da conta é abstrato");
    }

    _sacar(valor, taxa) {
        const valorSacado = taxa * valor;
        if (this._saldo >= valorSacado) {
            this._saldo -= valorSacado;
            return valorSacado
        }
        return 0;
    }

    depositar(valor) {
        if (valor <= 0) {
            return;
        }
        this._saldo += valor;
    }

    transferir(valor, conta) {
        const valorSacado = this.sacar(valor);
        conta.depositar(valorSacado);
        console.log("Transferencia realizada com sucesso.")
    }
}