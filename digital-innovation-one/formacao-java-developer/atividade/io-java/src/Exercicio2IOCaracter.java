import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercicio2IOCaracter {
    public static void main(String[] args) {
        try {
            lerTecladoEscreverArquivo();
        } catch (IOException e) {
            System.out.println("Erro ao ler teclado e escrever arquivo: " + e.getMessage());
        }
    }

    public static void lerTecladoEscreverArquivo() throws IOException {
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println("Digite o nome de 3 filmes: ");
        printWriter.flush();

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        File file = new File("filmes.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getName()));

        do {

            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            line = scanner.nextLine();
            
        } while (!line.equalsIgnoreCase("fim"));

        printWriter.println("O arquivo " + file.getName() + " foi criado com sucesso!");
        printWriter.close();
        scanner.close();
        bufferedWriter.close();
    }
}
