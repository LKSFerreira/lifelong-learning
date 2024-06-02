package lks.ferreira.orgs.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import lks.ferreira.orgs.dao.ProdutosDao
import lks.ferreira.orgs.databinding.ActivityFormularioProdutoBinding
import lks.ferreira.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setConfigSalvar()
    }

    private fun setConfigSalvar() {
        val botaoSalvar = binding.botaoSalvar
        val dao = ProdutosDao()

        botaoSalvar.setOnClickListener {
            val novoProduto = criaProduto()
            dao.adiciona(novoProduto)
            Toast.makeText(this, "Produto adicionado com sucesso", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun criaProduto(): Produto {
        val nomeProduto = binding.activityFormularioProdutoNome.text.toString()
        val descricaoProduto = binding.activityFormularioProdutoDescricao.text.toString()
        val precoProdutoString = binding.activityFormularioProdutoValor.text.toString()
        val precoProduto =
            if (precoProdutoString.isBlank()) BigDecimal.ZERO else precoProdutoString.toBigDecimal()

        return Produto(nomeProduto, descricaoProduto, precoProduto)
    }
}