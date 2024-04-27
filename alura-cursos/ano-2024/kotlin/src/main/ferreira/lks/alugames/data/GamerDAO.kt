package lks.alugames.data

import jakarta.persistence.EntityManager
import lks.alugames.dto.GamerDTO
import lks.alugames.models.Gamer
import lks.alugames.utils.toDate
import lks.alugames.utils.toEntityDTO
import lks.alugames.utils.toModel

class GamerDAO(private val entityManager: EntityManager) : DAO<Gamer, GamerDTO>(entityManager, GamerDTO::class.java) {

    override fun toEntityDTO(gamer: Gamer): GamerDTO {
        return GamerDTO(
            gamer.id,
            gamer.nome,
            gamer.email,
            gamer.dataNascimento!!.toDate(),
            gamer.usuario,
            gamer.plano.toEntityDTO()
        )
    }

    override fun toModel(entityDTO: GamerDTO): Gamer {
        return Gamer(
            entityDTO.nome,
            entityDTO.email,
            entityDTO.dataNascimento.toString(),
            entityDTO.usuario,
            entityDTO.id
        ).apply { plano = entityDTO.plano.toModel() }
    }


}