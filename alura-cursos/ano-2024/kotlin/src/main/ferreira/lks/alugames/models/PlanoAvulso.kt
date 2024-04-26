package lks.alugames.models

import lks.alugames.models.Aluguel
import lks.alugames.models.Plano
import java.math.BigDecimal

class PlanoAvulso(
    tipo: String,
//    id: Int = 0
) : Plano(tipo) {

    override fun getValorAluguel(aluguel: Aluguel): BigDecimal {
        val valorOriginal = super.getValorAluguel(aluguel)
        return if (aluguel.gamer.media > 8) valorOriginal - valorOriginal * 0.1.toBigDecimal() else valorOriginal
    }

    override fun toString(): String {
        return "PlanoAvulso:\n" +
                "Tipo: $tipo\n" +
                "Id: $id"
    }


}
