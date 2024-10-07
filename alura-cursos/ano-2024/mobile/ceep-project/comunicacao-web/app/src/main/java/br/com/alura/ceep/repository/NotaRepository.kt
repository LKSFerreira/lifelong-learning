package br.com.alura.ceep.repository

import br.com.alura.ceep.database.dao.NotaDao
import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.NotaWebClient
import kotlinx.coroutines.flow.Flow

class NotaRepository(
    private val dao: NotaDao,
    private val webClient: NotaWebClient
) {
    fun buscaTodas(): Flow<List<Nota>> {
        return dao.buscaTodas()
    }

    suspend fun atualizaTodas() {
        webClient.buscaNotas()?.let { notas ->
            dao.salva(notas)
        }
    }

    fun buscaPorId(it: String): Flow<Nota> {
        return dao.buscaPorId(it)
    }

    suspend fun remove(it: String) {
        dao.remove(it)
    }

    suspend fun salva(nota: Nota) {
        dao.salva(nota)
        webClient.salva(nota)
    }
}