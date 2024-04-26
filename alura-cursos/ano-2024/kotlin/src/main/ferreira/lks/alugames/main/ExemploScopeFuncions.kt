package lks.alugames.main

import lks.alugames.models.Gamer

fun main() {
    val gamer = Gamer("Lucas", "lks_ferreira@hotmail.com")
    println(gamer)

    val gamer2 = Gamer("Fulano", "fulano@email.com", "01/01/2000", "fulano")
    println(gamer2)

    // Usando scope functions
    gamer.let {
        it.dataNascimento = "27/04/1991"
        it.usuario = "lks"
    }.also {
        println("O idInterno é ${gamer.idInterno}")
    }

    println(gamer)

    val gamerExemplos = Gamer("Alex", "alex@example.com")

    // Exemplo de 'let'
    // Útil para executar um bloco de código que resulta em algo diferente do objeto original.
    val emailDomain = gamerExemplos.let {
        println(it) // Imprime o objeto Gamer
        it.email.substringAfter("@") // Retorna o domínio do email
    }

    println("Domínio do email: $emailDomain")

    // Exemplo de 'run'
    // Similar ao 'let', mas usado quando o foco está no objeto em si, e não no retorno.
    val userInfo = gamerExemplos.run {
        "O usuário $usuario tem o email $email" // Retorna esta String
    }
    println(userInfo)

    // Exemplo de 'with'
    // Útil para chamar múltiplos métodos em um objeto sem repetir o nome do objeto.
    val userData = with(gamerExemplos) {
        println("Criando dados do usuário")
        // Executa várias operações, a última linha é o retorno
        "Nome: $name, Email: $email"
    }
    println(userData)

    // Exemplo de 'apply'
    // Ótimo para configuração inicial de um objeto. Retorna o próprio objeto.
    val newGamer = Gamer("Chris", "chris@example.com").apply {
        dataNascimento = "01/01/1990"
        usuario = "chrisGamer"
    }
    println(newGamer)

    // Exemplo de 'also'
    // Similar ao 'apply', mas usado para operações adicionais que não modificam o objeto principal.
    // Retorna o próprio objeto original.
    gamerExemplos.also {
        println("Registrando acesso para o usuário: ${it.usuario}")
    }

}