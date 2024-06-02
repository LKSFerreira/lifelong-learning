package br.com.alura.todo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import br.com.alura.todo.R
import br.com.alura.todo.dao.NotaDao
import br.com.alura.todo.databinding.FormularioNotaFragmentBinding
import br.com.alura.todo.model.Nota

class FormularioNotaFragment : Fragment() {
    private var _binding: FormularioNotaFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FormularioNotaFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val botao = binding.formularioNotaBotaoSalvarFragment
        botao.setOnClickListener {
            salvaNota(view)
        }
    }

    private fun salvaNota(view: View) {
        val campoTitulo = view.findViewById<TextView>(R.id.formulario_nota_titulo_fragment)
        val titulo = campoTitulo.text.toString()
        val campoDescricao = view.findViewById<TextView>(R.id.formulario_nota_descricao_fragment)
        val descricao = campoDescricao.text.toString()
        val nota = Nota(titulo, descricao)
        NotaDao().salva(nota)
        activity?.onBackPressed()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}