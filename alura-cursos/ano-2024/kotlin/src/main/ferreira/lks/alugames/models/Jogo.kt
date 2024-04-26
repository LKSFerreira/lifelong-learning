package lks.alugames.models

import lks.alugames.interfaces.Recomendavel

data class Jogo(val titulo: String, val capa: String) : Recomendavel {
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
        if (nota in 1..10) {
            listaNotas.add(nota)
        } else {
            throw IllegalArgumentException("Nota inválida")
        }
    }

    override fun toString(): String {
        return "titulo: $titulo, capa: $capa, preço: $preco, descricao: $descricao"
    }
}