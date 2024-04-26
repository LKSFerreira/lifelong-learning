package lks.alugames.utils

import lks.alugames.models.InfoJogo
import lks.alugames.models.Jogo

fun InfoJogo.toJogo(): Jogo {
    return Jogo(
        this.info.title,
        this.info.thumb,
    )
}