package lks.alugames.utils

import lks.alugames.model.Gamer
import lks.alugames.model.InfoGamerJson

fun InfoGamerJson.toGamer(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}