package lks.alugames.data

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.util.*

object Database {

    private fun loadDatabaseConfig(): Properties {
        val properties = Properties()
        val inputStream = Thread.currentThread().contextClassLoader.getResourceAsStream("config.properties")
        inputStream.use { properties.load(it) }
        return properties
    }

    fun getConnection(): Connection? {
        val props = loadDatabaseConfig()
        val database = props.getProperty("database")
        val uri = "${props.getProperty("databaseUri")}/${database}?ssl-mode=${props.getProperty("sslMode")}"
        val user = props.getProperty("databaseUser")
        val password = props.getProperty("databasePassword")

        return try {
            DriverManager.getConnection(uri, user, password)
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }
}

