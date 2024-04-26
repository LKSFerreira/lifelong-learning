package lks.alugames.main

import lks.alugames.model.Periodo
import lks.alugames.model.PlanoAssinatura
import lks.alugames.service.ApiConsumer
import java.time.LocalDate

fun main() {
    val apiConsumer = ApiConsumer()

    val gamers = apiConsumer.getAllGamers()
    /*        gamers.forEach {
                println(it)
            }*/


    val jogos = apiConsumer.getAllJogos()
    /*        jogos.forEach {
                println(it)
            }*/


    /*        val jogo = apiConsumer.getJogo("323")
            println(jogo)*/


    val gamerCaroline = gamers[3]
    gamerCaroline.plano.tipo = "BRONZE"

    val jogoResidenteVillage = jogos[10]
    val jogoSpider = jogos[13]
    val jogoTheLastOfUs = jogos[12]
    val theWitcher3 = jogos[0]

    gamerCaroline.alugaJogo(
        jogoResidenteVillage,
        Periodo(LocalDate.now(), LocalDate.now().plusDays(2))
    )

    gamerCaroline.alugaJogo(
        jogoSpider,
        Periodo(LocalDate.now(), LocalDate.now().plusDays(10))
    )

    gamerCaroline.alugaJogo(
        jogoTheLastOfUs,
        Periodo(LocalDate.now(), LocalDate.now().plusDays(100))
    )

    gamerCaroline.jogosAlugados.forEach {
        println(it)
    }

    println("=====================================")

    val gamerCamila = gamers[5]
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3)

    gamerCamila.alugaJogo(
        jogoResidenteVillage,
        Periodo(LocalDate.now(), LocalDate.now().plusDays(2))
    )

    gamerCamila.alugaJogo(
        jogoSpider,
        Periodo(LocalDate.now(), LocalDate.now().plusDays(10))
    )

    gamerCamila.alugaJogo(
        jogoTheLastOfUs,
        Periodo(LocalDate.now(), LocalDate.now().plusDays(10))
    )

    gamerCamila.alugaJogo(
        theWitcher3,
        Periodo(LocalDate.now(), LocalDate.now().plusDays(10))
    )

    gamerCamila.jogosAlugados.forEach {
        println(it)
    }
}