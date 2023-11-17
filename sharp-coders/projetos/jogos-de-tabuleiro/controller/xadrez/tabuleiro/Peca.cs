namespace tabuleiro
{
    abstract class Peca
    {
        public Posicao posicao { get; set; }
        public Cor cor { get; set; }
        public Tabuleiro tabuleiro { get; protected set; }
        public int quantidadeMovimentos { get; protected set; }

        public Peca(Tabuleiro tabuleiro, Cor cor)
        {
            this.posicao = null;
            this.tabuleiro = tabuleiro;
            this.cor = cor;
            quantidadeMovimentos = 0;
        }

        public void IncrementarMovimento()
        {
            quantidadeMovimentos++;
        }

        public void DecrementarMovimento()
        {
            quantidadeMovimentos--;
        }

        public abstract bool[,] movimentosPossiveis();

        public bool movimentoPossivel(Posicao posicao)
        {
            return movimentosPossiveis()[posicao.Linha, posicao.Coluna];
        }

        public bool existeMovimentosPossiveis()
        {
            bool[,] matrizTabuleiro = movimentosPossiveis();

            for (int i = 0; i < tabuleiro.linhas; i++)
            {
                for (int j = 0; j < tabuleiro.colunas; j++)
                {
                    if (matrizTabuleiro[i, j])
                    {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}