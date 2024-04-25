package lks.alugames.utils

import lks.alugames.model.InfoJogo
import lks.alugames.model.Jogo

fun InfoJogo.toJogo(): Jogo {
    return Jogo(
        this.info.title,
        this.info.thumb,
    )
}