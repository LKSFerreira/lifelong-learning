package lks.alugames.models

import java.math.BigDecimal

class PlanoAvulso(
    tipo: String,
    id: Int = 0
) : Plano(tipo,id) {

    override fun getValorAluguel(aluguel: Aluguel): BigDecimal {
        val valorOriginal = super.getValorAluguel(aluguel)
        return if (aluguel.gamer.media > 8) valorOriginal - valorOriginal * 0.1.toBigDecimal() else valorOriginal
    }

    override fun toString(): String {
        return "=== PlanoAvulso ===\n" +
                "Tipo: $tipo - Id do Plano: $id"
    }


}
