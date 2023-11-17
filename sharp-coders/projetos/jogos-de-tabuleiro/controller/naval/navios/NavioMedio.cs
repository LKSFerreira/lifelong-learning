using jogos_de_tabuleiro.controller.naval.tabuleiro;

namespace jogos_de_tabuleiro.controller.naval.navios
{
    class NavioMedio : Navio
    {
        private int _TamanhoLinhaNavio = 2;
        private int _TamanhoColunaNavio = 4;
        public NavioMedio(Posicao posicao) : base(posicao)
        {   
            
            TamanhoNavio(posicao);
        }

        public void TamanhoNavio(Posicao posicao)
        {

            for (int i = posicao.Linha; i < (posicao.Linha + _TamanhoLinhaNavio); i++)
            {
                for (int j = posicao.Coluna; j < (posicao.Coluna + _TamanhoColunaNavio); j++)
                {
                    base.Posicao.Add(new Posicao(i, j));
                }
            }
        }
    }
}