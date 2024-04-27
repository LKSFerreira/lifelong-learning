package lks.alugames.dto

import jakarta.persistence.*

@Entity
@Table(name = "planos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TipoPlano", discriminatorType = DiscriminatorType.STRING)
sealed class PlanoDTO( // Alterado de 'sealed' para 'abstract'
    val tipo: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Int = 0
) {
    protected constructor() : this("", 0) // Construtor sem argumentos protegido
}

@Entity
@DiscriminatorValue("Avulso")
class PlanoAvulsoDTO(tipo: String = "Plano Avulso", id: Int = 0) : PlanoDTO(tipo, id)

@Entity
@DiscriminatorValue("Assinatura")
class PlanoAssinaturaDTO(
    tipo: String = "Plano Assinatura",
    val mensalidade: Double = 0.0,
    val totalJogosInclusos: Int = 0,
    val descontoEmPorcentagem: Int = 0,
    id: Int = 0
) : PlanoDTO(tipo, id)