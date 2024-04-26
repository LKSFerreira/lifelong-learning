package lks.alugames.main

import lks.alugames.data.Database

fun main() {
    val conection = Database.getConnection()
    println(conection)
}