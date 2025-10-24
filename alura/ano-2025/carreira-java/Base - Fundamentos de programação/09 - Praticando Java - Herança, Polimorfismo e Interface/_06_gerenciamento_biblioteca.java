public class _06_gerenciamento_biblioteca {
    public static void main(String[] args) {

        Livro livro = new Livro("Java Programming", 2020, "John Doe");
        livro.exibirInfo();

        Revista revista = new Revista("Tech Today", 2021, "March Edition");
        revista.exibirInfo();

        ebook ebook = new ebook("Learning Python", 2019, "PDF");
        ebook.exibirInfo();

    }
}

class Midia {
    protected String titulo;
    private int anoPublicacao;

    public Midia(String titulo, int anoPublicacao) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
    }

    private String codigoBiblioteca() {
        return "LIB-" + titulo.substring(0, 3) + anoPublicacao;
    }

    public void exibirInfo() {
        System.out.print(codigoBiblioteca());
    }
}

class Livro extends Midia {
    private String autor;

    public Livro(String titulo, int anoPublicacao, String autor) {
        super(titulo, anoPublicacao);
        this.autor = autor;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println(" | Livro: " + titulo + ", Autor: " + autor);
    }

}

class Revista extends Midia {
    private String edicao;

    public Revista(String titulo, int anoPublicacao, String edicao) {
        super(titulo, anoPublicacao);
        this.edicao = edicao;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println(" | Revista: " + titulo + ", Edição: " + edicao);
    }

}

class ebook extends Midia {
    private String formatoArquivo;

    public ebook(String titulo, int anoPublicacao, String formatoArquivo) {
        super(titulo, anoPublicacao);
        this.formatoArquivo = formatoArquivo;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println(" | eBook: " + titulo + ", Formato: " + formatoArquivo);
    }

}
