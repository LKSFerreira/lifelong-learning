package br.com.alura.ceep.webclient

import br.com.alura.ceep.webclient.services.NotaService
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInicializador {

//    private val logging = HttpLoggingInterceptor().apply {
//        level = HttpLoggingInterceptor.Level.BODY
//    }
//
//    private val client = okhttp3.OkHttpClient.Builder()
//        .addInterceptor(logging)
//        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.15.157:8080/")
        //.client(client)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val notaService: NotaService = retrofit.create(NotaService::class.java)

}