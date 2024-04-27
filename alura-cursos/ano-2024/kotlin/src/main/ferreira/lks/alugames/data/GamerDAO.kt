package lks.alugames.data

import jakarta.persistence.EntityManager
import lks.alugames.dto.GamerDTO
import lks.alugames.models.Gamer
import lks.alugames.utils.toDate

class GamerDAO(private val entityManager: EntityManager) : DAO<Gamer, GamerDTO>(entityManager, GamerDTO::class.java) {

    override fun toEntityDTO(model: Gamer): GamerDTO {
        return model.usuario?.let { GamerDTO(model.id, model.nome, model.email, model.dataNascimento!!.toDate(), it) }!!
    }

    override fun toModel(entityDTO: GamerDTO): Gamer {
        return Gamer(
            entityDTO.nome,
            entityDTO.email,
            entityDTO.dataNascimento.toString(),
            entityDTO.usuario,
            entityDTO.id
        )
    }


}