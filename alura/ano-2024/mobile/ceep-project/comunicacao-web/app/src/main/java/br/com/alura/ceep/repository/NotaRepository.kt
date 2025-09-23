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

    fun buscaPorId(id: String): Flow<Nota> {
        return dao.buscaPorId(id)
    }

    suspend fun remove(id: String) {
        dao.desativa(id)
        if (webClient.remove(id)) {
            dao.remove(id)
        }
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
        dao.buscaDesativadas().first().let { notasDesativadas ->
            notasDesativadas.forEach {
                dao.remove(it.id)
                webClient.remove(it.id)
            }
        }

        dao.buscaNaoSincronizadas().first().let { notasNaoSincronizadas ->
            notasNaoSincronizadas.forEach {
                salva(it)
            }
        }
        atualizaTodas()
    }
}

