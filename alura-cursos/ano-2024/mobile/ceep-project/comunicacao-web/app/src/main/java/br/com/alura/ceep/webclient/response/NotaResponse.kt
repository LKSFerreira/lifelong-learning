package br.com.alura.ceep.webclient.response

import br.com.alura.ceep.model.Nota

class NotaResponse(
    private val id: String?,
    private val titulo: String?,
    private val descricao: String?,
    private val imagem: String?
) {
    val nota: Nota
        get() = Nota(
            id = 0,
            titulo = titulo ?: "",
            descricao = descricao ?: "",
            imagem = imagem ?: ""
        )
}