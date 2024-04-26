package lks.alugames.services

import com.google.gson.Gson
import lks.alugames.models.*
import lks.alugames.utils.toGamer
import lks.alugames.utils.toJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ApiConsumer {

    private fun getEndpointApi(endpoint: String): HttpResponse<String> {
        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endpoint)).build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        return response
    }

    fun getJogo(id: String): Jogo {
        val response = getEndpointApi("https://www.cheapshark.com/api/1.0/games?id=$id")
        return Gson().fromJson(response.body(), InfoJogo::class.java).toJogo()
    }

    fun getAllGamers(): List<Gamer> {
        val response = getEndpointApi("https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json")
        return Gson().fromJson(response.body(), Array<InfoGamerJson>::class.java).toList().map { infoGamerJson ->
            infoGamerJson.toGamer()
        }
    }

    fun getAllJogos(): List<Jogo> {
        val response = getEndpointApi("https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json")
        return Gson().fromJson(response.body(), Array<InfoJogoJson>::class.java).toList().map { infoJogoJson ->
            Jogo(infoJogoJson.titulo, infoJogoJson.capa, infoJogoJson.preco, infoJogoJson.descricao)
        }
    }
}