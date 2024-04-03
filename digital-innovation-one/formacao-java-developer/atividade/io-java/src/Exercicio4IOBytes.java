import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercicio4IOBytes {
    public static void main(String[] args) throws IOException {
        copiarArquivoComBytesStream();
    }

    private static void copiarArquivoComBytesStream() throws IOException {
        File file = new File("random.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        String arquivoNome = file.getName().substring(0, file.getName().indexOf(".")).concat("-copia.txt");

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(arquivoNome));

        int line = 0;
        while ((line = bufferedInputStream.read()) != -1) {
            bufferedOutputStream.write((char) line);
            bufferedOutputStream.flush();
        }

        bufferedInputStream.close();
        bufferedOutputStream.close();

        System.out.println("Arquivo " + arquivoNome + " copiado com sucesso!");

    }
}
