public class _03_substituindo_parte_de_uma_string {
    public static void main(String[] args) {
        String frase = "O gato caça o rato";
        String novaFrase = frase.replace("gato", "cachorro");
        System.out.println(novaFrase);
    }
}
