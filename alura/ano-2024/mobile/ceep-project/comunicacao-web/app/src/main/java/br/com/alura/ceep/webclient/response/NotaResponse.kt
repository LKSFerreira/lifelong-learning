package br.com.alura.ceep.webclient.response

import br.com.alura.ceep.model.Nota
import java.util.UUID

class NotaResponse(
    private val id: String?,
    private val titulo: String?,
    private val descricao: String?,
    private val imagem: String?
) {
    val nota: Nota
        get() = Nota(
            id = id ?: UUID.randomUUID().toString(),
            titulo = titulo ?: "",
            descricao = descricao ?: "",
            imagem = imagem ?: ""
        )
}