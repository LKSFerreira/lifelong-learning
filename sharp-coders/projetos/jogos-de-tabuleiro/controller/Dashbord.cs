using jogos_de_tabuleiro.view;
using jogos_de_tabuleiro.model;
using jogos_de_tabuleiro.controller.velha;
using jogos_de_tabuleiro.controller.xadrez;
using Newtonsoft.Json;
using jogos_de_tabuleiro.controller.naval;

namespace jogos_de_tabuleiro.controller
{

    class Dashbord
    {
        public static void Iniciar()
        {
            Console.Write($"{ArtASCII._OpcaoMenuJogoDaVelha}");
            Console.Write($"{ArtASCII._OpcaoMenuJogoDeXadrez}");
            Console.Write($"{ArtASCII._OpcaoMenuBatalhaNaval}\n");


            int opcaoMenu = SelecionarMenu();

            OpcoesMenu(opcaoMenu);
        }

        private static void OpcoesMenu(int opcaoMenu)
        {
            switch (opcaoMenu)
            {
                case 1:
                    Console.Clear();
                    MostrarTitulo(ArtASCII._JogoDaVelha);
                    Menu(opcaoMenu);
                    break;
                case 2:
                    Console.Clear();
                    MostrarTitulo(ArtASCII._JogoDeXadrez);
                    Menu(opcaoMenu);
                    break;
                case 3:
                    Console.Clear();
                    MostrarTitulo(ArtASCII._BatalhaNaval);
                    Menu(opcaoMenu);
                    break;


                default:
                    Console.WriteLine($"    Opcão inválida, digite uma opção dentro do menu");
                    break;
            }
        }

        public static int SelecionarMenu()
        {
            string entradaUsuario = Console.ReadLine();
            int opcaoMenu = 0;

            if (!int.TryParse(entradaUsuario, out opcaoMenu))
            {
                Console.WriteLine($"    Por gentileza, digite um número correspondente");
            }
            return opcaoMenu;
        }

        public static void Menu(int opcaoMenu)
        {


            Console.WriteLine($"    Digite uma opção:\n");
            Console.WriteLine($"    1 - Jogar");
            Console.WriteLine($"    2 - Rank");
            Console.WriteLine($"    3 - Estatísticas do jogador");
            Console.WriteLine($"    0 - Sair");

            if (opcaoMenu == 1) JogoDaVelhaController.OpcoesMenu(Dashbord.SelecionarMenu());
            if (opcaoMenu == 2) JogoDeXadrezController.OpcoesMenu(Dashbord.SelecionarMenu());
            if (opcaoMenu == 3) BatalhaNavalController.OpcoesMenu(Dashbord.SelecionarMenu());
        }

        public static Jogador PvP()
        {
            int idJogador = 0;
            Jogador jogador = new Jogador();

            Console.WriteLine($"    Digite o ID do jogador ou digite um nome para uma novo jogador");
            string idOuNomeJogador = Console.ReadLine();

            if (int.TryParse(idOuNomeJogador, out idJogador))
            {
                jogador = BuscarJogadorPorID(idJogador);
                if (jogador is null)
                {
                    Console.WriteLine($"    Jogador não encontrado.");
                    return jogador = CriarJogador();
                }
                return jogador;
            }
            else
            {
                jogador = new Jogador(idOuNomeJogador);
                AdicionarJogador(jogador);
                BuscarJogadorPorID(jogador.Id);
                return jogador;
            }
        }

        public static Jogador CriarJogador()
        {
            Console.WriteLine($"    Digite o nome do Jogador: ");
            string nome = Console.ReadLine();
            Jogador jogador = new Jogador(nome);
            return jogador;
        }

        public static void MostrarTitulo(string titulo)
        {
            Console.WriteLine($"{titulo}");
        }
        public static Jogador[] SortearJogador(Jogador player1, Jogador player2)
        {
            Random random = new Random();
            int i = 0;
            for (i = 0; i < 8; i++)
            {
                if (i % 2 == 0)
                {
                    ArtASCII.ConstruirNomeArtASCII(player1.Nome);
                    Thread.Sleep(200);
                    Console.Clear();
                }
                else
                {
                    ArtASCII.ConstruirNomeArtASCII(player2.Nome);
                    Thread.Sleep(200);
                    Console.Clear();
                }
            }

            if (random.Next(0, 2) % 2 == 0)
            {
                ArtASCII.ConstruirNomeArtASCII(player1.Nome);
                Jogador[] jogadores = { player1, player2 };
                return jogadores;
            }
            else
            {
                ArtASCII.ConstruirNomeArtASCII(player2.Nome);
                Jogador[] jogadores = { player2, player1 };
                return jogadores;
            }
        }

        private static string pathJogadores = "./data/jogadores.json";

        private static string jsonJogadores = File.ReadAllText(pathJogadores);

        public static List<Jogador> AtualizarJogadores()
        {
            jsonJogadores = File.ReadAllText(pathJogadores);
            List<Jogador> jogadores = JsonConvert.DeserializeObject<List<Jogador>>(jsonJogadores);
            return jogadores;
        }

        public static void AdicionarJogador(Jogador jogador)
        {
            var novoJogadores = AtualizarJogadores();
            novoJogadores.Add(jogador);

            jsonJogadores = JsonConvert.SerializeObject(novoJogadores);

            File.WriteAllText(pathJogadores, jsonJogadores);
        }

        public static void BuscarJogadorPorID()
        {
            Console.WriteLine($"    Por gentileza digite o ID do jogador");
            int idJogador = int.Parse(Console.ReadLine());

            Console.Clear();

            var jogadores = AtualizarJogadores();
            ListarJogadores(idJogador, jogadores);
        }

        private static void ListarJogadores(int idJogador, List<Jogador> jogadores)
        {
            foreach (var jogador in jogadores.Where(player => player.Id == idJogador))
            {
                ArtASCII.ConstruirNomeArtASCII(jogador.Nome.ToUpper());

                Console.WriteLine($"    Pontuação: {jogador.Pontuacao}");
                Console.WriteLine($"    Quantidade de Partidas: {jogador.QuantidadePartidas}");
                Console.WriteLine($"    Vitórias: {jogador.Vitorias}");
                Console.WriteLine($"    Derrotas: {jogador.Derrotas}");
                Console.WriteLine($"    Empates: {jogador.Empates}");

                // Console.Write($"    Histórico:");

                // foreach (var partida in jogador.Historico)
                // {
                //     Console.Write($" {partida}");
                // }
                // Console.WriteLine($"\n");
            }
        }

        public static void AtualizarStatusJogador(int idJogador, List<Jogador> jogadores, string venceu)
        {
            var jogador = jogadores.Find(jogador => jogador.Id == idJogador);

            if (jogador != null)
            {
                if (venceu == "venceu")
                {
                    jogador.Vitorias++;
                    jogador.Pontuacao += 50;
                    jogador.QuantidadePartidas++;
                }
                else
                {
                    jogador.Derrotas++;
                }
                File.WriteAllText("jogadores.json", JsonConvert.SerializeObject(jogador));
            }
            else
            {
                Console.WriteLine("Jogador não encontrado");
            }
        }

        public static Jogador BuscarJogadorPorID(int idJogador)
        {
            var jogadores = AtualizarJogadores();

            Jogador novoJogador = new Jogador();

            foreach (var jogador in jogadores.Where(player => player.Id == idJogador))
            {
                ArtASCII.ConstruirNomeArtASCII(jogador.Nome);

                Console.WriteLine($"    Pontuação: {jogador.Pontuacao}");
                Console.WriteLine($"    Vitórias: {jogador.Vitorias}");

                Console.Write($"\n");

                return jogador;
            }
            return novoJogador;
        }

        public static void ExibirRank()
        {
            Console.Clear();
            Console.WriteLine($"{ArtASCII._Rank}");

            string jsonString = File.ReadAllText(pathJogadores);
            Jogador[] jogadores = JsonConvert.DeserializeObject<Jogador[]>(jsonString);

            foreach (var jogador in jogadores.OrderByDescending(player => player.Pontuacao))
            {
                Console.WriteLine($"    Nome: {jogador.Nome} \t\t Pontuação: {jogador.Pontuacao}");
            }
            Console.Write($"\n");
        }

    }
}