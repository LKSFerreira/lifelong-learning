import java.util.HashMap;
import java.util.Map;

public class _06_verificando_se_chave_exite {
    public static void main(String[] args) {
        // Cria o Map para armazenar clientes (ID, Nome)
        Map<Integer, String> clientes = new HashMap<>();

        // Cadastra cinco clientes no sistema
        clientes.put(1, "Maria");
        clientes.put(2, "Marcos");
        clientes.put(3, "Ana");
        clientes.put(4, "Joana");
        clientes.put(5, "Karen");

        // ID que queremos buscar
        int idParaBuscar = 5; // Exemplo: ID existe
        
        // Verifica se a chave (ID) existe no Map
        // containsKey() retorna true se a chave existe, false caso contrário
        if (clientes.containsKey(idParaBuscar)) {
            // Chave existe: recupera o nome do cliente
            String nomeCliente = clientes.get(idParaBuscar);
            System.out.println("O nome do cliente com ID " + idParaBuscar + " é: " + nomeCliente);
        } else {
            // Chave não existe: exibe mensagem de não encontrado
            System.out.println("Cliente com ID " + idParaBuscar + " não encontrado.");
        }

        System.out.println(); // Linha em branco para separar

        // Testando com ID que não existe
        int idInexistente = 6;
        
        if (clientes.containsKey(idInexistente)) {
            String nomeCliente = clientes.get(idInexistente);
            System.out.println("O nome do cliente com ID " + idInexistente + " é: " + nomeCliente);
        } else {
            System.out.println("Cliente com ID " + idInexistente + " não encontrado.");
        }
    }
}
