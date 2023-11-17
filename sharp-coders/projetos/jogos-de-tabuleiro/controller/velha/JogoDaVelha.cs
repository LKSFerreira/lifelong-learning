using jogos_de_tabuleiro.model;
using jogos_de_tabuleiro.view;


namespace jogos_de_tabuleiro.controller.velha
{
    public class JogoDaVelha
    {
        private static Jogador player01 = new Jogador();
        private static Jogador player02 = new Jogador();


        public static void SelecionarJogadores()
        {
            player01 = Dashbord.PvP();
            player02 = Dashbord.PvP();
            Console.WriteLine($"    {player01.Nome} pronto(a)! Para o adversário(a)\n");
            Console.WriteLine($"    {player02.Nome} preparado(a) para começar!\n ");
            Thread.Sleep(3000);

            Console.Clear();

            ArtASCII.ConstruirNomeArtASCII($"{player01.Nome} VS {player02.Nome}");

            IniciarPartida(player01, player02);
        }
        private static void IniciarPartida(Jogador player01, Jogador player02)
        {
            JogoDaVelhaController.coordenadasOcupadas.Clear();

            Console.WriteLine($"    Sorteando primeira jogada... ");
            Thread.Sleep(1500);
            Console.Clear();

            var jogadorDaVez = Dashbord.SortearJogador(player01, player02);
            Console.Clear();
            Console.WriteLine($"    Digite as coordenada pela LETRA + NÚMERO ou você pode utilizar SOMENTE os números do seu teclado como refência para a posição.");
            var tabuleiro = ArtASCII._TabuleiroDaVelha;


            Console.WriteLine($"    {tabuleiro}\n");

            int numeroDeJogadas = 0;
            Random random = new Random();

            // HashSet<int> numerosSorteados = new();
            HashSet<int> jogadasPlayer01 = new();
            HashSet<int> jogadasPlayer02 = new();

            // while (numerosSorteados.Count < 9)
            // {
            //     int numeroAleatorio = random.Next(1, 10);
            //     numerosSorteados.Add(numeroAleatorio);
            // }

            int quantidadeJogadas = 0, jogada = 1;
            string jogadorX = "X", jogadorO = "O";

            do
            {              

                Console.WriteLine($"    {jogada}\u00aa jogada de: {jogadorDaVez[0].Nome}");
                string jogadaDoPlayer01 = Console.ReadLine().ToUpper();

                var realizadaJogada = JogoDaVelhaController.RealizarJogada(tabuleiro, jogadaDoPlayer01, jogadorX);
                tabuleiro = realizadaJogada.Item2;
                jogadasPlayer01.Add(realizadaJogada.Item1);

                quantidadeJogadas++;
                jogada++;
                numeroDeJogadas++;

                Console.Clear();

                Console.WriteLine($"    {tabuleiro}\n");

                if (JogoDaVelhaController.CondicionalVitoria(tabuleiro, jogadorX))
                {
                    Console.ForegroundColor = ConsoleColor.Green;
                    ArtASCII.ConstruirNomeArtASCII($"{jogadorDaVez[0].Nome} Venceu");
                    Console.ResetColor();
                    return;
                }

                Thread.Sleep(100);

                if (quantidadeJogadas == 9) break;
                                

                Console.WriteLine($"    {jogada}\u00aa jogada de: {jogadorDaVez[1].Nome}");
                string jogadaPlayer02 = Console.ReadLine().ToUpper();

                realizadaJogada = JogoDaVelhaController.RealizarJogada(tabuleiro, jogadaPlayer02, jogadorO);
                tabuleiro = realizadaJogada.Item2;
                jogadasPlayer02.Add(realizadaJogada.Item1);

                quantidadeJogadas++;
                jogada++;
                numeroDeJogadas++;

                Console.Clear();
                
                Console.WriteLine($"    {tabuleiro}\n");

                if (JogoDaVelhaController.CondicionalVitoria(tabuleiro, jogadorO))
                {
                    Console.ForegroundColor = ConsoleColor.Green;
                    ArtASCII.ConstruirNomeArtASCII($"{jogadorDaVez[1].Nome} Venceu");
                    Console.ResetColor();
                    return;
                }
                Thread.Sleep(100);
            } while (numeroDeJogadas < 9);

        }


    }
}