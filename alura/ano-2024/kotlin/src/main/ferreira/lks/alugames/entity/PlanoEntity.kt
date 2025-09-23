package lks.alugames.entity

import jakarta.persistence.*

@Entity
@Table(name = "planos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TipoPlano", discriminatorType = DiscriminatorType.STRING)
sealed class PlanoEntity(
    val tipo: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Int = 0
) {
    protected constructor() : this("", 0) // Construtor sem argumentos protegido
}

@Entity
@DiscriminatorValue("Avulso")
class PlanoAvulsoEntity(tipo: String = "Plano Avulso", id: Int = 0) : PlanoEntity(tipo, id)

@Entity
@DiscriminatorValue("Assinatura")
class PlanoAssinaturaEntity(
    tipo: String = "Plano Assinatura",
    val mensalidade: Double = 0.0,
    val totalJogosInclusos: Int = 0,
    val descontoEmPorcentagem: Int = 0,
    id: Int = 0
) : PlanoEntity(tipo, id)