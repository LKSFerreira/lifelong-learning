package lks.alugames.data

import jakarta.persistence.EntityManager
import lks.alugames.dto.PlanoAssinaturaDTO
import lks.alugames.dto.PlanoAvulsoDTO
import lks.alugames.dto.PlanoDTO
import lks.alugames.models.Plano
import lks.alugames.models.PlanoAssinatura
import lks.alugames.models.PlanoAvulso

class PlanosDAO(entityManager: EntityManager) : DAO<Plano, PlanoDTO>(entityManager, PlanoDTO::class.java) {
    override fun toEntityDTO(plano: Plano): PlanoDTO {
        return if (plano is PlanoAssinatura) {
            PlanoAssinaturaDTO(
                plano.tipo,
                plano.mensalidade,
                plano.totalJogosInclusos,
                plano.descontoEmPorcentagem,
                plano.id
            )
        } else {
            PlanoAvulsoDTO(plano.tipo, plano.id)
        }
    }

    override fun toModel(entityDTO: PlanoDTO): Plano {
        return if (entityDTO is PlanoAssinaturaDTO) {
            PlanoAssinatura(
                entityDTO.tipo,
                entityDTO.mensalidade,
                entityDTO.totalJogosInclusos,
                entityDTO.descontoEmPorcentagem,
                entityDTO.id
            )
        } else {
            PlanoAvulso(entityDTO.tipo, entityDTO.id)
        }
    }
}
