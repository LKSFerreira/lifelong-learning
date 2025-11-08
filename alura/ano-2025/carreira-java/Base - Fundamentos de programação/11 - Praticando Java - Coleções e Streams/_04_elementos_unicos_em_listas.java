import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class _04_elementos_unicos_em_listas {
    public static void main(String[] args) {
        // 1. Criamos a lista inicial com os eventos, incluindo duplicatas.
        List<String> eventos = new ArrayList<>();
        eventos.add("IA Conference Brasil");
        eventos.add("AI Summit");
        eventos.add("DevFest");
        eventos.add("Cloud Expo");
        eventos.add("IA Conference Brasil"); // Duplicata
        eventos.add("DevFest"); // Duplicata

        System.out.println("Lista original com duplicatas: " + eventos);

        // 2. Para obter elementos únicos, convertemos a List para um Set.
        // Um Set é uma coleção que não permite elementos duplicados.
        // Usamos LinkedHashSet para manter a ordem de inserção original.
        // Se a ordem não importasse, poderíamos usar HashSet, que é um pouco mais rápido.
        Set<String> eventosUnicos = new LinkedHashSet<>(eventos);

        // 3. Exibimos o resultado.
        System.out.println("Lista de eventos únicos: " + eventosUnicos);
    }
}
