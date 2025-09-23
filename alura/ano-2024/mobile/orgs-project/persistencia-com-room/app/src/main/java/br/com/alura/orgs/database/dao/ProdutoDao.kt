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
    fun buscaTodos(): List<Produto>

    @Query("SELECT * FROM Produto WHERE id = :id")
    fun buscaPorId(id: Long): Produto

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun salva(vararg produto: Produto)

    @Delete
    fun remove(vararg produto: Produto)

    @Update
    fun altera(vararg produto: Produto)

    @Query("SELECT * FROM Produto ORDER BY nome ASC")
    fun buscaOrdenadoPorNomeAsc(): List<Produto>

    @Query("SELECT * FROM Produto ORDER BY nome DESC")
    fun buscaOrdenadoPorNomeDesc(): List<Produto>

    @Query("SELECT * FROM Produto ORDER BY valor ASC")
    fun buscaOrdenadoPorValorAsc(): List<Produto>

    @Query("SELECT * FROM Produto ORDER BY valor DESC")
    fun buscaOrdenadoPorValorDesc(): List<Produto>

}