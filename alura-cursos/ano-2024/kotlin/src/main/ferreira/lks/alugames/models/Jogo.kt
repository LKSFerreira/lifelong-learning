package lks.alugames.models

import com.google.gson.annotations.Expose
import lks.alugames.interfaces.Recomendavel
import lks.alugames.utils.format

data class Jogo(@Expose val titulo: String, @Expose val capa: String) : Recomendavel {
    var preco: Double = 0.0
    var descricao: String = ""

    private val listaNotas = mutableListOf<Int>()

    constructor(titulo: String, capa: String, preco: Double, descricao: String) : this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
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
        return "titulo: $titulo, capa: $capa, preço: ${preco.format(2)}, descricao: $descricao"
    }
}