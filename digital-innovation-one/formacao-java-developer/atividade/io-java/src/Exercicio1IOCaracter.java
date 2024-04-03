
// Abra o teclado para entrada de dados e recomende 3 filmes para o usuário. Depois escreva os filmes no console.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercicio1IOCaracter {

    public static void main(String[] args) {

        try {
            receberTecladoMostrarConsole();
        } catch (IOException e) {
            System.out.println("Erro ao receber dados do teclado: " + e.getMessage());
        }
    }

    public static void receberTecladoMostrarConsole() throws IOException {

        // InputStream inputStream = System.in;
        // InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        // BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println("Digite o nome de 3 filmes: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();

        // OutputStream outputStream = System.out;
        // OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        // BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        do {

            bufferedWriter.write(line);
            bufferedWriter.newLine();

            line = bufferedReader.readLine();

        } while (!line.isEmpty());

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

}