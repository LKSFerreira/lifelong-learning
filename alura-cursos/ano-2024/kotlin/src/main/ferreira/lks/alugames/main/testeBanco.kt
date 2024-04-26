package lks.alugames.main

import lks.alugames.data.JogoDAO
import lks.alugames.models.Jogo

fun main() {
    val jogo = Jogo("The Last of Us", "https://www.google.com", 100.0.toBigDecimal(), "Jogo de sobrevivência", 1)
//    JogoDAO.create(jogo)

    val listaJogos = JogoDAO.getAll()
    listaJogos.forEach { println(it) }
}