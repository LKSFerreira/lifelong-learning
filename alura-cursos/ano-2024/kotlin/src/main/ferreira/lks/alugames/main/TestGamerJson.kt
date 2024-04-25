package lks.alugames.main

import lks.alugames.service.ApiConsumer

fun main() {
    val apiConsumer = ApiConsumer()

    val gamers = apiConsumer.getAllGamers()
    gamers.forEach {
        println(it)
    }

    println("=====================================")

    val jogos = apiConsumer.getAllJogos()
    jogos.forEach {
        println(it)
    }

    println("=====================================")
    val jogo = apiConsumer.getJogo("323")
    println(jogo)
}