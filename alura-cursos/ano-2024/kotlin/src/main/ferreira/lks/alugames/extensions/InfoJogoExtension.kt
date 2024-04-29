package lks.alugames.extensions

import lks.alugames.dto.InfoJogo
import lks.alugames.models.Jogo

fun InfoJogo.toJogo(): Jogo {
    return Jogo(
        this.info.title,
        this.info.thumb,
    )
}