package lks.alugames.extensions

import lks.alugames.entity.JogoEntity
import lks.alugames.models.Jogo

fun Jogo.toEntity(): JogoEntity {
    return JogoEntity(
        this.id,
        this.titulo,
        this.capa,
        this.preco.toDouble(),
        this.descricao,
    )
}

fun JogoEntity.toModel(): Jogo {
    return Jogo(
        this.id,
        this.titulo,
        this.capa,
        this.preco.toBigDecimal(),
        this.descricao,
    )
}