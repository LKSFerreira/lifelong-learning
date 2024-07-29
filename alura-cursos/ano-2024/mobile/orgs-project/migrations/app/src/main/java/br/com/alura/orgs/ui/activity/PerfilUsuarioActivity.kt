package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.lifecycleScope
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Usuario
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

class PerfilUsuarioActivity : UsuarioBaseActivity() {
    private lateinit var layout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
        setContentView(layout)

        lifecycleScope.launch {
            usuario.filterNotNull().collect { usuario ->
                criaCamposComInformacoesDoUsuario(usuario)
                criaBotaoSair()
            }
        }
    }

    private suspend fun criaBotaoSair() {
        val botaoSair = Button(this).apply {
            text = context.getString(R.string.sair)
            textSize = 18f
            setTextColor(ContextCompat.getColor(context, android.R.color.white))
            setBackgroundColor(ContextCompat.getColor(context, R.color.red_500))
            width = 400
            setPadding(32, 16, 32, 16)
            setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_action_sair, 0, 0, 0)
            compoundDrawablePadding = 16
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                // Alinha ao centro da tela
                topMargin = 310
            }
        }

        botaoSair.setOnClickListener {
            lifecycleScope.launch {
                logoutUsuario()
            }
        }
        layout.addView(botaoSair)
    }

    private fun criaCamposComInformacoesDoUsuario(usuario: Usuario) {
        val montserrat = ResourcesCompat.getFont(this, R.font.montserrat_bold)

        val campoUsuario = TextView(this).apply {
            text = context.getString(R.string.campo_usuario, usuario.id)
            textSize = 24f
            typeface = montserrat
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                topMargin = 64
            }
        }
        val campoNome = TextView(this).apply {
            text = context.getString(R.string.campo_nome, usuario.nome)
            textSize = 24f
            typeface = montserrat
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                topMargin = 64
            }
        }
        layout.addView(campoUsuario)
        layout.addView(campoNome)
    }
}