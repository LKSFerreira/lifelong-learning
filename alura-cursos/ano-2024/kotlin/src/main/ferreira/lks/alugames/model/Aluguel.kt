package lks.alugames.model

import java.time.LocalDate
import java.time.Period

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo,
    val valorDoAluguel: Double = jogo.preco * periodo.getDias()
) {

    override fun toString(): String {
        return "Jogo: ${jogo.titulo} alugado por ${gamer.name} pelo valor total de R$ $valorDoAluguel"
    }
}
