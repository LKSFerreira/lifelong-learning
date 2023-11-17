using jogos_de_tabuleiro.model;
using jogos_de_tabuleiro.view;
using tabuleiro;

namespace jogos_de_tabuleiro.controller.xadrez
{
    public class JogoDeXadez
    {
        private static Jogador player01 = new Jogador();
        private static Jogador player02 = new Jogador();

        public static void SelecionarJogadores()
        {
            player01 = Dashbord.PvP();
            player02 = Dashbord.PvP();
            Console.WriteLine($"    {player01.Nome} pronto(a)! Para o adversário(a)\n");
            Console.WriteLine($"    {player02.Nome} preparado(a) para começar!\n ");
            Thread.Sleep(1500);

            Console.Clear();

            ArtASCII.ConstruirNomeArtASCII($"{player01.Nome} VS {player02.Nome}");

            IniciarPartida(player01, player02);
        }

        public static void imprimirTabuleiroXadrez(string tabuleiroXadrez)
        {
            Console.OutputEncoding = System.Text.Encoding.Unicode;
            Console.WriteLine($"    {tabuleiroXadrez}\n");
        }

        public static Jogador[] jogadorDaVez;

        public static void IniciarPartida(Jogador player01, Jogador player02)
        {

            string tabuleiroXadrez = ArtASCII._TabuleiroDeXadrez;

            Console.WriteLine($"    Sorteando primeira jogada... ");
            Thread.Sleep(1500);
            Console.Clear();

            jogadorDaVez = Dashbord.SortearJogador(player01, player02);

            Console.OutputEncoding = System.Text.Encoding.Unicode;

            try
            {

                PartidaXadrez partidaXadrez = new PartidaXadrez();
                while (!partidaXadrez.partidaEncerrada)
                {
                    try
                    {

                        Tela.ImprimirPartida(tabuleiroXadrez, partidaXadrez);

                        Console.WriteLine($"");
                        Console.WriteLine($"    Digite a coordenada da peça que deseja mover:");
                        Posicao origem = Tela.LerPosicaoXadrez().toPosicao();
                        partidaXadrez.ValidarPosicaoOrigem(origem);

                        bool[,] possicoesPossiveis = partidaXadrez.tabuleiro.peca(origem).movimentosPossiveis();

                        Console.WriteLine($"");
                        Console.WriteLine($"    Digite a coordenada para onde deseja mover.");
                        Posicao destino = Tela.LerPosicaoXadrez().toPosicao();
                        partidaXadrez.ValidarPosicaoDestino(origem, destino);

                        partidaXadrez.RealizarJogada(origem, destino);

                        string coordenada = JogoDeXadrezController.ConverterColuna(origem.Coluna) +
                                           JogoDeXadrezController.ConverterLinha(origem.Linha) +
                                           JogoDeXadrezController.ConverterColuna(destino.Coluna) +
                                           JogoDeXadrezController.ConverterLinha(destino.Linha);

                        tabuleiroXadrez = JogoDeXadrezController.MostrarJogadaNoTabuleiroDeXadrez(tabuleiroXadrez, coordenada);
                    }
                    catch (TabuleiroException exception)
                    {
                        Console.WriteLine($"    {exception.Message}");
                        Console.ReadLine();
                    }
                    catch (Exception exception)
                    {
                        Console.WriteLine($"    {exception.Message}");
                        Console.ReadLine();
                    }
                }

                Console.Clear();
                Tela.ImprimirPartida(tabuleiroXadrez, partidaXadrez);
            }
            catch (TabuleiroException exception)
            {
                Console.WriteLine($"    {exception.Message}");
            }
            catch (Exception exception)
            {
                Console.WriteLine($"    {exception.Message}");
                Console.ReadLine();
            }
        }
    }
}