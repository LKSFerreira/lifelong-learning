import java.util.LinkedList;
import java.util.List;

class colecao_LinkedList {
    public static void main(String[] args) {
        // Principais características de LinkedList:
        // 1. Baseada em lista duplamente encadeada (cada nó aponta para anterior e próximo)
        // 2. Eficiente para inserções/remoções no início e fim: O(1)
        // 3. Busca por índice é lenta: O(n) - precisa percorrer os nós
        // 4. Usa mais memória que ArrayList (armazena referências anterior/próximo)
        // 5. Implementa Deque - pode ser usada como fila ou pilha
        // 6. Ideal quando há muitas inserções/remoções no meio da lista

        LinkedList<String> nomes = new LinkedList<>(List.of("LKS Ferreira", "Vanny", "iSofy", "Fulano", "Fulano"));
        System.out.println("Pessoas na lista: " + nomes);

        // Adiciona elemento ao final
        // LinkedList: eficiente O(1) - apenas ajusta ponteiros
        nomes.add("Ciclano");
        System.out.println("Após add: " + nomes);

        // Adiciona no início da lista
        // Método específico de LinkedList (interface Deque)
        // Muito eficiente: O(1)
        nomes.addFirst("Primeiro da Fila");
        System.out.println("Após addFirst: " + nomes);

        // Adiciona no final da lista
        // Equivalente a add(), mas mais explícito
        nomes.addLast("Último da Fila");
        System.out.println("Após addLast: " + nomes);

        // Acessa o primeiro elemento
        var primeiroNome = nomes.getFirst();
        System.out.println("Primeiro nome: " + primeiroNome);

        // Acessa o último elemento
        var ultimoNome = nomes.getLast();
        System.out.println("Último nome: " + ultimoNome);

        // Remove e retorna o primeiro elemento
        // Operação eficiente: O(1)
        var removidoInicio = nomes.removeFirst();
        System.out.println("Removido do início: " + removidoInicio);
        System.out.println("Lista após removeFirst: " + nomes);

        // Remove e retorna o último elemento
        // Operação eficiente: O(1)
        var removidoFim = nomes.removeLast();
        System.out.println("Removido do fim: " + removidoFim);
        System.out.println("Lista após removeLast: " + nomes);

        // Acesso por índice (lento em LinkedList)
        // Complexidade: O(n) - precisa percorrer os nós até o índice
        var terceiroNome = nomes.get(2);
        System.out.println("Terceiro nome (índice 2): " + terceiroNome);
    }
}