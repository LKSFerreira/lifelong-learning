package br.com.alura.ceep.webclient

import br.com.alura.ceep.webclient.services.NotaService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInicializador {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.100.5:8080/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val notaService: NotaService = retrofit.create(NotaService::class.java)

}