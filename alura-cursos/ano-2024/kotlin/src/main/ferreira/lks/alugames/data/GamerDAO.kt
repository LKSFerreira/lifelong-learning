package lks.alugames.data

import jakarta.persistence.EntityManager
import lks.alugames.entity.GamerEntity
import lks.alugames.models.Gamer
import lks.alugames.extensions.toDate
import lks.alugames.extensions.toEntity
import lks.alugames.extensions.toModel

class GamerDAO(private val entityManager: EntityManager) : DAO<Gamer, GamerEntity>(entityManager, GamerEntity::class.java) {

    override fun toEntity(model: Gamer): GamerEntity {
        return GamerEntity(
            model.id,
            model.nome,
            model.email,
            model.dataNascimento!!.toDate(),
            model.usuario,
            model.plano.toEntity()
        )
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return Gamer(
            entity.nome,
            entity.email,
            entity.dataNascimento.toString(),
            entity.usuario,
            entity.id
        ).apply { plano = entity.plano.toModel() }
    }


}