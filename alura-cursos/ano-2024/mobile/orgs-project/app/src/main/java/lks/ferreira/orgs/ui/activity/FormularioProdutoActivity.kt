package lks.ferreira.orgs.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import lks.ferreira.orgs.R
import lks.ferreira.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val botaoSalvar = findViewById<Button>(R.id.botao_salvar)


        botaoSalvar.setOnClickListener {
            val nomeProduto = findViewById<EditText>(R.id.nome).text.toString()
            val descricaoProduto = findViewById<EditText>(R.id.descricao).text.toString()
            val precoProdutoString = findViewById<EditText>(R.id.valor).text.toString()
            val precoProduto =
                if (precoProdutoString.isBlank()) BigDecimal.ZERO else precoProdutoString.toBigDecimal()

            val novoProduto = Produto(nomeProduto, descricaoProduto, precoProduto)

            Toast.makeText(this, "$novoProduto salvo com sucesso", Toast.LENGTH_LONG).show()
        }
    }
}