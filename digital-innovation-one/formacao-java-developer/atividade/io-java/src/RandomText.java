import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class RandomText {
    public static void main(String[] args) {
        try {
            randomText();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao gerar texto aleatório: " + e.getMessage());
        }
    }

    private static void randomText() throws IOException {
        System.out.println("Gerando texto aleatório...");

        File randomFile = new File("random.txt");

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(randomFile));

        int random = 0;
        int contador = 0;
        do {
            // Gera um número aleatório entre 65 e 115, incluindo o 65 e 115;
            random = (int) (Math.random() * 49) + 65;

            bufferedOutputStream.write((char) random);
            bufferedOutputStream.flush();
            contador++;
        
        } while (contador < 10000);

        bufferedOutputStream.close();
        System.out.println("tamnho do arquivo: " + randomFile.length() + " bytes");
    }
}
