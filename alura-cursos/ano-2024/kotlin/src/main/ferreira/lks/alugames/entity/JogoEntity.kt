package lks.alugames.entity

import jakarta.persistence.*

@Entity
@Table(name = "jogos")
open class JogoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val titulo: String = "Título do Jogo",
    val capa: String = "Capa do Jogo",
    val preco: Double = 0.0,
    val descricao: String = "Descrição do Jogo"
)