package br.com.alura.ceep.webclient.services

import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.response.NotaRequest
import br.com.alura.ceep.webclient.response.NotaResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface NotaService {
    @Deprecated("Utilize o método getAll")
    @GET("notas")
    fun buscaTodos(): Call<List<NotaResponse>>

    @GET("notas")
    suspend fun getAll(): List<NotaResponse>

    @PUT("notas/{id}")
    suspend fun salva(@Path("id") id: String, @Body nota: NotaRequest): Response<Nota>

    @DELETE("notas/{id}")
    suspend fun remove(@Path("id") id: String): Response<Void>
}