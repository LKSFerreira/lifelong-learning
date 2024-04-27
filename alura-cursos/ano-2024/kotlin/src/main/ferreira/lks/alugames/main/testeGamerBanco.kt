package lks.alugames.main

import lks.alugames.data.Database
import lks.alugames.data.GamerDAO
import lks.alugames.data.PlanosDAO
import lks.alugames.models.Gamer

fun main() {
    val entityManager = Database.getEntityManager()
    val gamerDAO = GamerDAO(entityManager)

    val gamer = Gamer( "Ferreira", "ferreia@email.com", "1999-01-01", "ferreira")

    gamer.plano = PlanosDAO(entityManager).getById(1)!!

    gamerDAO.create(gamer)

    val listaGamers = gamerDAO.getAll()
    listaGamers.forEach { println(it) }

    entityManager.close()
}