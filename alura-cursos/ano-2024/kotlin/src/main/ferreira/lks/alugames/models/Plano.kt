package lks.alugames.models

import java.math.BigDecimal

sealed class Plano(var tipo: String) {
    open fun getValorAluguel(aluguel: Aluguel): BigDecimal {
        return aluguel.jogo.preco * aluguel.periodo.getDias().toBigDecimal()
    }
}