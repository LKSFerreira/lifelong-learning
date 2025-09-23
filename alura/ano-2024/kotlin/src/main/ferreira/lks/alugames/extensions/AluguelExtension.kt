package lks.alugames.extensions

import lks.alugames.entity.AluguelEntity
import lks.alugames.models.Aluguel

fun Aluguel.toEntity(): AluguelEntity {
    return AluguelEntity(
        this.gamer.toEntity(),
        this.jogo.toEntity(),
        this.periodo
    )
}

fun AluguelEntity.toModel(): Aluguel {
    return Aluguel(
        this.gamer.toModel(),
        this.jogo.toModel(),
        this.periodo,
    )
}