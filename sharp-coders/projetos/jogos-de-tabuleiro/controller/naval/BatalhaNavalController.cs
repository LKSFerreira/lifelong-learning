using jogos_de_tabuleiro.controller.naval.tabuleiro;

namespace jogos_de_tabuleiro.controller.naval
{
    public class BatalhaNavalController
    {
        public static void OpcoesMenu(int opcaoMenu)
        {
            switch (opcaoMenu)
            {
                case 1:
                    BatalhaNaval.SelecionarJogadores();
                    break;
                case 2:
                    Dashbord.ExibirRank();
                    break;
                case 3:
                    Dashbord.BuscarJogadorPorID();
                    break;
                case 0:
                    Environment.Exit(0);
                    break;
                default:
                    Console.Clear();
                    Console.WriteLine($"    Por favor seleciona uma opção válida \n");
                    break;
            }
        }

        public bool VerificarJogada(Posicao posicao, Tabuleiro tabuleiro)
        {
            foreach (var navio in tabuleiro.naviosPosicionados)
            {

                if (navio.Linha == posicao.Linha && navio.Coluna == posicao.Coluna)
                {
                    Console.WriteLine("Você acertou o navio!");
                    tabuleiro.AtualizarTabuleiro(posicao, "X");
                    tabuleiro.naviosAcertados.Add(posicao);
                    return true;
                }
            }

            Console.WriteLine("Você errou o navio");
            tabuleiro.AtualizarTabuleiro(posicao, "O");
            return false;
        }

        public PosicaoNaval LerPosicaoXadrez()
        {
            string coordenada = Console.ReadLine().ToLower();
            char coluna = coordenada[0];
            int linha = int.Parse(coordenada[1] + "");
            return new PosicaoNaval(coluna, linha);
        }

    }
}