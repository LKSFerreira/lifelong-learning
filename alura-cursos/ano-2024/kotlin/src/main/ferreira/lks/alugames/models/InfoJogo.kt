package lks.alugames.models

import lks.alugames.models.InfoApiShark

data class InfoJogo(val info: InfoApiShark) {
    override fun toString(): String {
        return info.toString()
    }
}