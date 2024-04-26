package lks.alugames.model

class PlanoAssinatura(tipo: String, val mensalidade: Double, val totalJogosInclusos: Int) : Plano(tipo) {

    override fun getValorAluguel(aluguel: Aluguel): Double {
        return if (totalJogosInclusos > aluguel.gamer.getJogosDoMes(aluguel.periodo.dataInicial.monthValue).size ) {
            0.0
        } else {
            super.getValorAluguel(aluguel)
        }
    }
}
