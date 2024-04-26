package lks.alugames.models

import lks.alugames.models.Aluguel
import lks.alugames.models.Plano

class PlanoAvulso(tipo: String) : Plano(tipo) {

    override fun getValorAluguel(aluguel: Aluguel): Double {
        val valorOriginal = super.getValorAluguel(aluguel)
        /*if (aluguel.gamer.media > 8) {
            valorOriginal -= valorOriginal * 0.1
        }

        return valorOriginal*/

        return if (aluguel.gamer.media > 8) valorOriginal - valorOriginal * 0.1 else valorOriginal
    }
}
