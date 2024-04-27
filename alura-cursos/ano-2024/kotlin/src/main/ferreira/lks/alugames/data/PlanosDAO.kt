package lks.alugames.data

import jakarta.persistence.EntityManager
import lks.alugames.dto.PlanoAssinaturaDTO
import lks.alugames.dto.PlanoAvulsoDTO
import lks.alugames.dto.PlanoDTO
import lks.alugames.models.Plano
import lks.alugames.models.PlanoAssinatura
import lks.alugames.models.PlanoAvulso
import lks.alugames.utils.toEntityDTO
import lks.alugames.utils.toModel

class PlanosDAO(entityManager: EntityManager) : DAO<Plano, PlanoDTO>(entityManager, PlanoDTO::class.java) {
    override fun toEntityDTO(plano: Plano): PlanoDTO {
        return plano.toEntityDTO()
    }

    override fun toModel(entityDTO: PlanoDTO): Plano {
        return entityDTO.toModel()
    }
}
