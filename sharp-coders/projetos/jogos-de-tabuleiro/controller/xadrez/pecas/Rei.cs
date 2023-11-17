using tabuleiro;
using jogos_de_tabuleiro.controller.xadrez;

namespace xadrez.pecas
{
    class Rei : Peca
    {
        private PartidaXadrez partida;

        public Rei(Tabuleiro tabuleiro, Cor cor, PartidaXadrez partida) : base(tabuleiro, cor)
        {
            this.partida = partida;
        }

        public override string ToString()
        {
            return "R";
        }

        private bool podeMover(Posicao posicao)
        {
            Peca peca = tabuleiro.peca(posicao);
            return peca == null || peca.cor != cor;
        }

        private bool ChecarTorreParaRoque(Posicao posicao)
        {
            Peca peca = tabuleiro.peca(posicao);
            return peca != null && peca is Torre && peca.cor == cor && peca.quantidadeMovimentos == 0;
        }

        public override bool[,] movimentosPossiveis()
        {

            bool[,] matrizTabuleiro = new bool[tabuleiro.linhas, tabuleiro.colunas];
            Posicao posicao = new Posicao(0, 0);

            // Movimentar para Acima
            posicao.definirValores(base.posicao.Linha - 1, base.posicao.Coluna);
            if (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
            }

            // Movimentar para Nordeste
            posicao.definirValores(base.posicao.Linha - 1, base.posicao.Coluna + 1);
            if (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
            }

            // Movimentar para Direita
            posicao.definirValores(base.posicao.Linha, base.posicao.Coluna + 1);
            if (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
            }

            // Movimentar para Sudeste
            posicao.definirValores(base.posicao.Linha + 1, base.posicao.Coluna + 1);
            if (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
            }

            // Movimentar para baixo
            posicao.definirValores(base.posicao.Linha + 1, base.posicao.Coluna);
            if (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
            }

            // Movimentar para Sudoeste
            posicao.definirValores(base.posicao.Linha + 1, base.posicao.Coluna - 1);
            if (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
            }

            // Movimentar para Esquerda
            posicao.definirValores(base.posicao.Linha, base.posicao.Coluna - 1);
            if (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
            }

            // Movimentar para Noroeste
            posicao.definirValores(base.posicao.Linha - 1, base.posicao.Coluna - 1);
            if (tabuleiro.posicaoValida(posicao) && podeMover(posicao))
            {
                matrizTabuleiro[posicao.Linha, posicao.Coluna] = true;
            }

            // #Jogada Especial Roque
            if (quantidadeMovimentos == 0 && !partida.xeque)
            {
                // #Jogada Especial Roque Pequeno
                Posicao posT1 = new Posicao(base.posicao.Linha, base.posicao.Coluna + 3);
                if (ChecarTorreParaRoque(posT1))
                {
                    Posicao p1 = new Posicao(base.posicao.Linha, base.posicao.Coluna + 1);
                    Posicao p2 = new Posicao(base.posicao.Linha, base.posicao.Coluna + 2);
                    if (tabuleiro.peca(p1) == null && tabuleiro.peca(p2) == null)
                    {
                        matrizTabuleiro[base.posicao.Linha, base.posicao.Coluna + 2] = true;
                    }
                }
                // #Jogada Especial Roque Grande
                Posicao posT2 = new Posicao(base.posicao.Linha, base.posicao.Coluna - 4);
                if (ChecarTorreParaRoque(posT2))
                {
                    Posicao p1 = new Posicao(base.posicao.Linha, base.posicao.Coluna - 1);
                    Posicao p2 = new Posicao(base.posicao.Linha, base.posicao.Coluna - 2);
                    Posicao p3 = new Posicao(base.posicao.Linha, base.posicao.Coluna - 3);
                    if (tabuleiro.peca(p1) == null && tabuleiro.peca(p2) == null && tabuleiro.peca(p3) == null)
                    {
                        matrizTabuleiro[base.posicao.Linha, base.posicao.Coluna - 2] = true;
                    }
                }

            }
            return matrizTabuleiro;
        }
    }
}