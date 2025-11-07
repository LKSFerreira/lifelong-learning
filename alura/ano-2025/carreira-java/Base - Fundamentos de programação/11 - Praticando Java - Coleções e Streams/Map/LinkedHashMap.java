import java.util.LinkedHashMap;
import java.util.Map;

class colecao_LinkedHashMap {
    public static void main(String[] args) {
        // Principais características de LinkedHashMap:
        // 1. Armazena pares CHAVE-VALOR (key-value pairs)
        // 2. NÃO permite chaves duplicadas (valores podem repetir)
        // 3. Permite uma chave null e múltiplos valores null
        // 4. MANTÉM ordem de inserção - diferente do HashMap
        // 5. Baseado em HashMap + Lista duplamente encadeada
        // 6. Operações básicas rápidas: O(1) para get, put, remove
        // 7. Usa hashCode() e equals() para gerenciar as chaves
        // 8. Meio termo entre HashMap (performance) e TreeMap (ordenação)
        // 9. Usa mais memória que HashMap (armazena links da ordem)
        // 10. Ideal quando precisa de Map com ordem previsível de inserção

        System.out.println("=== LINKEDHASHMAP - Mantém ordem de inserção ===\n");

        LinkedHashMap<String, String> contatos = new LinkedHashMap<>();
        
        // Adiciona pares chave-valor
        // Ordem de inserção é preservada
        contatos.put("LKS Ferreira", "(11) 98765-4321");
        contatos.put("Vanny", "(21) 99876-5432");
        contatos.put("iSofy", "(31) 97654-3210");
        contatos.put("Fulano", "(41) 96543-2109");
        
        System.out.println("Agenda de contatos: " + contatos);
        System.out.println("Ordem é exatamente como foi inserido!\n");

        // Adiciona mais um contato
        // Vai para o final na ordem de inserção
        contatos.put("Ciclano", "(51) 95432-1098");
        System.out.println("Adicionou Ciclano: " + contatos + "\n");

        // Tenta adicionar chave duplicada
        // Atualiza valor mas mantém posição original na ordem
        String antigoTelefone = contatos.put("Vanny", "(21) 91111-2222");
        System.out.println("Atualizou telefone de Vanny");
        System.out.println("Telefone antigo: " + antigoTelefone);
        System.out.println("Vanny mantém posição original: " + contatos + "\n");

        // Busca valor pela chave
        // Complexidade: O(1)
        String telefone = contatos.get("LKS Ferreira");
        System.out.println("Telefone de LKS Ferreira: " + telefone);

        // Busca chave inexistente
        telefone = contatos.get("João");
        System.out.println("Telefone de João: " + telefone + "\n");

        // Verifica se contém chave
        boolean temChave = contatos.containsKey("iSofy");
        System.out.println("Tem contato de iSofy? " + temChave);

        temChave = contatos.containsKey("Maria");
        System.out.println("Tem contato de Maria? " + temChave + "\n");

        // Verifica se contém valor
        boolean temValor = contatos.containsValue("(31) 97654-3210");
        System.out.println("Alguém tem telefone (31) 97654-3210? " + temValor + "\n");

        // Tamanho do map
        System.out.println("Quantidade de contatos: " + contatos.size() + "\n");

        // Remove elemento pela chave
        // Ordem dos demais é mantida
        String removido = contatos.remove("Fulano");
        System.out.println("Removeu Fulano (telefone " + removido + ")");
        System.out.println("Ordem preservada: " + contatos + "\n");

        // Adiciona mais elementos para demonstrar ordem
        contatos.put("Beltrano", "(61) 94321-0987");
        contatos.put("Maria", "(71) 93210-9876");
        System.out.println("Adicionou Beltrano e Maria: " + contatos + "\n");

        // Iteração sobre as chaves
        // Ordem é EXATAMENTE como foram inseridos
        System.out.println("=== Iterando sobre chaves (ordem garantida) ===");
        for (String nome : contatos.keySet()) {
            System.out.println("  - " + nome);
        }

        // Iteração sobre os valores
        // Ordem corresponde à ordem das chaves
        System.out.println("\n=== Iterando sobre valores (ordem garantida) ===");
        for (String tel : contatos.values()) {
            System.out.println("  - " + tel);
        }

        // Iteração sobre pares chave-valor
        // Ordem é sempre previsível
        System.out.println("\n=== Iterando sobre pares (ordem de inserção) ===");
        for (Map.Entry<String, String> entry : contatos.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        // Demonstra que a ordem é sempre a mesma
        System.out.println("\n=== Iterando novamente - ordem idêntica ===");
        for (String nome : contatos.keySet()) {
            System.out.print(nome + " -> ");
        }
        System.out.println("FIM");

        // Exemplo: LinkedHashMap como cache LRU (Least Recently Used)
        // Ordem de acesso ao invés de ordem de inserção
        System.out.println("\n=== LinkedHashMap com ordem de acesso (LRU Cache) ===");
        LinkedHashMap<Integer, String> cache = new LinkedHashMap<>(16, 0.75f, true);
        cache.put(1, "Página A");
        cache.put(2, "Página B");
        cache.put(3, "Página C");
        
        System.out.println("Cache inicial: " + cache);
        
        // Acessa página A - ela vai para o final
        cache.get(1);
        System.out.println("Após acessar página A: " + cache);
    }
}
