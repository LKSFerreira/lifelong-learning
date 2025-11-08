import java.util.HashMap;
import java.util.Map;

public class _05_criando_map_de_clientes {
    public static void main(String[] args) {
        // Cria o Map para armazenar clientes (ID, Nome)
        // HashMap armazena pares chave-valor
        Map<Integer, String> clientes = new HashMap<>();

        // Cadastra três clientes
        // Método put(chave, valor) adiciona pares ao Map
        clientes.put(1, "João");
        clientes.put(2, "Marcos");
        clientes.put(3, "Ana");

        // Recupera o nome do cliente com ID igual a 2
        // Método get(chave) retorna o valor associado à chave
        String nomeCliente = clientes.get(2);

        // Exibe a saída conforme especificado
        System.out.println("O nome do cliente com ID 2 é: " + nomeCliente);
    }
}
