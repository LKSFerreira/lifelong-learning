package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import kotlinx.coroutines.launch
import lks.ferreira.orgs.R
import lks.ferreira.orgs.databinding.ActivityListaProdutosActivityBinding

class ListaProdutosActivity : AppCompatActivity() {

    private val adapter = ListaProdutosAdapter(context = this)
    private val binding by lazy {
        ActivityListaProdutosActivityBinding.inflate(layoutInflater)
    }
    private val produtoDao by lazy {
        AppDatabase.instance(this).produtoDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraRecyclerView()
        configuraFab()
        quandoClicarEmEditar()
        quandoClicarEmRemover()

        lifecycleScope.launch {
            produtoDao.buscaTodos().collect {
                adapter.atualiza(it)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_lista_produtos, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        lifecycleScope.launch {
            val produtosOrdenado = when (item.itemId) {
                R.id.menu_lista_produtos_ordenar_nome_asc -> produtoDao.buscaOrdenadoPorNomeAsc()
                R.id.menu_lista_produtos_ordenar_nome_desc -> produtoDao.buscaOrdenadoPorNomeDesc()
                R.id.menu_lista_produtos_ordenar_valor_asc -> produtoDao.buscaOrdenadoPorValorAsc()
                R.id.menu_lista_produtos_ordenar_valor_desc -> produtoDao.buscaOrdenadoPorValorDesc()
                R.id.menu_lista_produtos_ordenar_id -> produtoDao.buscaTodos()
                else -> null
            }
            produtosOrdenado?.let {
                adapter.atualiza(it)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun quandoClicarEmRemover() {
        adapter.quandoClicaEmRemover = {
            lifecycleScope.launch {
                produtoDao.remove(it)
                adapter.atualiza(produtoDao.buscaTodos())
            }
        }
    }

    private fun quandoClicarEmEditar() {
        adapter.quandoClicaEmEditar = {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            intent.putExtra(CHAVE_PRODUTO_ID, it.id)
            startActivity(intent)
        }
    }

    private fun configuraFab() {
        val fab = binding.activityListaProdutosFab
        fab.setOnClickListener {
            vaiParaFormularioProduto()
        }
    }

    private fun vaiParaFormularioProduto() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recyclerView = binding.activityListaProdutosRecyclerView
        recyclerView.adapter = adapter

        adapter.quandoClicaNoItem = {
            val intent = Intent(
                this, DetalhesProdutoActivity::class.java
            ).apply {
                // envio do produto por meio do extra
                putExtra(CHAVE_PRODUTO_ID, it.id)
            }
            startActivity(intent)
        }
    }

}