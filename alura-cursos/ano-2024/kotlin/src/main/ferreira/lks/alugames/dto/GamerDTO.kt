package lks.alugames.dto

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "gamers")
open class GamerDTO(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val nome: String = "Nome do Gamer",
    val email: String = "Email do Gamer",
    val dataNascimento: Date = Date(),
    val usuario: String = "Usuário do Gamer"
)