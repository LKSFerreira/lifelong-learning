package lks.alugames.data

import lks.alugames.models.Jogo

class JogoJPA {
    fun getAll(): List<Jogo> {
        val em = Database.getEntityManager()
        val query = em.createQuery("SELECT j FROM Jogo j", Jogo::class.java)
        return query.resultList
    }
}