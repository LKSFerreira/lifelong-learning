import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Gato;

public class Exercicio5Object {
    public static void main(String[] args) {

        // A palavra reservada transient é usada para indicar que um atributo não deve
        // ser serializado, ou seja, caso a classe seja serializada, o atributo não será
        // persistido e a deserialização do objeto não irá recuperar o valor do atributo.

        try {
            serializar();
            System.out.println("=============================================");
            deserializar("data/gato");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void deserializar(String path) throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Gato objetoGato = (Gato) ois.readObject();
        ois.close();

        System.out.println("Nome do gato: " + objetoGato.getNome());
        System.out.println("Idade do gato: " + objetoGato.getIdade());
        System.out.println("Cor do gato: " + objetoGato.getCor());

        System.out.println(objetoGato);
    }

    private static void serializar() throws FileNotFoundException, IOException {
        Gato gato = new Gato("Mingau", 6, "Branco");

        File arquivo = new File("data/gato");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo.getPath()));
        oos.writeObject(gato);

        System.out.println("Serializado objeto: " + gato.toString() + " no arquivo: " + arquivo.getPath()
                + " com sucesso!, taamanho do arquivo: " + arquivo.length() + " bytes");

        oos.close();

    }
}
