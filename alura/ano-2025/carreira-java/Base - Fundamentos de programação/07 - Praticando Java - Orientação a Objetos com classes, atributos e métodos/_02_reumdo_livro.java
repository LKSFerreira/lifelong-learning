public class _02_reumdo_livro {

    public static void main(String[] args) {
        // Cria uma instância da classe Livro
        Livro livro = new Livro();

        // Define os atributos do livro com os dados do exemplo
        livro.titulo = "O Guia do Mochileiro das Galáxias";
        livro.autor = "Douglas Adams";
        livro.paginas = 208;

        // Chama o método para exibir as informações do livro
        livro.exibirInfo();
    }

    // Define a classe Livro com os atributos solicitados
    public static class Livro {
        String titulo;
        String autor;
        int paginas;

        /**
         * Implementa um método que usa printf para mostrar os dados no formato:
         * "[TÍTULO]" de [AUTOR] com [PÁGINAS] páginas.
         */
        public void exibirInfo() {
            System.out.printf("\"%s\" de %s com %d páginas%n", titulo, autor, paginas);
        }
    }

}
