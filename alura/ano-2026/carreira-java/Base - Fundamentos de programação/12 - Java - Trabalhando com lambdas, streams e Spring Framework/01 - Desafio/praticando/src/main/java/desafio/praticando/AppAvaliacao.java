package desafio.praticando;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import desafio.praticando.models.Assinatura;
import desafio.praticando.models.Avaliacao;
import desafio.praticando.models.Produto;
import desafio.praticando.models.Servico;

public class AppAvaliacao {
    public void executar() {
        System.out.println("\n");
        LayoutTerminal.msg("App de Avaliações");

        Produto produto1 = new Produto();
        produto1.setNome("Ar condicionado");
        produto1.setPreco(2000);

        Produto produto2 = new Produto();
        produto2.setNome("Geladeira");
        produto2.setPreco(3000);

        Produto produto3 = new Produto();
        produto3.setNome("Fogão");
        produto3.setPreco(1500);

        Servico servico1 = new Servico();
        servico1.setDescricao("Instalação de ar condicionado");
        servico1.setPreco(500);

        Servico servico2 = new Servico();
        servico2.setDescricao("Manutenção de geladeira");
        servico2.setPreco(300);

        Servico servico3 = new Servico();
        servico3.setDescricao("Entrega (Frete) do Fogão");
        servico3.setPreco(100);

        Assinatura assinatura1 = new Assinatura();
        assinatura1.setNome("Netflix");
        assinatura1.setPreco(50);
        assinatura1.setExpiraEm(new Date());

        Assinatura assinatura2 = new Assinatura();
        assinatura2.setNome("Spotify");
        assinatura2.setPreco(30);
        assinatura2.setExpiraEm(new Date());

        Assinatura assinatura3 = new Assinatura();
        assinatura3.setNome("Prime");
        assinatura3.setPreco(100);
        assinatura3.setExpiraEm(new Date());

        Avaliacao<Produto> avaliacaoProduto1 = new Avaliacao<>();
        avaliacaoProduto1.setItem(produto1);
        avaliacaoProduto1.setNota(10);
        avaliacaoProduto1.setComentario("Ótimo produto");

        Avaliacao<Produto> avaliacaoProduto2 = new Avaliacao<>();
        avaliacaoProduto2.setItem(produto2);
        avaliacaoProduto2.setNota(9);
        avaliacaoProduto2.setComentario("Bom produto");

        Avaliacao<Produto> avaliacaoProduto3 = new Avaliacao<>();
        avaliacaoProduto3.setItem(produto3);
        avaliacaoProduto3.setNota(8);
        avaliacaoProduto3.setComentario("Produto bom");

        Avaliacao<Servico> avaliacaoServico1 = new Avaliacao<>();
        avaliacaoServico1.setItem(servico1);
        avaliacaoServico1.setNota(10);
        avaliacaoServico1.setComentario("Ótimo serviço");

        Avaliacao<Servico> avaliacaoServico2 = new Avaliacao<>();
        avaliacaoServico2.setItem(servico2);
        avaliacaoServico2.setNota(9);
        avaliacaoServico2.setComentario("Bom serviço");

        Avaliacao<Servico> avaliacaoServico3 = new Avaliacao<>();
        avaliacaoServico3.setItem(servico3);
        avaliacaoServico3.setNota(8);
        avaliacaoServico3.setComentario("Serviço bom");

        Avaliacao<Assinatura> avaliacaoAssinatura1 = new Avaliacao<>();
        avaliacaoAssinatura1.setItem(assinatura1);
        avaliacaoAssinatura1.setNota(10);
        avaliacaoAssinatura1.setComentario("Ótima assinatura");

        Avaliacao<Assinatura> avaliacaoAssinatura2 = new Avaliacao<>();
        avaliacaoAssinatura2.setItem(assinatura2);
        avaliacaoAssinatura2.setNota(9);
        avaliacaoAssinatura2.setComentario("Boa assinatura");

        Avaliacao<Assinatura> avaliacaoAssinatura3 = new Avaliacao<>();
        avaliacaoAssinatura3.setItem(assinatura3);
        avaliacaoAssinatura3.setNota(8);
        avaliacaoAssinatura3.setComentario("Assinatura boa");

        List<Avaliacao<?>> avaliacoes = new ArrayList<>();
        avaliacoes.add(avaliacaoProduto1);
        avaliacoes.add(avaliacaoProduto2);
        avaliacoes.add(avaliacaoProduto3);
        avaliacoes.add(avaliacaoServico1);
        avaliacoes.add(avaliacaoServico2);
        avaliacoes.add(avaliacaoServico3);
        avaliacoes.add(avaliacaoAssinatura1);
        avaliacoes.add(avaliacaoAssinatura2);
        avaliacoes.add(avaliacaoAssinatura3);

        double media = Avaliacao.calculaMediaAvaliacoes(avaliacoes);
        System.out.println("Média de avaliações: " + media);

        LayoutTerminal.finalDeCodigo();

    }
}
