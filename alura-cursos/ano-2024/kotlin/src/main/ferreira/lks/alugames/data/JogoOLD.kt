package lks.alugames.data

import lks.alugames.entity.JogoEntity
import lks.alugames.models.Jogo

object JogoOLD {
    fun getAll(): List<JogoEntity> {
        val listaJogos = mutableListOf<JogoEntity>()

        Database.getConnection()?.use { connection ->
            val statement = connection.createStatement()
            val resultSet = statement.executeQuery("SELECT * FROM jogos")
            while (resultSet.next()) {
                val jogoDTO = JogoEntity(
                    resultSet.getInt("id"),
                    resultSet.getString("titulo"),
                    resultSet.getString("capa"),
                    resultSet.getDouble("preco"),
                    resultSet.getString("descricao")
                )
                listaJogos.add(jogoDTO)
            }
        }
        return listaJogos
    }

    fun getById(id: Int): JogoEntity? {
        var jogoDTO: JogoEntity? = null

        Database.getConnection()?.use { connection ->
            val statement = connection.prepareStatement("SELECT * FROM jogos WHERE id = ?")
            statement.setInt(1, id)
            val resultSet = statement.executeQuery()
            if (resultSet.next()) {
                jogoDTO = JogoEntity(
                    resultSet.getInt("id"),
                    resultSet.getString("titulo"),
                    resultSet.getString("capa"),
                    resultSet.getDouble("preco"),
                    resultSet.getString("descricao")
                )
            }
        }
        return jogoDTO
    }

    fun create(jogo: Jogo): Boolean {
        var result = false

        Database.getConnection()?.use { connection ->
            val statement =
                connection.prepareStatement("INSERT INTO jogos (titulo, capa, preco, descricao) VALUES (?, ?, ?, ?)")
            statement.setString(1, jogo.titulo)
            statement.setString(2, jogo.capa)
            statement.setBigDecimal(3, jogo.preco)
            statement.setString(4, jogo.descricao)
            result = statement.executeUpdate() == 1
        }
        return result
    }
}