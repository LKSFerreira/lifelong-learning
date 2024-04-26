package lks.alugames.models

import lks.alugames.utils.format

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo
) {
    val valorDoAluguel: Double = gamer.plano.getValorAluguel(this)

    override fun toString(): String {
        return "Jogo: ${jogo.titulo} alugado por ${gamer.nome} pelo valor total de R$ ${valorDoAluguel.format(2)}"
    }
}
