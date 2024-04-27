package lks.alugames.data

import jakarta.persistence.EntityManager
import lks.alugames.dto.JogoDTO
import lks.alugames.models.Jogo

class JogoDAO(private val entityManager: EntityManager) : DAO<Jogo, JogoDTO>(entityManager, JogoDTO::class.java) {

    override fun toEntityDTO(jogo: Jogo): JogoDTO {
        return JogoDTO(jogo.id, jogo.titulo, jogo.capa, jogo.preco.toDouble(), jogo.descricao)
    }

    override fun toModel(entityDTO: JogoDTO): Jogo {
        return Jogo(entityDTO.id, entityDTO.titulo, entityDTO.capa, entityDTO.preco.toBigDecimal(), entityDTO.descricao)
    }
}