package lks.alugames.data

import lks.alugames.models.Jogo

object JogoDAO {
    fun getAll(): List<Jogo> {
        val listaJogos = mutableListOf<Jogo>()

        Database.getConnection()?.use { connection ->
            val statement = connection.createStatement()
            val resultSet = statement.executeQuery("SELECT * FROM jogos")
            while (resultSet.next()) {
                val jogo = Jogo(
                    resultSet.getString("titulo"),
                    resultSet.getString("capa"),
                    resultSet.getBigDecimal("preco"),
                    resultSet.getString("descricao"),
                    resultSet.getInt("id")
                )
                listaJogos.add(jogo)
            }
        }
        return listaJogos
    }

    fun getById(id: Int): Jogo? {
        var jogo: Jogo? = null

        Database.getConnection()?.use { connection ->
            val statement = connection.prepareStatement("SELECT * FROM jogos WHERE id = ?")
            statement.setInt(1, id)
            val resultSet = statement.executeQuery()
            if (resultSet.next()) {
                jogo = Jogo(
                    resultSet.getString("titulo"),
                    resultSet.getString("capa"),
                    resultSet.getBigDecimal("preco"),
                    resultSet.getString("descricao"),
                    resultSet.getInt("id")
                )
            }
        }
        return jogo
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