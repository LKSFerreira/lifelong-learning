package lks.alugames.main

import lks.alugames.model.Gamer
import lks.alugames.model.Jogo
import lks.alugames.service.ApiConsumer
import lks.alugames.utils.getIdadeByDataNascimento
import java.util.*

fun main() {
    val api = ApiConsumer()
    val scanner = Scanner(System.`in`)

    val gamer = Gamer.criarGamer(scanner)
    println("Cadastro realizado com sucesso!")
    println(gamer)
    println("Idade do Gamer: ${gamer.dataNascimento?.getIdadeByDataNascimento()} anos")

    println("=====================================")
    do {
        println("Digite o id do jogo: ")
        val idJogo = scanner.nextLine()


        /*
        val resposta = runCatching {
            val gson = Gson()
            val infoJogo = gson.fromJson(json, InfoJogo::class.java)
            println(infoJogo)
            val jogo = Jogo(infoJogo.info.title, infoJogo.info.thumb)
            println(jogo)
        }

        resposta.onFailure {
            println("Erro ao converter json para InfoJogo")
        }

        resposta.onSuccess {
            println("Sucesso")
        }

         */

        var jogo: Jogo? = null

        runCatching {
            val infoJogo = api.getJogo(idJogo)
            jogo = Jogo(infoJogo.info.title, infoJogo.info.thumb)
        }.onFailure {
            println("Jogo inexiste, por gentileza tente outro id")
        }.onSuccess {
            println("Deseja inserir uma descrição para o jogo? (s/n)")

            if (scanner.nextLine().equals("s", true)) {
                println("Digite a descrição: ")
                val descricaoPersonalizada = scanner.nextLine()

                jogo?.descricao = descricaoPersonalizada
            } else {
                jogo!!.descricao = jogo!!.titulo
            }
        }
        println(jogo)
        gamer.jogos.add(jogo!!)
        println("Deseja buscar outro jogo? (s/n)")
    } while (scanner.nextLine().equals("s", true))

    // Ordenando os jogos por título
    gamer.jogos.sortedBy { it.titulo }.forEach(::println)

    println("Jogos do gamer:")
    gamer.jogos.forEach {
        println("Título: ${it.titulo}")
    }

    println("=====================================")

    println("Filtro apenas com jogos que possuem batman no título")
    gamer.jogos.filter { it.titulo.contains("batman", true) }.forEach(::println)

    println("=====================================")
    println("Deseja excluír algum jogo? (s/n)")

    if (scanner.nextLine().equals("s", true)) {
        println(gamer.jogos)

        println("Digite index do jogo: ")
        val idJogo = scanner.nextInt()
        gamer.jogos.removeAt(idJogo)
        println("Jogo excluído com sucesso!")

    }
    scanner.close()
}
