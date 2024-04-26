package lks.alugames.model

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo
) {
    val valorDoAluguel: Double = gamer.plano.getValorAluguel(this)

    override fun toString(): String {
        return "Jogo: ${jogo.titulo} alugado por ${gamer.name} pelo valor total de R$ $valorDoAluguel"
    }
}
