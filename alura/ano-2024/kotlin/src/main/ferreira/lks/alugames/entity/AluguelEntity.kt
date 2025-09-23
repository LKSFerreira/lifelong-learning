package lks.alugames.entity

import jakarta.persistence.*
import lks.alugames.models.Periodo

@Entity
@Table(name = "aluguel")
class AluguelEntity(
    @ManyToOne
    val gamer: GamerEntity = GamerEntity(),
    @ManyToOne
    val jogo: JogoEntity = JogoEntity(),
    @Embedded
    val periodo: Periodo = Periodo()
) {
    var valorAluguel = 0.0

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0
}
