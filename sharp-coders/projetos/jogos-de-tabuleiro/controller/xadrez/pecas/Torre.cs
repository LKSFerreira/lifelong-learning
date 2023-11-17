using tabuleiro;

namespace xadrez.pecas
{
    class Torre : Peca
    {
        public Torre(Tabuleiro tabuleiro, Cor cor) : base(tabuleiro, cor)
        {
        }

        public override string ToString()
        {
            return "T";
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

            // Movimento para acima
            posicao.definirValores(base.posicao.Linha - 1, base.posicao.Coluna);
            while (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                if (tabuleiro.peca(posicao) != null && tabuleiro.peca(posicao).cor != cor)
                {
                    break;
                }
                posicao.Linha = posicao.Linha - 1;
            }

            // Movimento para Abaixo
            posicao.definirValores(base.posicao.Linha + 1, base.posicao.Coluna);
            while (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                if (tabuleiro.peca(posicao) != null && tabuleiro.peca(posicao).cor != cor)
                {
                    break;
                }
                posicao.Linha = posicao.Linha + 1;
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
                posicao.Coluna = posicao.Coluna + 1;
            }

            // Movimento para Esquerda
            posicao.definirValores(base.posicao.Linha, base.posicao.Coluna - 1);
            while (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
                if (tabuleiro.peca(posicao) != null && tabuleiro.peca(posicao).cor != cor)
                {
                    break;
                }
                posicao.Coluna = posicao.Coluna - 1;
            }

            return matrizTabuleiro;
        }
    }
}