package br.com.alura.ceep.webclient

import android.util.Log
import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.response.NotaRequest

private const val TAG = "NotaWebClient"

class NotaWebClient {

    private val notaService = RetrofitInicializador().notaService

    suspend fun buscaNotas(): List<Nota>? {
        return try {
            val listaNotasResponse = notaService.getAll()
            return listaNotasResponse.map {
                it.nota
            }
        } catch (e: Exception) {
            Log.e(TAG, "Mensagem do erro: ${e.message}", e)
            null
        }
    }

    suspend fun salva(nota: Nota): Boolean {
        try {
            val resposta = notaService.salva(nota.id, NotaRequest(nota.titulo, nota.descricao, nota.imagem))
            val mensagem = if (resposta.isSuccessful) {
                "Nota salva com sucesso"
            } else {
                "Falha ao tentar salvar a nota"
            }
            Log.i(TAG, mensagem)
            return resposta.isSuccessful
        } catch (e: Exception) {
            Log.e(TAG, "Falho ao tentar salvar: ${e.message}", e)
        }
        return false
    }
}
