package lks.ferreira.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import lks.ferreira.orgs.R
import lks.ferreira.orgs.ui.recyclerview.adapter.ListaProdutosAdapter

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*        setContentView(R.layout.activity_main)

                val nome = findViewById<TextView>(R.id.nome)
                nome.text = "Cesta de Frutas"

                val descricao = findViewById<TextView>(R.id.descricao)
                nome.text = "Banana, Laranja e Maçã"

                val preco = findViewById<TextView>(R.id.preco)
                nome.text = "R$ 10,00"*/

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ListaProdutosAdapter()
    }
}