package lks.alugames.model

import lks.alugames.model.InfoApiShark

data class InfoJogo(val info: InfoApiShark) {
    override fun toString(): String {
        return info.toString()
    }
}