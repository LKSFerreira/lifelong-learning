

namespace jogos_de_tabuleiro.controller.xadrez
{
    public class JogoDeXadrezController
    {
        public static void OpcoesMenu(int opcaoMenu)
        {
            switch (opcaoMenu)
            {
                case 1:
                    JogoDeXadez.SelecionarJogadores();
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

        public static string MostrarJogadaNoTabuleiroDeXadrez(string tabuleiro, string coordenada)
        {
            string peca = coordenada[0].ToString() + coordenada[1].ToString().ToUpper();
            string movimento = coordenada[2].ToString() + coordenada[3].ToString().ToUpper();
            string pecaDeSubstituicao = " ";
            int linha = int.Parse(coordenada[1].ToString());

            /**
                Precisamos saber a peça que seja movimento esta em uma casa branca ou preta, para saber qual caraterer posicionaremos no lugar da peça movida
            */

            if (((coordenada[0].Equals('A') ||
                    coordenada[0].Equals('C') ||
                        coordenada[0].Equals('E') ||
                            coordenada[0].Equals('G')) && (linha % 2 == 0)) ||
                                ((coordenada[0].Equals('B') ||
                                    coordenada[0].Equals('D') ||
                                        coordenada[0].Equals('F') ||
                                            coordenada[0].Equals('H')) && ((linha % 2 != 0))))
            {
                pecaDeSubstituicao = "█";
            }
            else
            {
                pecaDeSubstituicao = " ";
            }

            /**
                Removemos a peça e subistituimos pelo caractere correspondente a casa
            */
            string pecaMovida = tabuleiro.ElementAt(coordTabuleiro[peca]).ToString();

            tabuleiro = tabuleiro.Remove(coordTabuleiro[peca], 2).Insert(coordTabuleiro[peca], pecaDeSubstituicao).Insert(coordTabuleiro[peca] + 1, pecaDeSubstituicao);

            pecaDeSubstituicao = "";

            Thread.Sleep(1000);

            /**
                .Insert(coordTabuleiro[movimento] - 1, pecaMovida) essa linha precisamos corrigir a posição na qual o caractere será adicionado.
            */
            tabuleiro = tabuleiro.Insert(coordTabuleiro[movimento], pecaMovida).Insert(coordTabuleiro[movimento] + 1, " ").Remove(coordTabuleiro[movimento] + 2, 2);
            return tabuleiro;
        }

        public static string ConverterColuna(int coluna)
        {
            return letrasColunas[coluna];
        }

        static IDictionary<int, string> letrasColunas = new Dictionary<int, string>
        {
        {0,"A"},
        {1,"B"},
        {2,"C"},
        {3,"D"},
        {4,"E"},
        {5,"F"},
        {6,"G"},
        {7,"H"}
        };

        public static string ConverterLinha(int linha)
        {
            return numeroLinha[linha];
        }

        static IDictionary<int, string> numeroLinha = new Dictionary<int, string>
        {
        {0,"8"},
        {1,"7"},
        {2,"6"},
        {3,"5"},
        {4,"4"},
        {5,"3"},
        {6,"2"},
        {7,"1"}
        };


        static IDictionary<string, int> coordTabuleiro = new Dictionary<string, int>
        {
        {"A8",75},
        {"B8",83},
        {"C8",91},
        {"D8",99},
        {"E8",107},
        {"F8",115},
        {"G8",123},
        {"H8",131},

        {"A7",279},
        {"B7",287},
        {"C7",295},
        {"D7",303},
        {"E7",311},
        {"F7",319},
        {"G7",327},
        {"H7",335},

        {"A6",487},
        {"B6",495},
        {"C6",503},
        {"D6",511},
        {"E6",519},
        {"F6",527},
        {"G6",535},
        {"H6",543},

        {"A5",691},
        {"B5",699},
        {"C5",707},
        {"D5",715},
        {"E5",723},
        {"F5",731},
        {"G5",729},
        {"H5",747},

        {"A4",899},
        {"B4",907},
        {"C4",915},
        {"D4",923},
        {"E4",931},
        {"F4",939},
        {"G4",947},
        {"H4",955},

        {"A3",1103},
        {"B3",1111},
        {"C3",1119},
        {"D3",1127},
        {"E3",1135},
        {"F3",1143},
        {"G3",1151},
        {"H3",1159},

        {"A2",1311},
        {"B2",1319},
        {"C2",1327},
        {"D2",1335},
        {"E2",1343},
        {"F2",1351},
        {"G2",1359},
        {"H2",1367},

        {"A1",1515},
        {"B1",1523},
        {"C1",1531},
        {"D1",1539},
        {"E1",1547},
        {"F1",1555},
        {"G1",1563},
        {"H1",1571}
        };
    }
}