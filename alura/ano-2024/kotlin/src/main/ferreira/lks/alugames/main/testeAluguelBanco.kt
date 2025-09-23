package lks.alugames.main

import lks.alugames.data.*
import lks.alugames.models.Periodo

fun main() {
    val entityManager = Database.getEntityManager()
    val gamerDAO = GamerDAO(entityManager)
    val jogoDAO = JogoDAO(entityManager)
    val aluguelDAO = AluguelDAO(entityManager)

    val jogo = jogoDAO.getById(1)
    val gamer = gamerDAO.getById(9)
    val aluguel = gamer?.alugaJogo(jogo!!, Periodo())

    aluguelDAO.create(aluguel!!)

    val listaAluguel = aluguelDAO.getAll()
    listaAluguel.forEach { println(it) }

}