package lks.alugames.models

import java.math.BigDecimal

class PlanoAssinatura(
    tipo: String,
    private val mensalidade: Double,
    private val totalJogosInclusos: Int,
    private val porcentagemDesconto: Int,
    id: Int = 0
) : Plano(tipo) {

    override fun getValorAluguel(aluguel: Aluguel): BigDecimal {
        return if (totalJogosInclusos > aluguel.gamer.getJogosDoMes(aluguel.periodo.dataInicial.monthValue).size) {
            0.0.toBigDecimal()
        } else {
            val valorOriginal = super.getValorAluguel(aluguel)
            return if (aluguel.gamer.media > 8) valorOriginal - valorOriginal * (porcentagemDesconto / 100).toBigDecimal() else valorOriginal
        }
    }

    override fun toString(): String {
        return "Plano Assinatura:\n" +
                "Tipo: $tipo\n" +
                "Id: $id\n" +
                "Mensalidade: $mensalidade\n" +
                "Total de jogos inclusos: $totalJogosInclusos\n" +
                "Porcentagem de desconto: $porcentagemDesconto"
    }


}
