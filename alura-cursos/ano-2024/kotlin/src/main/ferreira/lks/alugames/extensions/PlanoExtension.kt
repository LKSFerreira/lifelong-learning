package lks.alugames.extensions

import lks.alugames.entity.PlanoEntity
import lks.alugames.models.Plano
import lks.alugames.models.PlanoAssinatura
import lks.alugames.models.PlanoAvulso

fun Plano.toEntity(): PlanoEntity {
    return when (this) {
        is PlanoAvulso -> lks.alugames.entity.PlanoAvulsoEntity(tipo, id)
        is PlanoAssinatura -> lks.alugames.entity.PlanoAssinaturaEntity(
            tipo,
            this.mensalidade,
            this.totalJogosInclusos,
            this.descontoEmPorcentagem,
            id
        )
    }
}

fun PlanoEntity.toModel(): Plano {
    return when (this) {
        is lks.alugames.entity.PlanoAvulsoEntity -> PlanoAvulso(this.tipo, this.id)
        is lks.alugames.entity.PlanoAssinaturaEntity -> PlanoAssinatura(
            this.tipo,
            this.mensalidade,
            this.totalJogosInclusos,
            this.descontoEmPorcentagem,
            this.id
        )
    }
}