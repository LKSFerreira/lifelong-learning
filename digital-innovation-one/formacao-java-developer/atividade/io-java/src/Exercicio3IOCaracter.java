import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class Exercicio3IOCaracter {
    public static void main(String[] args) {
        try {
            copiarArquivoAdicionandoInformacoes();
        } catch (IOException e) {
            System.out.println("Erro ao adicionar informações em arquivo: " + e.getMessage());
        }
    }

    private static void copiarArquivoAdicionandoInformacoes() throws IOException {
        File file = new File("filmes.txt");
        String arquivoNome = file.getName();

        // Reader reader = new FileReader(arquivoNome);
        // BufferedReader bufferedReader = new BufferedReader(reader);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(arquivoNome));
        String line = bufferedReader.readLine();

        String arquivoNomeCopia = arquivoNome.substring(0, arquivoNome.indexOf(".")).concat("-copia.txt");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arquivoNomeCopia, StandardCharsets.UTF_8));

        do {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            line = bufferedReader.readLine();
        } while (line != null);

        System.out.println("Arquivo " + arquivoNome + " copiado com sucesso!");
        System.out.println("Arquivo " + arquivoNomeCopia + " criado com sucesso!");

        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println("Escreva 3 filmes para recomendar: ");
        printWriter.flush();
        printWriter.close();

        adicionarInformacoesEmArquivo(arquivoNomeCopia);

        bufferedReader.close();
        bufferedWriter.close();

    }

    private static void adicionarInformacoesEmArquivo(String arquivoNomeCopia) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arquivoNomeCopia, true));

        do {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            line = bufferedReader.readLine();
        } while (!line.equals("fim"));

        System.out.println("Arquivo " + arquivoNomeCopia + " atualizado com sucesso!");

        bufferedReader.close();
        bufferedWriter.close();

    }
}
