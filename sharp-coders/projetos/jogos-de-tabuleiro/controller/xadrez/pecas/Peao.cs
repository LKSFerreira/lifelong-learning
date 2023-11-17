using tabuleiro;
using jogos_de_tabuleiro.controller.xadrez;

namespace xadrez.pecas
{
    class Peao : Peca
    {
        private PartidaXadrez partida;

        public Peao(Tabuleiro tabuleiro, Cor cor, PartidaXadrez partida) : base(tabuleiro, cor)
        {
            this.partida = partida;
        }

        public override string ToString()
        {
            return "P";
        }

        private bool temPecaAdversaria(Posicao posicao)
        {
            Peca peca = tabuleiro.peca(posicao);
            return peca != null && peca.cor != cor;
        }

        private bool posicaoLivre(Posicao posicao)
        {
            return tabuleiro.peca(posicao) == null;
        }

        public override bool[,] movimentosPossiveis()
        {
            bool[,] matrizTabuleiro = new bool[tabuleiro.linhas, tabuleiro.colunas];

            Posicao posicao = new Posicao(0, 0);

            if (cor == Cor.Branca)
            {
                posicao.definirValores(base.posicao.Linha - 1, base.posicao.Coluna);
                if (tabuleiro.posicaoValida(posicao) && posicaoLivre(posicao))
                {
                    matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                }
                posicao.definirValores(base.posicao.Linha - 2, base.posicao.Coluna);
                Posicao p2 = new Posicao(base.posicao.Linha - 1, base.posicao.Coluna);
                if (tabuleiro.posicaoValida(p2) && posicaoLivre(p2) && tabuleiro.posicaoValida(posicao) && posicaoLivre(posicao) && quantidadeMovimentos == 0)
                {
                    matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                }
                posicao.definirValores(base.posicao.Linha - 1, base.posicao.Coluna - 1);
                if (tabuleiro.posicaoValida(posicao) && temPecaAdversaria(posicao))
                {
                    matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                }
                posicao.definirValores(base.posicao.Linha - 1, base.posicao.Coluna + 1);
                if (tabuleiro.posicaoValida(posicao) && temPecaAdversaria(posicao))
                {
                    matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                }

                // #Jogada especial En Passant
                if (base.posicao.Linha == 3)
                {
                    Posicao esquerda = new Posicao(base.posicao.Linha, base.posicao.Coluna - 1);
                    if (tabuleiro.posicaoValida(esquerda) && temPecaAdversaria(esquerda) && tabuleiro.peca(esquerda) == partida.recebeEnPassant)
                    {
                        matrizTabuleiro[esquerda.Linha - 1, esquerda.Coluna] = true;
                    }
                    Posicao direita = new Posicao(base.posicao.Linha, base.posicao.Coluna + 1);
                    if (tabuleiro.posicaoValida(direita) && temPecaAdversaria(direita) && tabuleiro.peca(direita) == partida.recebeEnPassant)
                    {
                        matrizTabuleiro[direita.Linha - 1, direita.Coluna] = true;
                    }
                }

            }
            else
            {
                posicao.definirValores(base.posicao.Linha + 1, base.posicao.Coluna);
                if (tabuleiro.posicaoValida(posicao) && posicaoLivre(posicao))
                {
                    matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                }
                posicao.definirValores(base.posicao.Linha + 2, base.posicao.Coluna);
                Posicao p2 = new Posicao(base.posicao.Linha + 1, base.posicao.Coluna);
                if (tabuleiro.posicaoValida(p2) && posicaoLivre(p2) && tabuleiro.posicaoValida(posicao) && posicaoLivre(posicao) && quantidadeMovimentos == 0)
                {
                    matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                }
                posicao.definirValores(base.posicao.Linha + 1, base.posicao.Coluna - 1);
                if (tabuleiro.posicaoValida(posicao) && temPecaAdversaria(posicao))
                {
                    matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                }
                posicao.definirValores(base.posicao.Linha + 1, base.posicao.Coluna + 1);
                if (tabuleiro.posicaoValida(posicao) && temPecaAdversaria(posicao))
                {
                    matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                }

                // #Jogada especial En passant
                if (base.posicao.Linha == 4)
                {
                    Posicao esquerda = new Posicao(base.posicao.Linha, base.posicao.Coluna - 1);
                    if (tabuleiro.posicaoValida(esquerda) && temPecaAdversaria(esquerda) && tabuleiro.peca(esquerda) == partida.recebeEnPassant)
                    {
                        matrizTabuleiro[esquerda.Linha + 1, esquerda.Coluna] = true;
                    }
                    Posicao direita = new Posicao(base.posicao.Linha, base.posicao.Coluna + 1);
                    if (tabuleiro.posicaoValida(direita) && temPecaAdversaria(direita) && tabuleiro.peca(direita) == partida.recebeEnPassant)
                    {
                        matrizTabuleiro[direita.Linha + 1, direita.Coluna] = true;
                    }
                }

            }

            return matrizTabuleiro;
        }
    }
}