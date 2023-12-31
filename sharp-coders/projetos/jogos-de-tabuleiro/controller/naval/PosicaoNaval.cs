using jogos_de_tabuleiro.controller.naval.tabuleiro;

namespace jogos_de_tabuleiro.controller.naval
{
    public class PosicaoNaval
    {
        public char coluna { get; set; }
        public int linha { get; set; }

        public PosicaoNaval(char coluna, int linha)
        {
            this.coluna = coluna;
            this.linha = linha;
        }

        public Posicao toPosicao()
        {
            return new Posicao(8 - linha, coluna - 'a');
        }

        public override string ToString()
        {
            return "" + coluna + linha;
        }
    }
}