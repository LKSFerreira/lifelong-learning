
import java.util.ArrayList;
import java.util.List;

public class _02_removendo_elementos {
    public static void main(String[] args) {
        // Para criar uma lista mutável com valores iniciais, usamos new ArrayList<>(List.of(...))
        List<String> alunos = new ArrayList<>(List.of("LKS Ferreira", "Vanny", "iSofy", "Fulano", "Cilclno"));

        System.out.println(alunos);

        alunos.remove(3);
        System.out.println(alunos);

        alunos.remove("Cilclno");
        System.out.println(alunos);

    }
}
