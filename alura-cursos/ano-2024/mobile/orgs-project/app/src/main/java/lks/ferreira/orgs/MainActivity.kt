package lks.ferreira.orgs

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val nome = findViewById<TextView>(R.id.nome)
        nome.text = "Cesta de Frutas"

        val descricao = findViewById<TextView>(R.id.descricao)
        nome.text = "Banana, Laranja e Maçã"

        val preco = findViewById<TextView>(R.id.preco)
        nome.text = "R$ 10,00"
    }
}