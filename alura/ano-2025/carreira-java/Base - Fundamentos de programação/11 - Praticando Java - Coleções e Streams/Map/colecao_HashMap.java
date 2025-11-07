import java.util.HashMap;
import java.util.Map;

class colecao_HashMap {
    public static void main(String[] args) {
        // Principais características de HashMap:
        // 1. Armazena pares CHAVE-VALOR (key-value pairs)
        // 2. NÃO permite chaves duplicadas (valores podem repetir)
        // 3. Permite uma chave null e múltiplos valores null
        // 4. NÃO mantém ordem de inserção - elementos ficam "embaralhados"
        // 5. Baseado em tabela hash (hash table)
        // 6. Operações básicas muito rápidas: O(1) para get, put, remove
        // 7. Usa hashCode() e equals() para gerenciar as chaves
        // 8. Mais rápido entre as implementações de Map
        // 9. Ideal quando não importa a ordem e precisa de performance máxima

        System.out.println("=== HASHMAP - Pares chave-valor, máxima performance ===\n");

        HashMap<String, String> contatos = new HashMap<>();
        
        // Adiciona pares chave-valor
        // Chave = nome, Valor = telefone
        // Complexidade: O(1)
        contatos.put("LKS Ferreira", "(11) 98765-4321");
        contatos.put("Vanny", "(21) 99876-5432");
        contatos.put("iSofy", "(31) 97654-3210");
        contatos.put("Fulano", "(41) 96543-2109");
        
        System.out.println("Agenda de contatos: " + contatos);
        System.out.println("Ordem é imprevisível!\n");

        // Adiciona mais um contato
        contatos.put("Ciclano", "(51) 95432-1098");
        System.out.println("Adicionou Ciclano: " + contatos + "\n");

        // Tenta adicionar chave duplicada
        // HashMap substitui o valor anterior
        String antigoTelefone = contatos.put("Vanny", "(21) 91111-2222");
        System.out.println("Atualizou telefone de Vanny");
        System.out.println("Telefone antigo: " + antigoTelefone);
        System.out.println("Novo telefone: " + contatos.get("Vanny") + "\n");

        // Busca valor pela chave
        // Complexidade: O(1) - muito rápido
        String telefone = contatos.get("LKS Ferreira");
        System.out.println("Telefone de LKS Ferreira: " + telefone);

        // Busca chave inexistente retorna null
        telefone = contatos.get("João");
        System.out.println("Telefone de João: " + telefone + "\n");

        // Verifica se contém chave
        // Complexidade: O(1)
        boolean temChave = contatos.containsKey("iSofy");
        System.out.println("Tem contato de iSofy? " + temChave);

        temChave = contatos.containsKey("Maria");
        System.out.println("Tem contato de Maria? " + temChave + "\n");

        // Verifica se contém valor
        // Complexidade: O(n) - precisa percorrer todos
        boolean temValor = contatos.containsValue("(31) 97654-3210");
        System.out.println("Alguém tem telefone (31) 97654-3210? " + temValor + "\n");

        // Tamanho do map
        System.out.println("Quantidade de contatos: " + contatos.size() + "\n");

        // Remove elemento pela chave
        // Complexidade: O(1)
        String removido = contatos.remove("Fulano");
        System.out.println("Removeu Fulano (telefone " + removido + ")");
        System.out.println("Agenda após remoção: " + contatos + "\n");

        // Iteração sobre as chaves
        System.out.println("=== Iterando sobre as chaves (keySet) ===");
        for (String nome : contatos.keySet()) {
            System.out.println("  - " + nome);
        }

        // Iteração sobre os valores
        System.out.println("\n=== Iterando sobre os valores (values) ===");
        for (String tel : contatos.values()) {
            System.out.println("  - " + tel);
        }

        // Iteração sobre pares chave-valor (mais comum)
        System.out.println("\n=== Iterando sobre pares chave-valor (entrySet) ===");
        for (Map.Entry<String, String> entry : contatos.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        // Exemplo com diferentes tipos
        System.out.println("\n=== HashMap com Integer como chave ===");
        HashMap<Integer, String> usuarios = new HashMap<>();
        usuarios.put(1, "Admin");
        usuarios.put(2, "LKS Ferreira");
        usuarios.put(3, "Vanny");
        
        System.out.println("Usuários: " + usuarios);
        System.out.println("Usuário ID 2: " + usuarios.get(2));
    }
}
