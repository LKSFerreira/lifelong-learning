public class _05_verificando_subtring_em_uma_string {
    public static void main(String[] args) {
        String frase = "O rato roeu a ropa do rei de roma";
        String palavra = "rato";

        boolean contemPalavra= frase.contains(palavra);

        if (contemPalavra) {
            System.out.println("A frase contém a palavra: " + palavra);
        }

    }
}
