package lks.alugames.data

import jakarta.persistence.EntityManager
import lks.alugames.entity.JogoEntity
import lks.alugames.models.Jogo

class JogoDAO(private val entityManager: EntityManager) : DAO<Jogo, JogoEntity>(entityManager, JogoEntity::class.java) {

    override fun toEntity(model: Jogo): JogoEntity {
        return JogoEntity(model.id, model.titulo, model.capa, model.preco.toDouble(), model.descricao)
    }

    override fun toModel(entity: JogoEntity): Jogo {
        return Jogo(entity.id, entity.titulo, entity.capa, entity.preco.toBigDecimal(), entity.descricao)
    }
}