using jogos_de_tabuleiro.controller.naval.navios;

namespace jogos_de_tabuleiro.controller.naval.tabuleiro
{
    public class Tabuleiro
    {
        private string[,] _tabuleiro;
        private int _tamanhoTabuleiro;
        public List<Navio> NaviosPlayer;
        public HashSet<Posicao> naviosAcertados;
        public HashSet<Posicao> naviosPosicionados;



        public Tabuleiro(int tamanhoTabuleiro)
        {
            _tamanhoTabuleiro = tamanhoTabuleiro;
            _tamanhoTabuleiro++;
            _tabuleiro = new String[_tamanhoTabuleiro, _tamanhoTabuleiro];

            NaviosPlayer = new List<Navio>();
            naviosAcertados = new HashSet<Posicao>();
            naviosPosicionados = new HashSet<Posicao>();

            Random random = new Random();
            int linha = random.Next(_tamanhoTabuleiro);
            int coluna = random.Next(_tamanhoTabuleiro);
            NaviosPlayer.Add(new NavioPequeno(new Posicao(linha, coluna)));

            linha = random.Next(_tamanhoTabuleiro - 1);
            coluna = random.Next(_tamanhoTabuleiro - 3);

            NaviosPlayer.Add(new NavioMedio(new Posicao(linha, coluna)));


            foreach (var navio in NaviosPlayer)
            {
                foreach (var posicao in navio.Posicao)
                {
                    naviosPosicionados.Add(posicao);
                }
            }
        }

        public bool EhJogadaValida(int linha, int coluna)
        {
            return linha >= 0 && linha < _tamanhoTabuleiro && coluna >= 0 && coluna < _tamanhoTabuleiro && _tabuleiro[linha, coluna] == null;
        }

        public void AtualizarTabuleiro(Posicao posicao, string valor)
        {
            _tabuleiro[posicao.Linha, posicao.Coluna] = valor;
        }

        public void ImprimirTabuleiro()
        {
            Console.WriteLine();
            for (int i = 0; i < _tamanhoTabuleiro; i++)
            {
                for (int j = 0; j < _tamanhoTabuleiro; j++)
                {
                    Console.Write(" {0} ", _tabuleiro[i, j] ?? "~");
                }
                Console.WriteLine();
            }
            Console.WriteLine();
        }

    }
}