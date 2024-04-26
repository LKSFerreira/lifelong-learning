package lks.alugames.models

import lks.alugames.utils.format
import java.math.BigDecimal

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo
) {
    private val valorDoAluguel: BigDecimal = gamer.plano.getValorAluguel(this)

    override fun toString(): String {
        return "Jogo: ${jogo.titulo} alugado por ${gamer.nome} pelo valor total de R$ ${valorDoAluguel.format(2)}"
    }
}
