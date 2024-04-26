package lks.alugames.models

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    private val totalJogosInclusos: Int,
    private val porcentagemDesconto: Int
) : Plano(tipo) {

    override fun getValorAluguel(aluguel: Aluguel): Double {
        return if (totalJogosInclusos > aluguel.gamer.getJogosDoMes(aluguel.periodo.dataInicial.monthValue).size) {
            0.0
        } else {
            val valorOriginal = super.getValorAluguel(aluguel)
            return if (aluguel.gamer.media > 8) valorOriginal - valorOriginal * porcentagemDesconto / 100 else valorOriginal
        }
    }
}
