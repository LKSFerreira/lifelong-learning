package lks.ferreira.orgs.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import lks.ferreira.orgs.R
import lks.ferreira.orgs.dao.ProdutosDao
import lks.ferreira.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setConfigSalvar()
    }

    private fun setConfigSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.botao_salvar)
        val dao = ProdutosDao()

        botaoSalvar.setOnClickListener {
            val novoProduto = criaProduto()
            dao.adiciona(novoProduto)
            Toast.makeText(this, "Produto adicionado com sucesso", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun criaProduto(): Produto {
        val nomeProduto = findViewById<EditText>(R.id.activity_formulario_produto_nome).text.toString()
        val descricaoProduto = findViewById<EditText>(R.id.activity_formulario_produto_descricao).text.toString()
        val precoProdutoString = findViewById<EditText>(R.id.activity_formulario_produto_valor).text.toString()
        val precoProduto =
            if (precoProdutoString.isBlank()) BigDecimal.ZERO else precoProdutoString.toBigDecimal()

        return Produto(nomeProduto, descricaoProduto, precoProduto)
    }
}