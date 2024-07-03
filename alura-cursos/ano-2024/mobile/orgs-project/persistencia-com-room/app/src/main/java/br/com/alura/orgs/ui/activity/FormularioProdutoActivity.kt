package br.com.alura.orgs.ui.activity

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.extensions.tentaCarregarImagem
import br.com.alura.orgs.model.Produto
import br.com.alura.orgs.ui.dialog.FormularioImagemDialog
import lks.ferreira.orgs.databinding.ActivityFormularioProdutoBinding
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }
    private var url: String? = null
    private var produtoCarregado: Produto? = null
    private var idProduto = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Cadastrar produto"
        configuraBotaoSalvar()

        binding.activityFormularioProdutoImagem.setOnClickListener {
            FormularioImagemDialog(this)
                .mostra(url) { imagem ->
                    url = imagem
                    binding.activityFormularioProdutoImagem.tentaCarregarImagem(url)
                }
        }

        produtoCarregado = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(CHAVE_PRODUTO, Produto::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(CHAVE_PRODUTO)
        }

        produtoCarregado?.let {
            title = "Editando produto"
            idProduto = it.id
            url = it.imagem
            binding.activityFormularioProdutoImagem.tentaCarregarImagem(it.imagem)
            binding.activityFormularioProdutoNome.setText(it.nome)
            binding.activityFormularioProdutoDescricao.setText(it.descricao)
            binding.activityFormularioProdutoValor.setText(it.valor.toPlainString())
        }
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = binding.activityFormularioProdutoBotaoSalvar
        val db = AppDatabase.instance(this)
        botaoSalvar.setOnClickListener {
            val produtoNovo = criaProduto()
            if (idProduto > 0) {
                db.produtoDao().altera(produtoNovo)
            } else {
                db.produtoDao().salva(produtoNovo)
            }
            finish()
        }
    }

    private fun criaProduto(): Produto {
        val campoNome = binding.activityFormularioProdutoNome
        val nome = campoNome.text.toString()
        val campoDescricao = binding.activityFormularioProdutoDescricao
        val descricao = campoDescricao.text.toString()
        val campoValor = binding.activityFormularioProdutoValor
        val valorEmTexto = campoValor.text.toString()
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }

        return Produto(
            id = idProduto,
            nome = nome,
            descricao = descricao,
            valor = valor,
            imagem = url
        )
    }

    companion object {
        const val CHAVE_PRODUTO = "produto"
    }
}