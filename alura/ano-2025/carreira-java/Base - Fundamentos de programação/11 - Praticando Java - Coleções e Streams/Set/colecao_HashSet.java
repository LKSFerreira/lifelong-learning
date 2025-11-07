import java.util.HashSet;
import java.util.Set;

public class colecao_HashSet {
    public static void main(String[] args) {
        // Principais características de HashSet:
        // 1. NÃO permite elementos duplicados - característica fundamental de Set
        // 2. NÃO mantém ordem de inserção - elementos ficam "embaralhados"
        // 3. Permite um único elemento null
        // 4. Baseado em HashMap (usa tabela hash internamente)
        // 5. Operações básicas muito rápidas: O(1) para add, remove, contains
        // 6. Usa hashCode() e equals() para detectar duplicatas
        // 7. Mais rápido entre as implementações de Set
        // 8. Ideal quando não importa a ordem e precisa de performance

        System.out.println("=== HASHSET - Sem ordenação, máxima performance ===\n");

        HashSet<String> nomes = new HashSet<>(Set.of("LKS Ferreira", "Vanny", "iSofy", "Fulano"));
        System.out.println("Pessoas no set: " + nomes);
        System.out.println("Ordem dos elementos é imprevisível!\n");

        // Tenta adicionar elemento duplicado
        // HashSet não permite duplicatas - retorna false
        boolean adicionado = nomes.add("Fulano");
        System.out.println("Tentou adicionar 'Fulano' novamente: " + adicionado);
        System.out.println("Set continua igual: " + nomes + "\n");

        // Adiciona elemento novo
        // Complexidade: O(1) - muito rápido
        adicionado = nomes.add("Ciclano");
        System.out.println("Adicionou 'Ciclano': " + adicionado);
        System.out.println("Set atualizado: " + nomes + "\n");

        // Verifica se contém elemento
        // Complexidade: O(1) - usa hash para busca rápida
        boolean contem = nomes.contains("Vanny");
        System.out.println("Contém 'Vanny'? " + contem);

        contem = nomes.contains("João");
        System.out.println("Contém 'João'? " + contem + "\n");

        // Tamanho do set
        System.out.println("Quantidade de elementos: " + nomes.size() + "\n");

        // Remove elemento
        // Complexidade: O(1)
        boolean removido = nomes.remove("iSofy");
        System.out.println("Removeu 'iSofy': " + removido);
        System.out.println("Set após remoção: " + nomes + "\n");

        // Iteração sobre elementos
        // Ordem não é garantida e pode mudar entre execuções
        System.out.println("Iterando sobre o HashSet:");
        for (String nome : nomes) {
            System.out.println("  - " + nome);
        }

        // Limpa todo o set
        nomes.clear();
        System.out.println("\nSet após clear: " + nomes);
        System.out.println("Está vazio? " + nomes.isEmpty());
    }
}
