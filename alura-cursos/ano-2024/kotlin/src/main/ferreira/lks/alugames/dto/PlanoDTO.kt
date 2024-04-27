package lks.alugames.dto

sealed class PlanoDTO(val tipo: String)

class PlanoAvulsoDTO(tipo: String) : PlanoDTO(tipo)

class PlanoAssinaturaDTO(tipo: String, val valor: Double, val totalJogos: Int, val descontoEmPorcentagem: Double) : PlanoDTO(tipo)