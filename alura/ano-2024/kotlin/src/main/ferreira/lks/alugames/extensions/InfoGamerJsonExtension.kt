package lks.alugames.extensions

import lks.alugames.models.Gamer
import lks.alugames.dto.InfoGamerJson

fun InfoGamerJson.toGamer(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}