package lks.alugames.utils

import lks.alugames.dto.PlanoAssinaturaDTO
import lks.alugames.dto.PlanoAvulsoDTO
import lks.alugames.dto.PlanoDTO
import lks.alugames.models.Plano
import lks.alugames.models.PlanoAssinatura
import lks.alugames.models.PlanoAvulso

fun Plano.toEntityDTO(): PlanoDTO {
    return when (this) {
        is PlanoAvulso -> PlanoAvulsoDTO(this.tipo, this.id)
        is PlanoAssinatura -> PlanoAssinaturaDTO(this.tipo, this.mensalidade, this.totalJogosInclusos, this.descontoEmPorcentagem, this.id)
        else -> throw IllegalArgumentException("Plano inválido")
    }
}

fun PlanoDTO.toModel(): Plano {
    return when (this) {
        is PlanoAvulsoDTO -> PlanoAvulso(this.tipo, this.id)
        is PlanoAssinaturaDTO -> PlanoAssinatura(this.tipo, this.mensalidade, this.totalJogosInclusos, this.descontoEmPorcentagem, this.id)
        else -> throw IllegalArgumentException("Plano inválido")
    }
}