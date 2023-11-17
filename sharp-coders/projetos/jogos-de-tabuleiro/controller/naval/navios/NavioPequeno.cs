
using jogos_de_tabuleiro.controller.naval.tabuleiro;

namespace jogos_de_tabuleiro.controller.naval.navios
{
    class NavioPequeno : Navio
    {
        public NavioPequeno(Posicao posicao) : base(posicao)
        {
            base.Posicao.Add(posicao);
        }
    }
}