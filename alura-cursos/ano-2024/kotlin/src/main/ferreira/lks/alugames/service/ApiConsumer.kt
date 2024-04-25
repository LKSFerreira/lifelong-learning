package lks.alugames.service

import com.google.gson.Gson
import lks.alugames.model.*
import lks.alugames.utils.toGamer
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ApiConsumer {
    fun getJogo(id: String): InfoJogo {
        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=$id")).build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()
        val gson = Gson()
        return gson.fromJson(json, InfoJogo::class.java)
    }

    fun getAllGamers(): List<Gamer> {
        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json")).build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        return Gson().fromJson(response.body(), Array<InfoGamerJson>::class.java).toList().map { infoGamerJson ->
            infoGamerJson.toGamer()
        }
    }

    fun getAllJogos(): List<Jogo> {
        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json")).build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        return Gson().fromJson(response.body(), Array<InfoJogoJson>::class.java).toList().map { infoJogoJson ->
            Jogo(infoJogoJson.titulo, infoJogoJson.capa, infoJogoJson.preco, infoJogoJson.descricao)
        }
    }
}