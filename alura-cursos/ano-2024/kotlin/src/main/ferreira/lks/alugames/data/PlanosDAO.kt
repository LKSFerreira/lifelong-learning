package lks.alugames.data

import jakarta.persistence.EntityManager
import lks.alugames.entity.PlanoEntity
import lks.alugames.extensions.toEntity
import lks.alugames.extensions.toModel
import lks.alugames.models.Plano

class PlanosDAO(entityManager: EntityManager) : DAO<Plano, PlanoEntity>(entityManager, PlanoEntity::class.java) {
    override fun toEntity(model: Plano): PlanoEntity {
        return model.toEntity()
    }

    override fun toModel(entity: PlanoEntity): Plano {
        return entity.toModel()
    }
}
