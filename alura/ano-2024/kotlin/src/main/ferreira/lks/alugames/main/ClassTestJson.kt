package lks.alugames.main

import com.google.gson.GsonBuilder
import lks.alugames.models.Periodo
import lks.alugames.models.PlanoAssinatura
import lks.alugames.services.ApiConsumer
import java.io.File
import java.time.LocalDate

fun main() {
    val apiConsumer = ApiConsumer()
    val gamers = apiConsumer.getAllGamers()
    val jogos = apiConsumer.getAllJogos()

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

    val gamerCamila = gamers[5]
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3, 15)

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

    gamerCamila.recomendar(7)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(9)

    gamerCamila.alugaJogo(
        theWitcher3,
        Periodo(LocalDate.now(), LocalDate.now().plusDays(10))
    )

    gamerCamila.recomendarJogo(jogoResidenteVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 9)
    gamerCamila.recomendarJogo(jogoSpider, 7)
    gamerCamila.recomendarJogo(theWitcher3, 10)


    gamerCaroline.recomendarJogo(jogoResidenteVillage, 7)
    gamerCaroline.recomendarJogo(jogoTheLastOfUs, 10)


    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val jogosSerializados = gson.toJson(gamerCamila.listaJogosRecomendados)
    println(jogosSerializados)

    val arquivo = File("JogosRecomendadosPor-${gamerCamila.nome}.json")
    arquivo.writeText(jogosSerializados)
    println("Arquivo salvo em ${arquivo.absolutePath}")


}