import java.util.List;
import java.util.Vector;

class colecao_Vector {
    public static void main(String[] args) {
        // Principais características de Vector:
        // 1. Classe legada (desde Java 1.0, antes do Collections Framework)
        // 2. Sincronizado (thread-safe) - todos os métodos são synchronized
        // 3. Baseado em array dinâmico como ArrayList
        // 4. Mais lento que ArrayList devido à sincronização
        // 5. Quando cheio, aumenta 100% (ArrayList aumenta 50%)
        // 6. Uso recomendado APENAS quando necessita thread-safety
        // 7. Para novos projetos, prefira Collections.synchronizedList(ArrayList)

        Vector<String> nomes = new Vector<>(List.of("LKS Ferreira", "Vanny", "iSofy", "Fulano", "Fulano"));
        System.out.println("Pessoas no vector: " + nomes);

        // Capacidade inicial e atual
        // Vector cresce 100% quando cheio (ArrayList cresce 50%)
        System.out.println("Capacidade atual: " + nomes.capacity());
        System.out.println("Tamanho atual: " + nomes.size());

        // Adiciona elemento (método sincronizado)
        // Thread-safe, mas mais lento que ArrayList
        nomes.add("Ciclano");
        System.out.println("Após add: " + nomes);

        // Acessa o primeiro elemento
        // Também sincronizado
        var primeiroNome = nomes.getFirst();
        System.out.println("Primeiro nome: " + primeiroNome);

        // Acessa o último elemento
        var ultimoNome = nomes.getLast();
        System.out.println("Último nome: " + ultimoNome);

        // Método legado específico do Vector
        // firstElement() é equivalente a getFirst()
        var primeiro = nomes.firstElement();
        System.out.println("Primeiro (método legado): " + primeiro);

        // Método legado específico do Vector
        // lastElement() é equivalente a getLast()
        var ultimo = nomes.lastElement();
        System.out.println("Último (método legado): " + ultimo);

        // Acesso por índice
        // Rápido como ArrayList: O(1)
        var terceiroNome = nomes.get(2);
        System.out.println("Terceiro nome (índice 2): " + terceiroNome);

        // Remove elemento por índice (sincronizado)
        nomes.remove(0);
        System.out.println("Após remover índice 0: " + nomes);

        // Verifica capacidade após inserções
        System.out.println("Capacidade final: " + nomes.capacity());
        System.out.println("Tamanho final: " + nomes.size());
    }
}