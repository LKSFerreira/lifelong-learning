package br.com.alura.ceep.migrations

import android.annotation.SuppressLint
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.UUID

val MIGRATION_1_2 = object : Migration(1, 2) {
    @SuppressLint("Range")
    override fun migrate(database: SupportSQLiteDatabase) {
        val tabelaNova = "NovaNota"
        val tabelaAtual = "Nota"

        // Criar uma nova tabela com todos os dados esperados
        database.execSQL("CREATE TABLE IF NOT EXISTS $tabelaNova (id TEXT PRIMARY KEY NOT NULL, titulo TEXT NOT NULL, descricao TEXT NOT NULL, imagem TEXT)")

        // Copiar os dados da tabela atual para a nova tabela
        database.execSQL("INSERT INTO $tabelaNova (id, titulo, descricao, imagem) SELECT id, titulo, descricao, imagem FROM $tabelaAtual")

        // Gerar novos ID's para a nova tabela
        val cursor = database.query("SELECT id FROM $tabelaNova")
        while (cursor.moveToNext()) {
            val id = cursor.getString(cursor.getColumnIndex("id"))
            val novoId = UUID.randomUUID().toString()
            database.execSQL("UPDATE $tabelaNova SET id = '$novoId' WHERE id = '$id'")
        }

        // Remover a tabela atual
        database.execSQL("DROP TABLE $tabelaAtual")

        // Renomear a nova tabela para o nome da tabela atual
        database.execSQL("ALTER TABLE $tabelaNova RENAME TO $tabelaAtual")
    }
}

val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE Nota ADD COLUMN sincronizada INTEGER NOT NULL DEFAULT 0")
    }
}