package lks.alugames.main

import lks.alugames.data.Database
import lks.alugames.data.PlanosDAO
import lks.alugames.models.PlanoAssinatura
import lks.alugames.models.PlanoAvulso

fun main() {
    val planoAvulso = PlanoAvulso("BRONZE")
    val planoPrata = PlanoAssinatura("PRATA", 9.90, 3, 15)
    val planoOuro = PlanoAssinatura("OURO", 19.90, 5, 20)
    val planoPlatina = PlanoAssinatura("PLATINA", 29.90, 7, 30)
    val planoDiamante = PlanoAssinatura("DIAMANTE", 39.90, 10, 50)

    val entityManager = Database.getEntityManager()
    val planosDAO = PlanosDAO(entityManager)

    planosDAO.create(planoAvulso)
    planosDAO.create(planoPrata)
    planosDAO.create(planoOuro)
    planosDAO.create(planoPlatina)
    planosDAO.create(planoDiamante)

    val listaPlanos = planosDAO.getAll()
    listaPlanos.forEach { println(it) }

    entityManager.close()
}