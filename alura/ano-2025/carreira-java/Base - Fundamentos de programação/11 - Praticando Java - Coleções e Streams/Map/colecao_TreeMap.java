import java.util.Map;
import java.util.TreeMap;

class colecao_TreeMap {
    public static void main(String[] args) {
        // Principais características de TreeMap:
        // 1. Armazena pares CHAVE-VALOR (key-value pairs)
        // 2. NÃO permite chaves duplicadas (valores podem repetir)
        // 3. NÃO permite chave null (lança NullPointerException)
        // 4. Permite valores null
        // 5. ORDENA elementos automaticamente pela chave (ordem natural ou Comparator)
        // 6. Baseado em Red-Black Tree (árvore binária balanceada)
        // 7. Operações básicas: O(log n) para get, put, remove
        // 8. Mais lento que HashMap e LinkedHashMap
        // 9. Chaves precisam ser Comparable ou usar Comparator
        // 10. Possui métodos exclusivos: firstKey(), lastKey(), headMap(), tailMap()
        // 11. Ideal quando precisa de Map ordenado pelas chaves

        System.out.println("=== TREEMAP - Ordenação automática por chave ===\n");

        TreeMap<String, String> contatos = new TreeMap<>();
        
        // Adiciona pares chave-valor fora de ordem
        // TreeMap ordena automaticamente pelas chaves
        contatos.put("Vanny", "(21) 99876-5432");
        contatos.put("LKS Ferreira", "(11) 98765-4321");
        contatos.put("Fulano", "(41) 96543-2109");
        contatos.put("iSofy", "(31) 97654-3210");
        
        System.out.println("Inserido: Vanny, LKS Ferreira, Fulano, iSofy");
        System.out.println("TreeMap ordenado: " + contatos);
        System.out.println("Ordem alfabética automática!\n");

        // Adiciona mais um contato
        // Será inserido na posição ordenada correta
        contatos.put("Ciclano", "(51) 95432-1098");
        System.out.println("Adicionou Ciclano");
        System.out.println("Reordenado automaticamente: " + contatos + "\n");

        // Tenta adicionar chave duplicada
        // Atualiza valor e mantém ordenação
        String antigoTelefone = contatos.put("Vanny", "(21) 91111-2222");
        System.out.println("Atualizou telefone de Vanny");
        System.out.println("Telefone antigo: " + antigoTelefone);
        System.out.println("TreeMap ordenado: " + contatos + "\n");

        // Busca valor pela chave
        // Complexidade: O(log n) - busca na árvore
        String telefone = contatos.get("LKS Ferreira");
        System.out.println("Telefone de LKS Ferreira: " + telefone);

        // Busca chave inexistente
        telefone = contatos.get("João");
        System.out.println("Telefone de João: " + telefone + "\n");

        // Verifica se contém chave
        // Complexidade: O(log n)
        boolean temChave = contatos.containsKey("iSofy");
        System.out.println("Tem contato de iSofy? " + temChave + "\n");

        // Adiciona mais elementos para demonstrar ordenação
        contatos.put("Ana", "(61) 94321-0987");
        contatos.put("Zeca", "(71) 93210-9876");
        contatos.put("Beltrano", "(81) 92109-8765");
        
        System.out.println("Adicionou: Ana, Zeca, Beltrano");
        System.out.println("Tudo ordenado: " + contatos + "\n");

        // Métodos exclusivos do TreeMap
        System.out.println("=== Métodos especiais do TreeMap ===");
        
        // Primeira chave (menor na ordenação)
        String primeiraChave = contatos.firstKey();
        System.out.println("Primeira chave: " + primeiraChave);
        System.out.println("Primeiro contato: " + primeiraChave + " -> " + contatos.get(primeiraChave));

        // Última chave (maior na ordenação)
        String ultimaChave = contatos.lastKey();
        System.out.println("Última chave: " + ultimaChave);
        System.out.println("Último contato: " + ultimaChave + " -> " + contatos.get(ultimaChave) + "\n");

        // Primeira entrada completa (chave + valor)
        Map.Entry<String, String> primeiraEntry = contatos.firstEntry();
        System.out.println("Primeira entrada: " + primeiraEntry.getKey() + " -> " + primeiraEntry.getValue());

        // Última entrada completa
        Map.Entry<String, String> ultimaEntry = contatos.lastEntry();
        System.out.println("Última entrada: " + ultimaEntry.getKey() + " -> " + ultimaEntry.getValue() + "\n");

        // Submap: chaves menores que "Fulano" (exclusive)
        Map<String, String> menoresQue = contatos.headMap("Fulano");
        System.out.println("Contatos < 'Fulano': " + menoresQue);

        // Submap: chaves maiores ou iguais a "Fulano" (inclusive)
        Map<String, String> maioresQue = contatos.tailMap("Fulano");
        System.out.println("Contatos >= 'Fulano': " + maioresQue + "\n");

        // Submap entre duas chaves
        Map<String, String> entre = contatos.subMap("Ciclano", "LKS Ferreira");
        System.out.println("Contatos entre 'Ciclano' e 'LKS Ferreira': " + entre + "\n");

        // Remove elemento pela chave
        String removido = contatos.remove("Fulano");
        System.out.println("Removeu Fulano (telefone " + removido + ")");
        System.out.println("TreeMap ainda ordenado: " + contatos + "\n");

        // Iteração sobre as chaves
        // Ordem é SEMPRE crescente (alfabética)
        System.out.println("=== Iterando sobre chaves (ordem alfabética) ===");
        for (String nome : contatos.keySet()) {
            System.out.println("  - " + nome);
        }

        // Iteração sobre pares chave-valor
        // Ordem alfabética das chaves
        System.out.println("\n=== Iterando sobre pares (ordem alfabética) ===");
        for (Map.Entry<String, String> entry : contatos.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        // Exemplo com Integer como chave
        System.out.println("\n=== TreeMap com Integer (ordem numérica) ===");
        TreeMap<Integer, String> ranking = new TreeMap<>();
        ranking.put(3, "Bronze");
        ranking.put(1, "Ouro");
        ranking.put(2, "Prata");
        ranking.put(5, "Participação");
        ranking.put(4, "Honra ao Mérito");
        
        System.out.println("Inserido: 3, 1, 2, 5, 4");
        System.out.println("Ordenado automaticamente: " + ranking);
        System.out.println("Primeira colocação: " + ranking.firstKey() + " -> " + ranking.get(ranking.firstKey()));
        System.out.println("Última colocação: " + ranking.lastKey() + " -> " + ranking.get(ranking.lastKey()));
    }
}
