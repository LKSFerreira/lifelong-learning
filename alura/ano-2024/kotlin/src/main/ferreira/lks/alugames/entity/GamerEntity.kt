package lks.alugames.entity

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "gamers")
open class GamerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 1,
    val nome: String = "Nome do Gamer",
    val email: String = "Email do Gamer",
    val dataNascimento: Date = Date(),
    val usuario: String = "Usuário do Gamer",
    @ManyToOne
    val plano: PlanoEntity = PlanoAvulsoEntity()
)