using jogos_de_tabuleiro.controller.naval.tabuleiro;
using jogos_de_tabuleiro.model;
using jogos_de_tabuleiro.view;

namespace jogos_de_tabuleiro.controller.naval
{
    public class BatalhaNaval
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

            Console.WriteLine($"    Sorteando primeira jogada... ");
            Thread.Sleep(1500);
            Console.Clear();

            var jogadorDaVez = Dashbord.SortearJogador(player01, player02);
            Console.Clear();
            Console.WriteLine($"    Digite as coordenada pela LETRA + NÚMERO");

            int numeroDeJogadas = 0;
            Random random = new Random();

            Tabuleiro tabuleiroNavalPlayer01 = new Tabuleiro(10);
            Tabuleiro tabuleiroNavalPlayer02 = new Tabuleiro(10);

            int quantidadeJogadas = 0, jogada = 1;
            bool continuaJogando = true;
            bool player01Ganhou = false, player02Ganhou = false;

            HashSet<Posicao> jogadasDoPlayer01 = new HashSet<Posicao>();
            HashSet<Posicao> jogadasDoPlayer02 = new HashSet<Posicao>();

            do
            {
                Console.WriteLine($"    {jogada}\u00aa jogada de: {jogadorDaVez[0].Nome}");
                //string jogadaPlayer01 = Console.ReadLine().ToUpper();

                tabuleiroNavalPlayer02.ImprimirTabuleiro();
                int linhaUsuario = 0;
                int colunaUsuario = 0;

                Posicao posicaoUsuario = new Posicao(linhaUsuario, colunaUsuario);

                do
                {
                    linhaUsuario = random.Next(0, 11);
                    colunaUsuario = random.Next(0, 11);

                    posicaoUsuario = new Posicao(linhaUsuario, colunaUsuario);
                    continuaJogando = jogadasDoPlayer01.Add(posicaoUsuario);

                } while (!continuaJogando);

                continuaJogando = true;

                BatalhaNavalController batalhaNavalController = new BatalhaNavalController();

                // Mostra o valor atualziado
                batalhaNavalController.VerificarJogada(posicaoUsuario, tabuleiroNavalPlayer02);
                tabuleiroNavalPlayer02.ImprimirTabuleiro();

                if (tabuleiroNavalPlayer02.naviosAcertados.IsSupersetOf(tabuleiroNavalPlayer02.naviosPosicionados))
                {
                    ArtASCII.ConstruirNomeArtASCII($"    {jogadorDaVez[0].Nome} VENCEU");
                    break;
                }

                quantidadeJogadas++;
                jogada++;
                numeroDeJogadas++;

                Thread.Sleep(1);
                Console.Clear();

                Console.WriteLine($"    {jogada}\u00aa jogada de: {jogadorDaVez[1].Nome}");
                // string jogadaDoPlayer02 = Console.ReadLine().ToUpper();

                tabuleiroNavalPlayer01.ImprimirTabuleiro();

                do
                {
                    linhaUsuario = random.Next(0, 11);
                    colunaUsuario = random.Next(0, 11);

                    posicaoUsuario = new Posicao(linhaUsuario, colunaUsuario);
                    continuaJogando = jogadasDoPlayer02.Add(posicaoUsuario);

                } while (!continuaJogando);

                continuaJogando = false;


                // Mostra o valor atualziado
                batalhaNavalController.VerificarJogada(posicaoUsuario, tabuleiroNavalPlayer01);
                tabuleiroNavalPlayer01.ImprimirTabuleiro();

                if (tabuleiroNavalPlayer01.naviosAcertados.IsSupersetOf(tabuleiroNavalPlayer01.naviosPosicionados))
                {
                    ArtASCII.ConstruirNomeArtASCII($"    {jogadorDaVez[1].Nome} VENCEU");
                    break;
                }

                quantidadeJogadas++;
                jogada++;
                numeroDeJogadas++;

                Thread.Sleep(1);
                Console.Clear();

                player01Ganhou = verificarNaviosAtingidos(jogadasDoPlayer01, tabuleiroNavalPlayer01);
                player02Ganhou = verificarNaviosAtingidos(jogadasDoPlayer02, tabuleiroNavalPlayer02);


            } while (player01Ganhou && player02Ganhou);
        }

        private static bool verificarNaviosAtingidos(HashSet<Posicao> jogadasDoPlayer, Tabuleiro tabuleiro)
        {
            return !tabuleiro.naviosAcertados.IsSupersetOf(jogadasDoPlayer);
        }
    }
}