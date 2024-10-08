package br.com.alura.ceep.repository

import br.com.alura.ceep.database.dao.NotaDao
import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.NotaWebClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class NotaRepository(
    private val dao: NotaDao,
    private val webClient: NotaWebClient
) {
    fun buscaTodas(): Flow<List<Nota>> {
        return dao.buscaTodas()
    }

    private suspend fun atualizaTodas() {
        webClient.buscaNotas()?.let { notas ->
            val notasSincronizadas = notas.map {
                it.copy(sincronizada = true)
            }
            dao.salva(notasSincronizadas)
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
        if (webClient.salva(nota)) {
            nota.copy(sincronizada = true).let {
                dao.salva(it)
            }
        }
    }

    suspend fun sincroniza() {
        dao.buscaNaoSincronizadas().first().let { notasNaoSincronizadas ->
            notasNaoSincronizadas.forEach {
                salva(it)
            }
        }
        atualizaTodas()
    }
}

