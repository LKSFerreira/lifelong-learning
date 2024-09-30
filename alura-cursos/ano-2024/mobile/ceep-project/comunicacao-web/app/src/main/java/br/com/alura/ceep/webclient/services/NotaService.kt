package br.com.alura.ceep.webclient.services

import br.com.alura.ceep.webclient.response.NotaResponse
import retrofit2.Call
import retrofit2.http.GET

interface NotaService {
    @GET("notas")
    fun buscaTodos(): Call<List<NotaResponse>>
}