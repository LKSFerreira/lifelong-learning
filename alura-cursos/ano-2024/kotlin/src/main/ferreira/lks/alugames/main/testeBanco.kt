package lks.alugames.main

import lks.alugames.data.Database
import lks.alugames.data.GamerDAO
import lks.alugames.data.JogoDAO
import lks.alugames.models.Jogo

fun main() {
    val entityManager = Database.getEntityManager()
    val jogo = Jogo("The Last of Us", "https://www.google.com", 100.0.toBigDecimal(), "Jogo de sobrevivência")

    var jogoCriado = JogoDAO(entityManager).create(jogo)
    println("Jogo criado: $jogoCriado")

    println("\nJogos com JPA")
    val listaJogosJPA = JogoDAO(entityManager).getAll()
    listaJogosJPA.forEach { println(it) }

    /*    val gamer = Gamer("Lucas", "lks@email.com", "1990-01-01", "lksferreira")
        println(gamer)*/

//    GamerJPA(entityManager).create(gamer)

    val listaGamers = GamerDAO(entityManager).getAll()
    listaGamers.forEach { println(it) }

    entityManager.close()
}