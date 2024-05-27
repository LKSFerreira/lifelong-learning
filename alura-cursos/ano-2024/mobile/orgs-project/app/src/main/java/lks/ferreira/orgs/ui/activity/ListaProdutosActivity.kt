package lks.ferreira.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import lks.ferreira.orgs.dao.ProdutosDao
import lks.ferreira.orgs.databinding.ActivityListaProdutosBinding
import lks.ferreira.orgs.ui.recyclerview.adapter.ListaProdutosAdapter

class ListaProdutosActivity : AppCompatActivity() {
    private val dao = ProdutosDao()
    private val adapter by lazy {
        ListaProdutosAdapter(
            context = this, produtos = dao.buscaTodos()
        )
    }
    private val binding by lazy {
        ActivityListaProdutosBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setConfigRecyclerView()
        setConfigFab()

    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
    }

    private fun setConfigFab() {
        binding.activityListaProdutosFloatingActionButton.setOnClickListener {
            vaiParaFormularioProdutoActivity()
        }
    }

    private fun vaiParaFormularioProdutoActivity() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun setConfigRecyclerView() {
        val recyclerView = binding.activityListaProdutosRecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}