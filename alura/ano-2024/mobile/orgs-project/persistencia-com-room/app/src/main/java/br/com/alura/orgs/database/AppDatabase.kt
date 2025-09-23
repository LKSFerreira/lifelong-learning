package br.com.alura.orgs.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.alura.orgs.converter.Converter
import br.com.alura.orgs.database.dao.ProdutoDao
import br.com.alura.orgs.model.Produto

@Database(entities = [Produto::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun produtoDao(): ProdutoDao

    companion object {

        @Volatile
        private lateinit var db: AppDatabase

        fun instance(context: Context): AppDatabase {
            if (::db.isInitialized) return db
            return Room.databaseBuilder(
                context, AppDatabase::class.java, "orgs.db"
            ).allowMainThreadQueries().build().also { db = it}
        }
    }
}