package lks.alugames.extensions

import lks.alugames.entity.GamerEntity
import lks.alugames.models.Gamer

fun Gamer.toEntity(): GamerEntity {
    return GamerEntity(
        this.id,
        this.nome,
        this.email,
        this.dataNascimento!!.toDate(),
        this.usuario,
        this.plano.toEntity()
    )
}

fun GamerEntity.toModel(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento.toString(),
        this.usuario,
        this.id
    ).apply { plano = this.plano }
}