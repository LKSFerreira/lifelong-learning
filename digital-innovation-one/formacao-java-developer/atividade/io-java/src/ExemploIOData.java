import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ExemploIOData {
    public static void main(String[] args) {
        try {
            
            incluirProduto();

        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo" + e.getMessage());
        }
    }

    private static void incluirProduto() throws IOException {

        File arquivo = new File("data/produtos.bin");

        PrintStream ps = new PrintStream(System.out);
        ps.flush();

        DataOutputStream dos = new DataOutputStream(new FileOutputStream(arquivo.getPath()));
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do produto: ");
        String nome = sc.nextLine();
        dos.writeUTF(nome);

        System.out.println("Tamanho da peça (P, M, G): ");
        char tamanho = sc.next().charAt(0);
        dos.writeChar(tamanho);

        System.out.println("Digite a quantidade do produto: ");
        int quantidade = sc.nextInt();
        dos.writeInt(quantidade);

        System.out.println("Digite o preço do produto: ");
        double preco = sc.nextDouble();
        dos.writeDouble(preco);

        dos.close();
        sc.close();

        lerProdutos(arquivo.getPath());

        ps.close();

    }

    private static void lerProdutos(String arquivoPath) throws IOException {
        File arquivo = new File(arquivoPath);

        DataInputStream dis = new DataInputStream(new FileInputStream(arquivo.getPath()));

        String nome = dis.readUTF();
        char tamanho = dis.readChar();
        int quantidade = dis.readInt();
        double preco = dis.readDouble();

        System.out.println("Nome: " + nome);
        System.out.println("Tamanho: " + tamanho);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Preço: " + preco);

        dis.close();
        
    }
}