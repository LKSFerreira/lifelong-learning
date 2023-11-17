using tabuleiro;

namespace xadrez.pecas
{
    class Bispo : Peca
    {
        public Bispo(Tabuleiro tabuleiro, Cor cor) : base(tabuleiro, cor)
        {
        }

        public override string ToString()
        {
            return "B";
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

            // Movimento Noroeste
            posicao.definirValores(posicao.Linha - 1, posicao.Coluna - 1);
            while (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                if (tabuleiro.peca(posicao) != null && tabuleiro.peca(posicao).cor != cor)
                {
                    break;
                }
                posicao.definirValores(posicao.Linha - 1, posicao.Coluna - 1);
            }

            // Movimento Nordeste
            posicao.definirValores(posicao.Linha - 1, posicao.Coluna + 1);
            while (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                if (tabuleiro.peca(posicao) != null && tabuleiro.peca(posicao).cor != cor)
                {
                    break;
                }
                posicao.definirValores(posicao.Linha - 1, posicao.Coluna + 1);
            }


            // Movimento Sudeste
            posicao.definirValores(posicao.Linha + 1, posicao.Coluna + 1);
            while (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                if (tabuleiro.peca(posicao) != null && tabuleiro.peca(posicao).cor != cor)
                {
                    break;
                }
                posicao.definirValores(posicao.Linha + 1, posicao.Coluna + 1);
            }

            // Movimento Sudoeste
            posicao.definirValores(posicao.Linha + 1, posicao.Coluna - 1);
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