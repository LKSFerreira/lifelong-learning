import java.io.File;
import java.text.SimpleDateFormat;

public class ExemploFile {
    public static void main(String[] args) throws Exception {
        File file = new File("arquivo.txt");

        System.out.println("Arquivo criado: " + file.createNewFile());
        System.out.println("Nome do arquivo: " + file.getName());
        System.out.println("Caminho do arquivo: " + file.getPath());
        System.out.println("Caminho absoluto do arquivo: " + file.getAbsolutePath());
        System.out.println("Diretório pai do arquivo: " + file.getParent());
        System.out.println("O Arquivo " + (file.exists() ? "existe" : "não existe"));
        System.out.println(file.canWrite() ? "Pode ser escrito" : "Não pode ser escrito");
        System.out.println(file.canRead() ? "Pode ser lido" : "Não pode ser lido");
        System.out.println(file.isDirectory() ? "É um diretório" : "Não é um diretório");
        System.out.println(file.isFile() ? "É um arquivo" : "Não é um arquivo");
        System.out.println(file.isAbsolute() ? "É absoluto" : "Não é absoluto");
        System.out.println("Última modificação: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(file.lastModified()));
        System.out.println("Tamanho do arquivo: " + file.length() + " bytes");
        System.out.println("Arquivo renomeado para: " + file.renameTo(new File("arquivoRenomeado.txt")));
        file = new File("arquivoRenomeado.txt");
        System.out.println("Arquivo deletado: " + file.delete());

    }
}
