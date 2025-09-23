package br.com.alura.orgs.ui.recyclerview.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.extensions.formataParaMoedaBrasileira
import br.com.alura.orgs.extensions.tentaCarregarImagem
import br.com.alura.orgs.model.Produto
import lks.ferreira.orgs.R
import lks.ferreira.orgs.databinding.ProdutoItemBinding

class ListaProdutosAdapter(
    private val context: Context,
    produtos: List<Produto> = emptyList(),
    var quandoClicaNoItem: (produto: Produto) -> Unit = {},
    var quandoClicaEmEditar: (produto: Produto) -> Unit = {},
    var quandoClicaEmRemover: (produto: Produto) -> Unit = {}
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val produtos = produtos.toMutableList()

    inner class ViewHolder(
        private val binding: ProdutoItemBinding,
        private val quandoClicaNoItem: (produto: Produto) -> Unit
    ) : RecyclerView.ViewHolder(binding.root), PopupMenu.OnMenuItemClickListener {
        private lateinit var produto: Produto

        init {
            itemView.setOnClickListener {
                if (::produto.isInitialized) {
                    quandoClicaNoItem(produto)
                }

                PopupMenu(context, itemView).apply {
                    menuInflater.inflate(R.menu.menu_detalhes_produto, menu)
                    setOnMenuItemClickListener(this@ViewHolder)
                }.show()
            }
        }

        fun vincula(produto: Produto) {
            this.produto = produto

            val nome = binding.produtoItemNome
            nome.text = produto.nome
            val descricao = binding.produtoItemDescricao
            descricao.text = produto.descricao
            val valor = binding.produtoItemValor
            valor.text = produto.valor.formataParaMoedaBrasileira()

            val visibilidade = if (produto.imagem != null) {
                View.VISIBLE
            } else {
                View.GONE
            }

            binding.imageView.visibility = visibilidade
            binding.imageView.tentaCarregarImagem(produto.imagem)
        }

        override fun onMenuItemClick(item: MenuItem?): Boolean {
            item?.let {
                when (it.itemId) {
                    R.id.menu_detalhes_produto_editar -> {
                        quandoClicaEmEditar(produto)
                    }

                    R.id.menu_detalhes_produto_remover -> {
                        quandoClicaEmRemover(produto)
                    }
                }
            }
            return true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ProdutoItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding, quandoClicaNoItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    override fun getItemCount(): Int = produtos.size

    @SuppressLint("NotifyDataSetChanged")
    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }

}