using jogos_de_tabuleiro.view;
using tabuleiro;
using xadrez.pecas;

namespace jogos_de_tabuleiro.controller.xadrez
{
    class PartidaXadrez
    {
        public Tabuleiro tabuleiro { get; private set; }
        public int turno { get; private set; }
        public Cor jogadorAtual { get; private set; }
        public bool partidaEncerrada { get; set; }
        private HashSet<Peca> pecas;
        private HashSet<Peca> capturadas;
        public Peca recebeEnPassant { get; private set; }
        public bool xeque { get; private set; }

        public PartidaXadrez()
        {
            tabuleiro = new Tabuleiro(8, 8);
            turno = 1;
            jogadorAtual = Cor.Branca;
            xeque = false;
            recebeEnPassant = null;
            partidaEncerrada = false;
            pecas = new HashSet<Peca>();
            capturadas = new HashSet<Peca>();
            colocarPecas();
        }

        public Peca ExecutarMovimento(Posicao origem, Posicao destino)
        {
            Peca peca = tabuleiro.RetirarPeca(origem);
            peca.IncrementarMovimento();
            Peca pecaCapturada = tabuleiro.RetirarPeca(destino);

            tabuleiro.ColocarPeca(destino, peca);
            if (pecaCapturada != null)
            {
                capturadas.Add(pecaCapturada);
            }

            // Jogada Especial Roque Pequeno
            if (peca is Rei && destino.Coluna == origem.Coluna + 2)
            {
                Posicao origemTorre = new Posicao(origem.Linha, origem.Coluna + 3);
                Posicao destinoTorre = new Posicao(origem.Linha, origem.Coluna + 1);
                Peca pecaTorre = tabuleiro.RetirarPeca(origemTorre);
                pecaTorre.IncrementarMovimento();
                tabuleiro.ColocarPeca(destinoTorre, pecaTorre);
            }

            // Jogada Especial Roque Grande
            if (peca is Rei && destino.Coluna == origem.Coluna - 2)
            {
                Posicao origemTorre = new Posicao(origem.Linha, origem.Coluna - 4);
                Posicao destinoTorre = new Posicao(origem.Linha, origem.Coluna - 1);
                Peca pecaTorre = tabuleiro.RetirarPeca(origemTorre);
                pecaTorre.IncrementarMovimento();
                tabuleiro.ColocarPeca(destinoTorre, pecaTorre);
            }

            // Jogada Especial En Passant
            if (peca is Peao)
            {
                if (origem.Coluna != destino.Coluna && pecaCapturada == null)
                {
                    Posicao posicaoDoPeao;
                    if (peca.cor == Cor.Branca)
                    {
                        posicaoDoPeao = new Posicao(destino.Linha + 1, destino.Coluna);
                    }
                    else
                    {
                        posicaoDoPeao = new Posicao(destino.Linha - 1, destino.Coluna);
                    }
                    pecaCapturada = tabuleiro.RetirarPeca(posicaoDoPeao);
                    capturadas.Add(pecaCapturada);
                }
            }

            return pecaCapturada;
        }

        public void DesfazerMovimento(Posicao origem, Posicao destino, Peca pecaCapturada)
        {
            Peca peca = tabuleiro.RetirarPeca(destino);
            peca.DecrementarMovimento();

            if (pecaCapturada != null)
            {
                tabuleiro.ColocarPeca(destino, pecaCapturada);
                capturadas.Remove(pecaCapturada);
            }
            tabuleiro.ColocarPeca(origem, peca);

            // Jogada Especial Roque Pequeno
            if (peca is Rei && destino.Coluna == origem.Coluna + 2)
            {
                Posicao origemTorre = new Posicao(origem.Linha, origem.Coluna + 3);
                Posicao destinoTorre = new Posicao(origem.Linha, origem.Coluna + 1);
                Peca pecaTorre = tabuleiro.RetirarPeca(destinoTorre);
                pecaTorre.DecrementarMovimento();
                tabuleiro.ColocarPeca(origemTorre, pecaTorre);
            }

            // Jogada Especial Roque Grande
            if (peca is Rei && destino.Coluna == origem.Coluna - 2)
            {
                Posicao origemTorre = new Posicao(origem.Linha, origem.Coluna - 4);
                Posicao destinoTorre = new Posicao(origem.Linha, origem.Coluna - 1);
                Peca pecaTorre = tabuleiro.RetirarPeca(destinoTorre);
                pecaTorre.DecrementarMovimento();
                tabuleiro.ColocarPeca(origemTorre, pecaTorre);
            }

            // Jogada Especial En Passant
            if (peca is Peao)
            {
                if (origem.Coluna != destino.Coluna && pecaCapturada == recebeEnPassant)
                {
                    Peca peao = tabuleiro.RetirarPeca(destino);
                    Posicao posicaoDoPeao;
                    if (peca.cor == Cor.Branca)
                    {
                        posicaoDoPeao = new Posicao(3, destino.Coluna);
                    }
                    else
                    {
                        posicaoDoPeao = new Posicao(4, destino.Coluna);
                    }
                    tabuleiro.ColocarPeca(posicaoDoPeao, peao);
                }
            }
        }

        public void RealizarJogada(Posicao origem, Posicao destino)
        {
            Peca pecaCapturada = ExecutarMovimento(origem, destino);
            if (estaEmXeque(jogadorAtual))
            {
                DesfazerMovimento(origem, destino, pecaCapturada);
                throw new TabuleiroException("Você não pode colocar seu Rei em Xeque");
            }

            Peca peca = tabuleiro.peca(destino);

            // Jogada Especial Promoção do Peão
            if (peca is Peao)
            {
                if ((peca.cor == Cor.Branca && destino.Linha == 0) || (peca.cor == Cor.Preta && destino.Linha == 7))
                {
                    peca = tabuleiro.RetirarPeca(destino);
                    pecas.Remove(peca);

                    ConsoleColor color = Console.ForegroundColor;
                    Console.ForegroundColor = ConsoleColor.Green;
                    Console.WriteLine();
                    Console.WriteLine($"    #--- PROMOÇÃO! ---#");
                    Console.WriteLine($"    Opções de promoção:");
                    Console.WriteLine($"     - Dama[D]\n - Torre[T]\n - Bispo[B]\n - Cavalo[C]");
                    Console.ForegroundColor = color;
                    Console.Write("    Digite o caractere da opção escolhida: ");

                    char escolhaDoJogador = char.Parse(Console.ReadLine().ToUpper());

                    switch (escolhaDoJogador)
                    {
                        // Dama
                        case 'D':
                            Peca dama = new Dama(tabuleiro, peca.cor);
                            tabuleiro.ColocarPeca(destino, dama);
                            pecas.Add(dama);
                            break;
                        // Torre

                        case 'T':
                            Peca torre = new Torre(tabuleiro, peca.cor);
                            tabuleiro.ColocarPeca(destino, torre);
                            pecas.Add(torre);
                            break;

                        // Bispo
                        case 'B':
                            Peca bispo = new Bispo(tabuleiro, peca.cor);
                            tabuleiro.ColocarPeca(destino, bispo);
                            pecas.Add(bispo);
                            break;

                        // Cavalo
                        case 'C':
                            Peca cavalo = new Cavalo(tabuleiro, peca.cor);
                            tabuleiro.ColocarPeca(destino, cavalo);
                            pecas.Add(cavalo);
                            break;
                    }
                }
            }

            if (estaEmXeque(pecaAdversaria(jogadorAtual)))
            {
                xeque = true;
            }
            else
            {
                xeque = false;
            }

            if (ChecarXequeMate(pecaAdversaria(jogadorAtual)))
            {
                partidaEncerrada = true;
            }
            else
            {
                turno++;
                MudarJogador();
            }

            // Jogada Especial En Passant
            if (peca is Peao && (destino.Linha == origem.Linha - 2 || destino.Linha == origem.Linha + 2))
            {
                recebeEnPassant = peca;
            }
            else
            {
                recebeEnPassant = null;
            }
        }

        private Cor pecaAdversaria(Cor cor)
        {
            if (cor == Cor.Branca)
            {
                return Cor.Preta;
            }
            else
            {
                return Cor.Branca;
            }
        }

        private Peca rei(Cor cor)
        {
            foreach (Peca pecaX in pecasEmJogo(cor))
            {
                if (pecaX is Rei)
                {
                    return pecaX;
                }
            }
            return null;
        }

        public bool estaEmXeque(Cor cor)
        {
            Peca pecaRei = rei(cor);
            if (pecaRei == null)
            {
                throw new TabuleiroException($"Não tem Rei da cor {cor} no tabuleiro");
            }
            foreach (Peca pecaX in pecasEmJogo(pecaAdversaria(cor)))
            {
                bool[,] matrizTabuleiro = pecaX.movimentosPossiveis();

                if (matrizTabuleiro[pecaRei.posicao.Linha, pecaRei.posicao.Coluna])
                {
                    return true;
                }
            }
            return false;
        }

        public void ValidarPosicaoOrigem(Posicao posicao)
        {
            if (tabuleiro.peca(posicao) == null)
            {
                throw new TabuleiroException("Não existe peça na posição de origem escolhida");
            }

            if (jogadorAtual != tabuleiro.peca(posicao).cor)
            {
                throw new TabuleiroException("A peça escolhida não é sua");
            }

            if (!tabuleiro.peca(posicao).existeMovimentosPossiveis())
            {
                throw new TabuleiroException("Não há movimentos possíveis para a peça escolhida");
            }
        }

        public void ValidarPosicaoDestino(Posicao origem, Posicao destino)
        {
            if (!tabuleiro.peca(origem).movimentoPossivel(destino))
            {
                throw new TabuleiroException("Não é possível realizar esse movimento");
            }
        }

        public void MudarJogador()
        {
            if (jogadorAtual == Cor.Branca)
            {
                ArtASCII.ConstruirNomeArtASCII(JogoDeXadez.jogadorDaVez[1].Nome);
                jogadorAtual = Cor.Preta;
            }
            else
            {
                ArtASCII.ConstruirNomeArtASCII(JogoDeXadez.jogadorDaVez[0].Nome);
                jogadorAtual = Cor.Branca;
            }
        }


        public HashSet<Peca> pecasCapturadas(Cor cor)
        {
            HashSet<Peca> hashSetAuxiliar = new HashSet<Peca>();
            foreach (Peca pecaX in capturadas)
            {
                if (pecaX.cor == cor)
                {
                    hashSetAuxiliar.Add(pecaX);
                }
            }
            return hashSetAuxiliar;
        }

        public HashSet<Peca> pecasEmJogo(Cor cor)
        {
            HashSet<Peca> hashSetAuxiliar = new HashSet<Peca>();
            foreach (Peca pecaX in pecas)
            {
                if (pecaX.cor == cor)
                {
                    hashSetAuxiliar.Add(pecaX);
                }
            }
            hashSetAuxiliar.ExceptWith(pecasCapturadas(cor));
            return hashSetAuxiliar;
        }

        public bool ChecarXequeMate(Cor cor)
        {
            if (!estaEmXeque(cor))
            {
                return false;
            }

            foreach (Peca pecaX in pecasEmJogo(cor))
            {
                bool[,] matrizTabuleiro = pecaX.movimentosPossiveis();

                for (int i = 0; i < tabuleiro.linhas; i++)
                {
                    for (int j = 0; j < tabuleiro.colunas; j++)
                    {
                        if (matrizTabuleiro[i, j])
                        {
                            Posicao origem = pecaX.posicao;
                            Posicao destino = new Posicao(i, j);
                            Peca pecaCapturada = ExecutarMovimento(origem, destino);
                            bool testeXeque = estaEmXeque(cor);
                            DesfazerMovimento(origem, destino, pecaCapturada);
                            if (!testeXeque)
                            {
                                return false;
                            }

                        }
                    }
                }
            }
            return true;
        }

        public void colocarNovaPeca(char coluna, int linha, Peca peca)
        {
            tabuleiro.ColocarPeca(new PosicaoXadrez(coluna, linha).toPosicao(), peca);
            pecas.Add(peca);
        }

        private void colocarPecas()
        {
            colocarNovaPeca('a', 1, new Torre(tabuleiro, Cor.Branca));
            colocarNovaPeca('b', 1, new Cavalo(tabuleiro, Cor.Branca));
            colocarNovaPeca('c', 1, new Bispo(tabuleiro, Cor.Branca));
            colocarNovaPeca('d', 1, new Dama(tabuleiro, Cor.Branca));
            colocarNovaPeca('e', 1, new Rei(tabuleiro, Cor.Branca, this));
            colocarNovaPeca('f', 1, new Bispo(tabuleiro, Cor.Branca));
            colocarNovaPeca('g', 1, new Cavalo(tabuleiro, Cor.Branca));
            colocarNovaPeca('h', 1, new Torre(tabuleiro, Cor.Branca));
            colocarNovaPeca('a', 2, new Peao(tabuleiro, Cor.Branca, this));
            colocarNovaPeca('b', 2, new Peao(tabuleiro, Cor.Branca, this));
            colocarNovaPeca('c', 2, new Peao(tabuleiro, Cor.Branca, this));
            colocarNovaPeca('d', 2, new Peao(tabuleiro, Cor.Branca, this));
            colocarNovaPeca('e', 2, new Peao(tabuleiro, Cor.Branca, this));
            colocarNovaPeca('f', 2, new Peao(tabuleiro, Cor.Branca, this));
            colocarNovaPeca('g', 2, new Peao(tabuleiro, Cor.Branca, this));
            colocarNovaPeca('h', 2, new Peao(tabuleiro, Cor.Branca, this));

            //==============================================================//

            colocarNovaPeca('a', 8, new Torre(tabuleiro, Cor.Preta));
            colocarNovaPeca('b', 8, new Cavalo(tabuleiro, Cor.Preta));
            colocarNovaPeca('c', 8, new Bispo(tabuleiro, Cor.Preta));
            colocarNovaPeca('d', 8, new Dama(tabuleiro, Cor.Preta));
            colocarNovaPeca('e', 8, new Rei(tabuleiro, Cor.Preta, this));
            colocarNovaPeca('f', 8, new Bispo(tabuleiro, Cor.Preta));
            colocarNovaPeca('g', 8, new Cavalo(tabuleiro, Cor.Preta));
            colocarNovaPeca('h', 8, new Torre(tabuleiro, Cor.Preta));
            colocarNovaPeca('a', 7, new Peao(tabuleiro, Cor.Preta, this));
            colocarNovaPeca('b', 7, new Peao(tabuleiro, Cor.Preta, this));
            colocarNovaPeca('c', 7, new Peao(tabuleiro, Cor.Preta, this));
            colocarNovaPeca('d', 7, new Peao(tabuleiro, Cor.Preta, this));
            colocarNovaPeca('e', 7, new Peao(tabuleiro, Cor.Preta, this));
            colocarNovaPeca('f', 7, new Peao(tabuleiro, Cor.Preta, this));
            colocarNovaPeca('g', 7, new Peao(tabuleiro, Cor.Preta, this));
            colocarNovaPeca('h', 7, new Peao(tabuleiro, Cor.Preta, this));
        }
    }
}