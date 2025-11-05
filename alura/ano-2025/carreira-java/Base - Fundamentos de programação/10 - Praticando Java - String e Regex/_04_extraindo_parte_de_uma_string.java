public class _04_extraindo_parte_de_uma_string {
    public static void main(String[] args) {
        String arquivo = "relatorio_final.pdf";
        String nomeArquivo = arquivo.substring(0, arquivo.length() - 4);
        System.out.println(nomeArquivo);
    }
}
