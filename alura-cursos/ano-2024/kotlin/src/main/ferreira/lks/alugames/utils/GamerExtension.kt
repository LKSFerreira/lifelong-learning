package lks.alugames.utils

import lks.alugames.models.Gamer
import lks.alugames.models.InfoGamerJson

fun InfoGamerJson.toGamer(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}