package lks.alugames.extensions

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.*

fun String.getIdadeByDataNascimento(): Int {
    val formater = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val dataNascimento = LocalDate.parse(this, formater)
    return Period.between(dataNascimento, LocalDate.now()).years
}


fun String.toDate(): Date {
    val format = "yyyy-MM-dd"
    val formatter = SimpleDateFormat(format)
    return try {
        formatter.parse(this)
    } catch (e: Exception) {
        Date()
    }
}
