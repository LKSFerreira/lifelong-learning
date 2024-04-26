package lks.alugames.models

import lks.alugames.interfaces.Recomendavel
import lks.alugames.utils.format
import java.util.*
import kotlin.random.Random

data class Gamer(val nome: String, var email: String) : Recomendavel {
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                criaIdInterno()
            }
        }
    var id = 0
    var idInterno: String? = null
        private set

    var plano: Plano = PlanoAvulso("BRONZE")
    val listaJogos = mutableListOf<Jogo>()
    private val listaJogosAlugados = mutableListOf<Aluguel>()
    private val listaNotas = mutableListOf<Int>()
    val listaJogosRecomendados = mutableListOf<Jogo>()

    constructor(name: String, email: String, dataNascimento: String, usuario: String, id: Int = 0) :
            this(name, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        this.id = id
        criaIdInterno()
    }

//    init {
//        if (name.isBlank()) {
//            throw IllegalArgumentException("Nome não pode ser vazio")
//        }
//        this.email = validarEmail()
//    }

    private fun validarEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Email inválido")
        }
    }

    fun alugaJogo(jogo: Jogo, periodo: Periodo): Aluguel {
        val jogoAlugado = Aluguel(this, jogo, periodo)
        listaJogosAlugados.add(jogoAlugado)
        return jogoAlugado
    }

    fun getJogosDoMes(mes: Int): List<Jogo> {
        return listaJogosAlugados.filter {
            it.periodo.dataInicial.monthValue == mes
        }.map {
            it.jogo
        }
    }

    private fun criaIdInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$nome#$tag"
    }

    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        if (nota !in 1..10) {
            throw IllegalArgumentException("Nota inválida")
        }
        listaNotas.add(nota)
    }

    fun recomendarJogo(jogo: Jogo, nota: Int) {
        if (nota !in 1..10) {
            throw IllegalArgumentException("Nota inválida")
        }
        jogo.recomendar(nota)
        listaJogosRecomendados.add(jogo)
    }

    override fun toString(): String {
        return "Gamer(Nome: $nome, Email: $email, Data de Nascimento: $dataNascimento, " +
                "Usuário: $usuario, Id Interno: $idInterno, Plano: $plano, Média: ${media.format(2)})"
    }

    companion object {
        fun criarGamer(scanner: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = scanner.nextLine()
            println("Digite seu e-mail:")
            val email = scanner.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = scanner.nextLine()

            if (opcao.equals("s", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = scanner.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = scanner.nextLine()

                return Gamer(nome, email, nascimento, usuario)
            }

            return Gamer(nome, email)
        }
    }
}