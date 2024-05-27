package lks.ferreira.orgs.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import lks.ferreira.orgs.R
import lks.ferreira.orgs.model.Produto
import lks.ferreira.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.adapter = ListaProdutosAdapter(
            context = this, produtos = listOf(
                Produto(
                    nome = "Notebook",
                    descricao = "Notebook i5 8GB",
                    valor = BigDecimal("2500.00")
                ),
                Produto(
                    nome = "Smartphone",
                    descricao = "Smartphone 4GB",
                    valor = BigDecimal("1500.00")
                ),
                Produto(
                    nome = "Tablet",
                    descricao = "Tablet 2GB",
                    valor = BigDecimal("800.00")
                )
            )
        )
        recyclerView.layoutManager = LinearLayoutManager(this)

        findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }
}