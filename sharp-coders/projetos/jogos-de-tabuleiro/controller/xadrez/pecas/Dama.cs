using tabuleiro;

namespace xadrez.pecas
{
    class Dama : Peca
    {
        public Dama(Tabuleiro tabuleiro, Cor cor) : base(tabuleiro, cor)
        {
        }

        public override string ToString()
        {
            return "D";
        }

        private bool podeMover(Posicao posicao)
        {
            Peca peca = tabuleiro.peca(posicao);
            return peca == null || peca.cor != cor;
        }

        public override bool[,] movimentosPossiveis()
        {

            bool[,] matrizTabuleiro = new bool[tabuleiro.linhas, tabuleiro.colunas];

            Posicao posicao = new Posicao(0, 0);

            // Movimento para Esquerda
            posicao.definirValores(base.posicao.Linha, base.posicao.Coluna - 1);
            while (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                if (tabuleiro.peca(posicao) != null && tabuleiro.peca(posicao).cor != cor)
                {
                    break;
                }
                posicao.definirValores(posicao.Linha, posicao.Coluna - 1);
            }

            // Movimento para Direita
            posicao.definirValores(base.posicao.Linha, base.posicao.Coluna + 1);
            while (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                if (tabuleiro.peca(posicao) != null && tabuleiro.peca(posicao).cor != cor)
                {
                    break;
                }
                posicao.definirValores(posicao.Linha, posicao.Coluna + 1);
            }

            // Movimento para Cima
            posicao.definirValores(base.posicao.Linha - 1, base.posicao.Coluna);
            while (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                if (tabuleiro.peca(posicao) != null && tabuleiro.peca(posicao).cor != cor)
                {
                    break;
                }
                posicao.definirValores(posicao.Linha - 1, posicao.Coluna);
            }

            // Movimento para Baixo
            posicao.definirValores(base.posicao.Linha + 1, base.posicao.Coluna);
            while (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                if (tabuleiro.peca(posicao) != null && tabuleiro.peca(posicao).cor != cor)
                {
                    break;
                }
                posicao.definirValores(posicao.Linha + 1, posicao.Coluna);
            }

            // Movimento para NO
            posicao.definirValores(base.posicao.Linha - 1, base.posicao.Coluna - 1);
            while (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                if (tabuleiro.peca(posicao) != null && tabuleiro.peca(posicao).cor != cor)
                {
                    break;
                }
                posicao.definirValores(posicao.Linha - 1, posicao.Coluna - 1);
            }

            // Movimento para NE
            posicao.definirValores(base.posicao.Linha - 1, base.posicao.Coluna + 1);
            while (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                if (tabuleiro.peca(posicao) != null && tabuleiro.peca(posicao).cor != cor)
                {
                    break;
                }
                posicao.definirValores(posicao.Linha - 1, posicao.Coluna + 1);
            }

            // Movimento para SE
            posicao.definirValores(base.posicao.Linha + 1, base.posicao.Coluna + 1);
            while (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                if (tabuleiro.peca(posicao) != null && tabuleiro.peca(posicao).cor != cor)
                {
                    break;
                }
                posicao.definirValores(posicao.Linha + 1, posicao.Coluna + 1);
            }

            // Movimento para SO
            posicao.definirValores(base.posicao.Linha + 1, base.posicao.Coluna - 1);
            while (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                if (tabuleiro.peca(posicao) != null && tabuleiro.peca(posicao).cor != cor)
                {
                    break;
                }
                posicao.definirValores(posicao.Linha + 1, posicao.Coluna - 1);
            }

            return matrizTabuleiro;
        }
    }
}
