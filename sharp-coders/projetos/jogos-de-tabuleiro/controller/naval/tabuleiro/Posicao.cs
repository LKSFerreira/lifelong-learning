namespace jogos_de_tabuleiro.controller.naval.tabuleiro
{
    public class Posicao
    {
        public int Linha { get; set; }
        public int Coluna { get; set; }

        public Posicao(int linha, int coluna)
        {
            Linha = linha;
            Coluna = coluna;
        }

        public override string ToString()
        {
            return $"{Linha}, {Coluna}.";
        }

        // O método GetHashCode retorna um código hash para a posição, baseado nas propriedades Linha e Coluna.
        public override int GetHashCode()
        {
            // Aqui, é feito o cálculo do código hash usando as propriedades Linha e Coluna.
            // É importante notar que esse método precisa retornar um valor único para cada objeto Posição.
            // Se houver dois objetos Posicao com as mesmas propriedades Linha e Coluna, eles precisam retornar o mesmo código hash.
            int hash = 17;
            hash = hash * 23 + Linha.GetHashCode();
            hash = hash * 23 + Coluna.GetHashCode();
            return hash;
        }

        // O método Equals compara duas posições para verificar se são iguais ou não.
        public override bool Equals(object obj)
        {
            // Aqui, é verificado se o objeto passado é do tipo Posicao.
            // Se não for, o método retorna false.
            Posicao outraPosicao = obj as Posicao;
            if (outraPosicao == null)
            {
                return false;
            }

            // Se o objeto passado é do tipo Posicao, o método compara as propriedades Linha e Coluna.
            // Se ambas forem iguais, o método retorna true, indicando que as posições são iguais.
            return Linha == outraPosicao.Linha && Coluna == outraPosicao.Coluna;
        }

        // Os operadores == e != permitem comparar duas posições usando a comparação padrão.
        public static bool operator ==(Posicao a, Posicao b)
        {
            // Se ambos os objetos forem nulos, o operador retorna true.
            if (ReferenceEquals(a, null) && ReferenceEquals(b, null))
            {
                return true;
            }

            // Se apenas um dos objetos é nulo, o operador retorna false.
            if (ReferenceEquals(a, null) || ReferenceEquals(b, null))
            {
                return false;
            }

            // Se ambos os objetos não são nulos, o operador usa o método Equals para comparar as posições.
            return a.Equals(b);
        }

        public static bool operator !=(Posicao a, Posicao b)
        {
            return !(a == b);
        }
    }
}