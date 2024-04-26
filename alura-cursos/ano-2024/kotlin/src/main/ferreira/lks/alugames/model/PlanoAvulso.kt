package lks.alugames.model

data class PlanoAvulso(var tipo: String) {

    fun getValorAluguel(aluguel: Aluguel): Double {
//        Double = jogo.preco * periodo.getDias()
        return when (tipo) {
            "BRONZE" -> aluguel.jogo.preco * aluguel.periodo.getDias()
            "PRATA" -> aluguel.jogo.preco * aluguel.periodo.getDias() * 0.9
            "OURO" -> aluguel.jogo.preco * aluguel.periodo.getDias() * 0.8
            else -> 0.0
        }
    }
}
