package lks.alugames.utils

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.getIdadeByDataNascimento(): Int {
    val formater = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val dataNascimento = LocalDate.parse(this, formater)
    return Period.between(dataNascimento, LocalDate.now()).years
}