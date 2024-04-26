package lks.alugames.models

import java.math.BigDecimal

sealed class Plano(val tipo: String, var id: Int = 0) {
    open fun getValorAluguel(aluguel: Aluguel): BigDecimal {
        return aluguel.jogo.preco * aluguel.periodo.getDias().toBigDecimal()
    }
}