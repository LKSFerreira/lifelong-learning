
namespace jogos_de_tabuleiro.controller.naval.tabuleiro
{
    public abstract class Navio
    {
        public List<Posicao> Posicao { get; set; }

        protected Navio(Posicao posicao)
        {
            Posicao = new List<Posicao>();
        }
    }
}