package br.com.alura.ceep.webclient.response

class NotaRequest(
    val titulo: String,
    val descricao: String,
    val imagem: String? = null
) {}