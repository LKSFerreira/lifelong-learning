package lks.alugames.data

import jakarta.persistence.EntityManager
import lks.alugames.dto.JogoDTO
import lks.alugames.models.Jogo

class JogoDAO(private val entityManager: EntityManager) : DAO<Jogo, JogoDTO>(entityManager, JogoDTO::class.java) {

    override fun toEntityDTO(model: Jogo): JogoDTO {
        return JogoDTO(model.id, model.titulo, model.capa, model.preco.toDouble(), model.descricao)
    }

    override fun toModel(entityDTO: JogoDTO): Jogo {
        return Jogo(entityDTO.id, entityDTO.titulo, entityDTO.capa, entityDTO.preco.toBigDecimal(), entityDTO.descricao)
    }
}