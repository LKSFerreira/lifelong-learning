package lks.alugames.model

sealed class Plano(var tipo: String) {
    open fun getValorAluguel(aluguel: Aluguel): Double {
        return aluguel.jogo.preco + aluguel.periodo.getDias()
    }
}