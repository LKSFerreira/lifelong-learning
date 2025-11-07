import java.util.LinkedHashSet;
import java.util.Set;

class colecao_LinkedHashSet {
    public static void main(String[] args) {
        // Principais características de LinkedHashSet:
        // 1. NÃO permite elementos duplicados (herda de Set)
        // 2. MANTÉM ordem de inserção - diferente do HashSet
        // 3. Permite um único elemento null
        // 4. Baseado em HashMap + Lista duplamente encadeada
        // 5. Operações básicas rápidas: O(1) para add, remove, contains
        // 6. Usa hashCode() e equals() para detectar duplicatas
        // 7. Meio termo entre HashSet (performance) e TreeSet (ordenação)
        // 8. Usa mais memória que HashSet (armazena links da ordem)
        // 9. Ideal quando precisa de Set sem duplicatas + ordem previsível

        System.out.println("=== LINKEDHASHSET - Mantém ordem de inserção ===\n");

        LinkedHashSet<String> nomes = new LinkedHashSet<>(Set.of("LKS Ferreira", "Vanny", "iSofy", "Fulano"));
        System.out.println("Pessoas no set: " + nomes);
        System.out.println("Ordem é mantida conforme inserção!\n");

        // Tenta adicionar elemento duplicado
        // LinkedHashSet não permite duplicatas
        boolean adicionado = nomes.add("Fulano");
        System.out.println("Tentou adicionar 'Fulano' novamente: " + adicionado);
        System.out.println("Set continua igual: " + nomes + "\n");

        // Adiciona elemento novo
        // Elemento vai para o final na ordem de inserção
        adicionado = nomes.add("Ciclano");
        System.out.println("Adicionou 'Ciclano': " + adicionado);
        System.out.println("Set atualizado (ordem preservada): " + nomes + "\n");

        // Adiciona mais elementos para demonstrar ordem
        nomes.add("Beltrano");
        nomes.add("Maria");
        System.out.println("Adicionou 'Beltrano' e 'Maria': " + nomes + "\n");

        // Verifica se contém elemento
        // Complexidade: O(1) - usa hash
        boolean contem = nomes.contains("Vanny");
        System.out.println("Contém 'Vanny'? " + contem);

        contem = nomes.contains("Pedro");
        System.out.println("Contém 'Pedro'? " + contem + "\n");

        // Tamanho do set
        System.out.println("Quantidade de elementos: " + nomes.size() + "\n");

        // Remove elemento
        // Ordem dos demais elementos é mantida
        boolean removido = nomes.remove("iSofy");
        System.out.println("Removeu 'iSofy': " + removido);
        System.out.println("Set após remoção (ordem mantida): " + nomes + "\n");

        // Iteração sobre elementos
        // Ordem é EXATAMENTE como foram inseridos
        System.out.println("Iterando sobre LinkedHashSet (ordem garantida):");
        for (String nome : nomes) {
            System.out.println("  - " + nome);
        }

        // Demonstra que a ordem é sempre a mesma
        System.out.println("\nIterando novamente - ordem idêntica:");
        for (String nome : nomes) {
            System.out.print(nome + " -> ");
        }
        System.out.println("FIM");
    }
}
