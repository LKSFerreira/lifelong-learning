using tabuleiro;

namespace xadrez.pecas
{
    class Cavalo : Peca
    {
        public Cavalo(Tabuleiro tabuleiro, Cor cor) : base(tabuleiro, cor)
        {
        }

        public override string ToString()
        {
            return "C";
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

            posicao.definirValores(base.posicao.Linha - 1, base.posicao.Coluna - 2);
            if (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
            }

            posicao.definirValores(base.posicao.Linha - 2, base.posicao.Coluna - 1);
            if (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
            }

            posicao.definirValores(base.posicao.Linha - 2, base.posicao.Coluna + 1);
            if (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
            }

            posicao.definirValores(base.posicao.Linha - 1, base.posicao.Coluna + 2);
            if (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
            }

            posicao.definirValores(base.posicao.Linha + 1, base.posicao.Coluna + 2);
            if (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
            }

            posicao.definirValores(base.posicao.Linha + 2, base.posicao.Coluna + 1);
            if (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
            }

            posicao.definirValores(base.posicao.Linha + 2, base.posicao.Coluna - 1);
            if (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
            }

            posicao.definirValores(base.posicao.Linha + 1, base.posicao.Coluna - 2);
            if (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
            }

            return matrizTabuleiro;
        }
    }
}