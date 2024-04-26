package lks.alugames.model

import java.time.LocalDate

data class Periodo(val dataInicial: LocalDate, val dataFinal: LocalDate) {
    fun getDias(): Int {
        return java.time.Period.between(dataInicial, dataFinal).days
    }
}
