package lks.alugames.data


import jakarta.persistence.EntityManager
import lks.alugames.dto.JogoDTO
import lks.alugames.models.Jogo

class JogoJPA(private val em: EntityManager) {
    fun getAll(): List<Jogo> {
        val query = em.createQuery("FROM JogoDTO", JogoDTO::class.java)
        return query.resultList.map { Jogo(it.titulo, it.capa, it.preco.toBigDecimal(), it.descricao, it.id) }
    }

    fun create(jogo: Jogo): Boolean {
        val jogoDTO = JogoDTO(jogo.id, jogo.titulo, jogo.capa, jogo.preco.toDouble(), jogo.descricao)
        return try {
            em.transaction.begin()
            em.persist(jogoDTO)
            em.transaction.commit()
            true
        } catch (e: Exception) {
            em.transaction.rollback()
            false
        }
    }
}