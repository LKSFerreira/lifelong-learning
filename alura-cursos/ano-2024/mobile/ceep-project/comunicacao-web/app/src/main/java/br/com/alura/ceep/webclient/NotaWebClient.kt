package br.com.alura.ceep.webclient

import android.util.Log
import br.com.alura.ceep.model.Nota

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
}
