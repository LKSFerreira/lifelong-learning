package lks.alugames.models

import jakarta.persistence.Embeddable
import java.time.LocalDate

@Embeddable
data class Periodo(
    val dataInicial: LocalDate = LocalDate.now(),
    val dataFinal: LocalDate = LocalDate.now().plusDays(7)) {
    fun getDias(): Int {
        return java.time.Period.between(dataInicial, dataFinal).days
    }
}
