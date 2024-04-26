package lks.alugames.models

import com.google.gson.annotations.Expose
import lks.alugames.interfaces.Recomendavel
import lks.alugames.utils.format
import java.math.BigDecimal

data class Jogo(@Expose val titulo: String, @Expose val capa: String) : Recomendavel {
    var descricao: String = ""
    var preco: BigDecimal = BigDecimal.ZERO
    var id = 0

    private val listaNotas = mutableListOf<Int>()

    constructor(titulo: String, capa: String, preco: BigDecimal, descricao: String, id: Int) : this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
        this.id = id
    }

    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        if (nota !in 1..10) {
            throw IllegalArgumentException("Nota inválida")
        }
        listaNotas.add(nota)
    }

    override fun toString(): String {
        return "Titulo: $titulo, Capa: $capa, Preço: ${preco.format(2)}, Descricao: $descricao"
    }
}