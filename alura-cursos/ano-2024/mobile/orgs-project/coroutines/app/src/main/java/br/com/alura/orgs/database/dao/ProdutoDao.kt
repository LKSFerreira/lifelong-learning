package br.com.alura.orgs.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.com.alura.orgs.model.Produto

@Dao
interface ProdutoDao {

    @Query("SELECT * FROM Produto")
    suspend fun buscaTodos(): List<Produto>

    @Query("SELECT * FROM Produto WHERE id = :id")
    suspend fun buscaPorId(id: Long): Produto

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun salva(vararg produto: Produto)

    @Delete
    suspend fun remove(vararg produto: Produto)

    @Update
    suspend fun altera(vararg produto: Produto)

    @Query("SELECT * FROM Produto ORDER BY nome ASC")
    suspend fun buscaOrdenadoPorNomeAsc(): List<Produto>

    @Query("SELECT * FROM Produto ORDER BY nome DESC")
    suspend fun buscaOrdenadoPorNomeDesc(): List<Produto>

    @Query("SELECT * FROM Produto ORDER BY valor ASC")
    suspend fun buscaOrdenadoPorValorAsc(): List<Produto>

    @Query("SELECT * FROM Produto ORDER BY valor DESC")
    suspend fun buscaOrdenadoPorValorDesc(): List<Produto>

}