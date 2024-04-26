package lks.alugames.utils

import java.math.BigDecimal

fun Double.format(digits: Int) = "%.${digits}f".format(this)

fun BigDecimal.format(digits: Int) = "%.${digits}f".format(this)