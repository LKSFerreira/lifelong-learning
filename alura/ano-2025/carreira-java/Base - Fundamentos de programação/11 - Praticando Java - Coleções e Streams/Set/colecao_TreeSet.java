import java.util.Set;
import java.util.TreeSet;

class colecao_TreeSet {
    public static void main(String[] args) {
        // Principais características de TreeSet:
        // 1. NÃO permite elementos duplicados (herda de Set)
        // 2. ORDENA elementos automaticamente (ordem natural ou Comparator)
        // 3. NÃO permite elementos null (lança NullPointerException)
        // 4. Baseado em Red-Black Tree (árvore binária balanceada)
        // 5. Operações básicas: O(log n) para add, remove, contains
        // 6. Mais lento que HashSet e LinkedHashSet
        // 7. Elementos precisam ser Comparable ou usar Comparator
        // 8. Possui métodos exclusivos: first(), last(), headSet(), tailSet()
        // 9. Ideal quando precisa de Set ordenado e sem duplicatas

        System.out.println("=== TREESET - Ordenação automática ===\n");

        // Elementos inseridos fora de ordem
        TreeSet<String> nomes = new TreeSet<>(Set.of("Vanny", "LKS Ferreira", "Fulano", "iSofy"));
        System.out.println("Inserido: Vanny, LKS Ferreira, Fulano, iSofy");
        System.out.println("TreeSet ordenado: " + nomes);
        System.out.println("Ordem alfabética automática!\n");

        // Tenta adicionar elemento duplicado
        boolean adicionado = nomes.add("Fulano");
        System.out.println("Tentou adicionar 'Fulano' novamente: " + adicionado);
        System.out.println("Set continua igual: " + nomes + "\n");

        // Adiciona elemento novo
        // Será inserido na posição ordenada correta
        adicionado = nomes.add("Ciclano");
        System.out.println("Adicionou 'Ciclano': " + adicionado);
        System.out.println("Set reordenado automaticamente: " + nomes + "\n");

        // Adiciona mais elementos
        nomes.add("Beltrano");
        nomes.add("Ana");
        nomes.add("Zeca");
        System.out.println("Adicionou: Beltrano, Ana, Zeca");
        System.out.println("Tudo ordenado: " + nomes + "\n");

        // Verifica se contém elemento
        // Complexidade: O(log n) - busca na árvore
        boolean contem = nomes.contains("Vanny");
        System.out.println("Contém 'Vanny'? " + contem + "\n");

        // Métodos exclusivos do TreeSet
        System.out.println("=== Métodos especiais do TreeSet ===");
        
        // Primeiro elemento (menor na ordenação)
        String primeiro = nomes.first();
        System.out.println("Primeiro elemento: " + primeiro);

        // Último elemento (maior na ordenação)
        String ultimo = nomes.last();
        System.out.println("Último elemento: " + ultimo + "\n");

        // Subconjunto menor que "Fulano" (exclusive)
        Set<String> menoresQue = nomes.headSet("Fulano");
        System.out.println("Elementos < 'Fulano': " + menoresQue);

        // Subconjunto maior ou igual a "Fulano" (inclusive)
        Set<String> maioresQue = nomes.tailSet("Fulano");
        System.out.println("Elementos >= 'Fulano': " + maioresQue + "\n");

        // Subconjunto entre dois elementos
        Set<String> entre = nomes.subSet("Ciclano", "LKS Ferreira");
        System.out.println("Elementos entre 'Ciclano' e 'LKS Ferreira': " + entre + "\n");

        // Remove elemento
        boolean removido = nomes.remove("iSofy");
        System.out.println("Removeu 'iSofy': " + removido);
        System.out.println("Set após remoção (ainda ordenado): " + nomes + "\n");

        // Iteração sobre elementos
        // Ordem é SEMPRE crescente (alfabética para Strings)
        System.out.println("Iterando sobre TreeSet (ordem alfabética):");
        for (String nome : nomes) {
            System.out.println("  - " + nome);
        }

        // Demonstra ordenação com números
        System.out.println("\n=== TreeSet com números ===");
        TreeSet<Integer> numeros = new TreeSet<>(Set.of(5, 1, 9, 3, 7, 2));
        System.out.println("Inserido: 5, 1, 9, 3, 7, 2");
        System.out.println("Ordenado automaticamente: " + numeros);
        System.out.println("Primeiro (menor): " + numeros.first());
        System.out.println("Último (maior): " + numeros.last());
    }
}
