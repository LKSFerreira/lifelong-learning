using jogos_de_tabuleiro.controller;
using jogos_de_tabuleiro.controller.xadrez;
using tabuleiro;

namespace jogos_de_tabuleiro
{
    class Tela
    {
        public static void ImprimirPartida(string tabuleiroXadrez, PartidaXadrez partida)
        {
            JogoDeXadez.imprimirTabuleiroXadrez(tabuleiroXadrez);
            Console.WriteLine();

            ImprimirPecasCapturadas(partida);
            Console.WriteLine();

            Console.WriteLine($"    Turno: {partida.turno}");

            if (!partida.partidaEncerrada)
            {
                Console.WriteLine($"    Aguardando jogada: {partida.jogadorAtual}");
                if (partida.xeque)
                {
                    ConsoleColor consoleColor = Console.ForegroundColor;
                    Console.ForegroundColor = ConsoleColor.Red;
                    Console.WriteLine($"    XEQUE!");
                    Console.ForegroundColor = consoleColor;
                }
            }
            else
            {
                ConsoleColor consoleColor = Console.ForegroundColor;
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine($"    XEQUEMATE!");
                Console.ForegroundColor = consoleColor;
                Console.WriteLine($"    Vencedor: " + partida.jogadorAtual);

                if (partida.jogadorAtual == Cor.Branca)
                {
                    Dashbord.AtualizarStatusJogador(JogoDeXadez.jogadorDaVez[0].Id, Dashbord.AtualizarJogadores(), "venceu");
                }
                else
                {
                    Dashbord.AtualizarStatusJogador(JogoDeXadez.jogadorDaVez[1].Id, Dashbord.AtualizarJogadores(), "perdeu");
                }


            }
        }

        public static void ImprimirPecasCapturadas(PartidaXadrez partida)
        {
            Console.WriteLine($"    Peças capturadas: ");
            Console.Write($"    Brancas: ");
            ImprimirConjunto(partida.pecasCapturadas(Cor.Branca));

            Console.WriteLine();

            Console.Write("    Pretas: ");
            ConsoleColor consoleColor = Console.ForegroundColor;
            Console.ForegroundColor = ConsoleColor.Yellow;
            ImprimirConjunto(partida.pecasCapturadas(Cor.Preta));
            Console.ForegroundColor = consoleColor;
            Console.WriteLine();
        }


        public static void ImprimirConjunto(HashSet<Peca> conjunto)
        {
            Console.Write("[");
            foreach (Peca pecaX in conjunto)
            {
                Console.Write(pecaX + " ");
            }
            Console.Write("]");
        }

        public static PosicaoXadrez LerPosicaoXadrez()
        {
            string coordenada = Console.ReadLine().ToLower();
            char coluna = coordenada[0];
            int linha = int.Parse(coordenada[1] + "");
            return new PosicaoXadrez(coluna, linha);
        }
    }
}