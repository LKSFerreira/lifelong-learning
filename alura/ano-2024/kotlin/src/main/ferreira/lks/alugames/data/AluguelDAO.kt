package lks.alugames.data

import jakarta.persistence.EntityManager
import lks.alugames.entity.AluguelEntity
import lks.alugames.extensions.toEntity
import lks.alugames.extensions.toModel
import lks.alugames.models.Aluguel

class AluguelDAO(private val entityManager: EntityManager) :
    DAO<Aluguel, AluguelEntity>(entityManager, AluguelEntity::class.java) {

    override fun toEntity(model: Aluguel): AluguelEntity {
        return AluguelEntity(
            model.gamer.toEntity(),
            model.jogo.toEntity(),
            model.periodo
        ).apply {
            valorAluguel = model.valorDoAluguel.toDouble()
            id = model.id
        }
    }

    override fun toModel(entity: AluguelEntity): Aluguel {
        return Aluguel(
            entity.gamer.toModel(),
            entity.jogo.toModel(),
            entity.periodo
        ).apply {
            id = entity.id
        }
    }
}