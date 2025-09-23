package br.com.alura.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.databinding.ActivityFormularioCadastroUsuarioBinding
import br.com.alura.orgs.extensions.toHash
import br.com.alura.orgs.extensions.toast
import br.com.alura.orgs.model.Usuario

class FormularioCadastroUsuarioActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioCadastroUsuarioBinding.inflate(layoutInflater)
    }

    private val dao by lazy {
        AppDatabase.instancia(this).usuarioDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraBotaoCadastrar()
    }

    private fun configuraBotaoCadastrar() {
        binding.activityFormularioCadastroBotaoCadastrar.setOnClickListener {
            val novoUsuario = criaUsuario()
            cadastraUsuario(novoUsuario)
        }
    }

    private fun cadastraUsuario(usuario: Usuario) {
        lifecycleScope.launchWhenCreated {
            try {
                dao.salva(usuario)
                finish()
            } catch (e: Exception) {
                Log.e("CadastroUsuario", "onCreate: $e")
                toast("Erro ao cadastrar usuário")
            }
        }
    }

    private fun criaUsuario(): Usuario {
        val usuario = binding.activityFormularioCadastroUsuario.text.toString()
        val nome = binding.activityFormularioCadastroNome.text.toString()
        val senha = binding.activityFormularioCadastroSenha.text.toString().toHash()
        return Usuario(usuario, nome, senha)
    }
}