package resolvidos;
import java.util.HashMap;
import java.util.Scanner;

public class B1050 {
    public static void main(String[] args) {

        HashMap<String, String> cidades = new HashMap<String, String>();
        cidades.put("61", "Brasilia");
        cidades.put("71", "Salvador");
        cidades.put("11", "Sao Paulo");
        cidades.put("21", "Rio de Janeiro");
        cidades.put("32", "Juiz de Fora");
        cidades.put("19", "Campinas");
        cidades.put("27", "Vitoria");
        cidades.put("31", "Belo Horizonte");

        try (Scanner scanner = new Scanner(System.in)) {
            String ddd = scanner.nextLine();

            // Recupera o valor da chave ddd
            String cidade = cidades.get(ddd);
            System.out.println(cidade == null ? "DDD nao cadastrado" : cidade);
        }
    }
}
