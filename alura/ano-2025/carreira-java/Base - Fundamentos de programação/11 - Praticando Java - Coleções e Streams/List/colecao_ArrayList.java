import java.util.ArrayList;
import java.util.List;

class colecao_ArrayList {
    public static void main(String[] args) {
        // Principais características de List:
        // 1. Coleção ordenada - mantém a ordem de inserção
        // 2. Permite elementos duplicados (ex: "Fulano" aparece 2x)
        // 3. Acesso por índice (baseado em zero)
        // 4. Permite elementos nulos
        // 5. Implementações principais: ArrayList, LinkedList, Vector

        // ArrayList é a implementação mais usada de List
        // Baseada em array dinâmico: busca rápida O(1), inserção no final eficiente
        List<String> nomes = new ArrayList<>(List.of("LKS Ferreira", "Vanny", "iSofy", "Fulano", "Fulano"));
        System.out.println("Pessoas na lista: " + nomes);

        // Adiciona elemento ao final da lista
        // Complexidade: O(1) amortizado
        nomes.add("Ciclano");
        System.out.println("Pessoas na lista: " + nomes);

        // Acessa o primeiro elemento (índice 0)
        // Método moderno introduzido no Java 21
        var primeiroNome = nomes.getFirst();
        System.out.println("Primeiro nome: " + primeiroNome);

        // Acessa o último elemento
        // Equivalente a nomes.get(nomes.size() - 1)
        var ultimoNome = nomes.getLast();
        System.out.println("Último nome: " + ultimoNome);

    }
}