package lks.alugames.model

import java.util.*
import kotlin.random.Random

data class Gamer(val name: String, var email: String) {
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                criaIdInterno()
            }
        }

    var idInterno: String? = null
        private set

    var plano: PlanoAvulso = PlanoAvulso("BRONZE")
    val jogos = mutableListOf<Jogo>()
    val jogosAlugados = mutableListOf<Aluguel>()


    constructor(name: String, email: String, dataNascimento: String, usuario: String) :
            this(name, email) {
        this.usuario = usuario
        this.dataNascimento = dataNascimento
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
        jogosAlugados.add(jogoAlugado)
        return jogoAlugado
    }

    private fun criaIdInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$name#$tag"
    }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
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