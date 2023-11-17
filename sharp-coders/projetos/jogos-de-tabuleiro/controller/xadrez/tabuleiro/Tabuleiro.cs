namespace tabuleiro
{
    class Tabuleiro
    {
        public int linhas { get; set; }
        public int colunas { get; set; }
        private Peca[,] pecas;

        public Tabuleiro(int linhas, int colunas)
        {
            this.linhas = linhas;
            this.colunas = colunas;
            pecas = new Peca[linhas, colunas];
        }

        public Peca peca(Posicao posicao)
        {
            return pecas[posicao.Linha, posicao.Coluna];
        }

        public Peca peca(int linha, int coluna)
        {
            return pecas[linha, coluna];
        }

        public void ColocarPeca(Posicao posicao, Peca peca)
        {
            if (existePeca(posicao))
            {
                throw new TabuleiroException("Existe uma peça nessa posição");
            }
            pecas[posicao.Linha, posicao.Coluna] = peca;
            peca.posicao = posicao;
        }

        public Peca RetirarPeca(Posicao posicao)
        {
            if (peca(posicao) == null)
            {
                return null;
            }

            // Verificar peça auxiliar

            Peca auxiliar = peca(posicao);
            auxiliar.posicao = null;
            pecas[posicao.Linha, posicao.Coluna] = null;
            return auxiliar;
        }

        public bool posicaoValida(Posicao posicao)
        {
            if (posicao.Linha < 0 || posicao.Linha >= linhas || posicao.Coluna < 0 || posicao.Coluna >= colunas)
            {
                return false;
            }
            return true;
        }

        public void ValidarPosicao(Posicao posicao)
        {
            if (!posicaoValida(posicao))
            {
                throw new TabuleiroException("Posição inválida!");
            }
        }

        public bool existePeca(Posicao posicao)
        {
            ValidarPosicao(posicao);
            return peca(posicao) != null;
        }
    
    }
}